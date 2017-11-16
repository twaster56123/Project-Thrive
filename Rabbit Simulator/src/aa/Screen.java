package aa;

import java.awt.Graphics;

import javax.swing.JPanel;

import a.Draw;

public class Screen extends JPanel{

	public Screen(){
		super(null);
		setVisible(true);
	}
	
	Draw draw = new Draw();
	public void paintComponent(Graphics g){
		draw.update(g);
	}
	
	public void updateScreen(){
		repaint();
	}
	
}
