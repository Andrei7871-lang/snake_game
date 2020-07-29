package snakeGame;
import java.awt.*;
import javax.swing.*;
public class Main_SnakeGame{

	public static void main(String[] args) {
		GamePanel gpanel=new GamePanel();
		JFrame frame=new JFrame();
		frame.setTitle("Snake Game");
		frame.add(gpanel);
		frame.setSize(new Dimension(500,500));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
