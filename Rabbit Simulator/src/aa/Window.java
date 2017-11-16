package aa;

import javax.swing.JFrame;

public class Window extends JFrame{

	public Window(String title, int width, int height, boolean resizable){
		super(title);
		setSize(width,height);
		setResizable(resizable);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
