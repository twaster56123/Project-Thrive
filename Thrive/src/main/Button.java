package main;

import java.awt.Font;

import javax.swing.JButton;

import aaa.Data;
import aaa.Gui;

public class Button extends JButton{
	
	public int font=15;
	public int x=0;
	public int y=0;
	public int width=1;
	public int height=1;
	
	public Button(String text, int x, int y, int width, int height, int font){
		super(text);
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
		this.font=font;
		setSize(width,height);
		setLocation(x,y);
		setFont(new Font("arial", 1, font));
		setVisible(true);
	}
	
	public void update(boolean change){
		if(change){
			this.setSize( (int)(width*Data.ratioX), (int)(height*Data.ratioY) );
			this.setLocation((int)(x*Data.ratioX), (int)(y*Data.ratioY));
			this.setFont(new Font("arial", 1, (int)Math.round(font*(Data.ratioX*Data.ratioY)/2)+font/2));
	
		}
	}
	
}
