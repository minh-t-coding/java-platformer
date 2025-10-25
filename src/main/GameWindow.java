package main;

import javax.swing.JFrame;

public class GameWindow {
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEGHT = 400;

	private JFrame jframe;

	public GameWindow(GamePanel gamePanel) {
		this.jframe = new JFrame();

		jframe.setSize(WINDOW_WIDTH, WINDOW_HEGHT);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
}
