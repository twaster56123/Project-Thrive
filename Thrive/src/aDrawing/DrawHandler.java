package aDrawing;

import java.awt.Color;
import java.awt.Graphics;

import character.Camera_View;

import aaa.Data;
import aaaMap.Map;

public class DrawHandler {

	private Graphics g;
	public void update(Graphics g){
		this.g=g;
		
		menu();
		game();
		settings();
		credits();
		
	}
	
	private void game(){
		if(Data.mode.equals("game")){
			g.setColor(Color.black);
			g.fillRect(0,0,(int)(1000*Data.ratioX),(int)(600*Data.ratioY) );
			
			Map._drawStatic(g);
			Map._drawObjects(g);//for rendering reasons, player is drawn from within objects
			
		}
	}
	
	private void menu(){
		if(Data.mode.equals("menu")){
			g.setColor(Color.blue);
			g.fillRect(0,0,(int)(1000*Data.ratioX),(int)(600*Data.ratioY) );
			
		}
	}
	private void settings(){
		if(Data.mode.equals("menu_settings")){
			g.setColor(Color.blue);
			g.fillRect(0,0,(int)(1000*Data.ratioX),(int)(600*Data.ratioY) );
		}
	}
	private void credits(){
		if(Data.mode.equals("menu_credits")){
			g.setColor(Color.blue);
			g.fillRect(0,0,(int)(1000*Data.ratioX),(int)(600*Data.ratioY) );
		}
	}
	
}
