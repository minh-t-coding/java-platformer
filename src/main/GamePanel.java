package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private float xDelta = 0, yDelta = 0;
    private BufferedImage img;

    public GamePanel() {
        importImg();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
    }

    public void changeXDelta(int xChange) {
        this.xDelta += xChange;
    }

    public void changeYDelta(int yChange) {
        this.yDelta += yChange;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img.getSubimage(0, 0, 64, 40), (int) xDelta, (int) yDelta, 128, 80, null);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }
}
