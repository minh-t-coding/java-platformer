package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.GamePanel;

public class MouseInputs implements MouseListener {

    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("mouse exited");
    }

}
