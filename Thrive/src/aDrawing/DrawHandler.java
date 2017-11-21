package aDrawing;

import java.awt.Color;
import java.awt.Font;
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
	
		
		tempInventoryIdea();
		
	}
	
	private void tempInventoryIdea(){
		if(Data.mode.equals("game")){
			
			//Hot bar
			for(int i=0; i<9; i++){
				int font = 20;
				int width=(int)( 40*Data.ratioX );
				int height=(int)( 40*Data.ratioY );
				int x=(int)( (i*40+Data.windowWidth/2-(9*40)/2)*Data.ratioX );
				int y= (int)( 520*Data.ratioY );
				
				g.setColor(Color.gray);
				g.fillRect(x,y,width,height);
				
				if( (i)==Data.player.hotKeySelected-1  ){
					g.setColor(Color.red);
				}else{
					g.setColor(Color.yellow);
				}
				g.drawRect(x,y,width,height);
				
				g.setColor(Color.black);
				g.setFont(new Font("arial", 1, (int)Math.round(font*(Data.ratioX*Data.ratioY)/2)+font/2));
				g.drawString( ""+(i+1),x+font/10,(int) ((y+font*(Data.ratioX*Data.ratioY)/2)+font/3)+1 );
				
			}
			
			if(Data.player.inventoryOpen){
				
				for(int i=0; i<4; i++){
					for(int z=0; z<9; z++){
						int width=(int)( 40*Data.ratioX );
						int height=(int)( 40*Data.ratioY );
						int x=(int)( (z*40+Data.windowWidth/2-(9*40)/2)*Data.ratioX );
						int y= (int)( (i*40+Data.windowHeight/2-(4*40)/2)*Data.ratioY );
					
						g.setColor(Color.gray);
						g.fillRect(x,y,width,height);
						
						g.setColor(Color.yellow);
						g.drawRect(x,y,width,height);
					
					}
				}
				
			}
			
		}
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
