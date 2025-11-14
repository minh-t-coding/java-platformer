package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private int xDelta = 0;
    private int yDelta = 0;

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(new MouseInputs(this));
    }

    public void changeXDelta(int xChange) {
        this.xDelta += xChange;
        repaint();
    }

    public void changeYDelta(int yChange) {
        this.yDelta += yChange;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(100 + xDelta, 100 + yDelta, 50, 50);
    }
}
