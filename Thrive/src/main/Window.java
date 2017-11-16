package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aaa.Data;

public class Window extends JFrame{

	public Window(JPanel screen){
		super(Data.gameName);
		setSize(Data.windowWidth,Data.windowHeight);
		setResizable(Data.windowResizable);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(screen);
		
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(true);
		addMouseListener(new MouseInput());
		addMouseMotionListener(new MouseInput());
		addKeyListener(new KeyBoardInput());
		
		validate();
	}
	
	public void update(){
		if(this.getWidth()!=Data.currentWindowWidth){
			Data.currentWindowWidth=this.getWidth();
			Data.ratioX=(double)Data.currentWindowWidth/Data.windowWidth;
		}
		if(this.getHeight()!=Data.currentWindowHeight){
			Data.currentWindowHeight=this.getHeight();
			Data.ratioY=(double)Data.currentWindowHeight/Data.windowHeight;
		}
	}
	
}
