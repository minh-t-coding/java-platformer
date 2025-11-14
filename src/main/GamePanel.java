package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private float xDelta = 0, yDelta = 0;
    private float xDir = 0.2f, yDir = 0.006f;
    private int frames = 0;
    private long lastCheck = 0;

    private Color color;
    private Random random = new Random();

    public GamePanel() {
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

        updateCircle();
        g.setColor(this.color);
        g.fillOval((int) xDelta, (int) yDelta, 50, 50);

    }

    private void updateCircle() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }
    }
}
