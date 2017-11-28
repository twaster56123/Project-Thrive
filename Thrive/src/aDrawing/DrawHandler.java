package aDrawing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import character.Camera_View;
import character.MainHud;

import aaa.Data;
import aaa.Hud;
import aaa.Items;
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
		mainHud();
		
	}
	
	private void mainHud(){
		MainHud.draw(g);
	}
	
	private void tempInventoryIdea(){
		if(Data.mode.equals("game")){
			
			int font = 20;
			int width=(int)( Math.round (40*Data.ratioX) );
			int height=(int)( Math.round (40*Data.ratioY) );
			
			//Hot bar
			for(int i=0; i<9; i++){
				int x=(int)( (Math.floor( (double)i*40+Data.windowWidth/2-(9*40)/2)*Data.ratioX ));
				int y= (int)(Math.floor( 520*Data.ratioY ));
				
				g.drawImage(Hud.image[0],x,y,width,height,null);
				
				//icon here
				g.drawImage(Items.icon[Data.player.hotbar[i]], x, y, width, height, null);
				
				if( (i)==Data.player.hotKeySelected-1  ){
					g.drawImage(Hud.image[1],x,y,width,height,null);
				}else{
					g.drawImage(Hud.image[2],x,y,width,height,null);
				}
				
				g.setColor(Color.black);
				g.setFont(new Font("arial", 1, (int)Math.round(font*(Data.ratioX*Data.ratioY)/2)+font/2));
				g.drawString( ""+(i+1),x+font/10,(int) ((y+font*(Data.ratioX*Data.ratioY)/2)+font/3)+1 );
				
			}
			
			if(Data.player.inventoryOpen){
				
				for(int i=0; i<4; i++){
					for(int z=0; z<9; z++){
						int x=(int)( Math.floor( ((double)z*40+Data.windowWidth/2-(9*40)/2)*Data.ratioX) );
						int y= (int)( Math.floor( ((double)i*40+Data.windowHeight/2-(4*40)/2)*Data.ratioY) );
					
						g.drawImage(Hud.image[0],x,y,width,height,null);
						//icon here
						g.drawImage(Items.icon[Data.player.inventory[z][i][0]], x, y, width, height, null);
						g.drawImage(Hud.image[1],x,y,width,height,null);
					
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
