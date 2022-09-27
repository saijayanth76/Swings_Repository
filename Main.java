package Swings;

import javax.swing.JFrame;

public class Main extends JFrame{
	public static void main(String[] args) {
		Tabs tab = new Tabs();
		tab.setSize(500, 500);
		tab.setVisible(true);
		tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
