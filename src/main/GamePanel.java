package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import utils.Constants.Directions;
import utils.Constants.PlayerConstants;

public class GamePanel extends JPanel {

    private float xDelta = 0, yDelta = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = PlayerConstants.RUNNING;
    private int playerDir = -1;
    private boolean isMoving = false;

    public GamePanel() {

        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = img.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    private void importImg() {
        try (InputStream is = getClass().getResourceAsStream("/res/player_sprites.png")) {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void setDirection(int direction) {
        this.playerDir = direction;
        this.isMoving = true;
    }

    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    private void setAnimation() {
        if (this.isMoving) {
            playerAction = PlayerConstants.RUNNING;
        } else {
            playerAction = PlayerConstants.IDLE;
        }
    }

    private void updatePos() {
        if (this.isMoving) {
            switch (playerDir) {
                case Directions.LEFT:
                    xDelta -= 5;
                    break;
                case Directions.UP:
                    yDelta -= 5;
                    break;
                case Directions.RIGHT:
                    xDelta += 5;
                    break;
                case Directions.DOWN:
                    yDelta += 5;
                    break;
            }
        }
    }

    public void updateGame() {
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= PlayerConstants.GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }
}
