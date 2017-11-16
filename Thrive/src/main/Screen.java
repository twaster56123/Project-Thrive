package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import aDrawing.DrawHandler;


public class Screen extends JPanel{

	public Screen(){
		setLayout(null);
		setDoubleBuffered(true);
	}
	
	DrawHandler dh = new DrawHandler();
	public void paintComponent(Graphics g){
		dh.update(g);
	}
	
	public void update(){
		repaint();
	}
	
}
