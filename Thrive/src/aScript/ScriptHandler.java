package aScript;

import aaa.Data;
import aaa.Gui;
import aaaMap.Map;
import character.Camera_View;

public class ScriptHandler {

	boolean change=false;
	
	public void update(){
		changeDetection();
		CAMERA_FOLLOW_PLAYER();
		MENU_GUI();
		BACKTOMENU_basic();
		
		playerStuff();
		regenStuff();

		change=false;
	}
	
	double previousCheck=0;
	private void regenStuff(){
		//Ticks Every 30 seconds
		if( (System.nanoTime()-previousCheck)/1000000000.0 >=30){
			for(int i=0; i<Map.objectRegenTime.length; i++){
				if(Map.objectNotInUse[i]){
					//Everything is on a 2 min timer for now, specifics can be done
					if(( (System.nanoTime()-Map.objectRegenTime[i])/1000000000.0 ) >= 120.0 ){
						Map.objectNotInUse[i]=!Map.objectNotInUse[i];
					}
				}
			}
			previousCheck = System.nanoTime();
		}
		
	}
	
	private void playerStuff(){
		Data.player.CollisionBlockRendering();
		Data.player.CollisionObjectRendering();
		Data.player.CollisionVoidRendering();
	}
	
	private void MENU_GUI(){
		if(Data.mode.equals("menu")){
			Gui.menu_play.update(change);
			Gui.menu_settings.update(change);
			Gui.menu_credits.update(change);
			Gui.menu_quit.update(change);
			if(!Gui.menu_play.isVisible()){
				Gui.menu_play.setVisible(true);
				Gui.menu_settings.setVisible(true);
				Gui.menu_credits.setVisible(true);
				Gui.menu_quit.setVisible(true);
			}
		}else{
			if(Gui.menu_play.isVisible()){
				Gui.menu_play.setVisible(false);
				Gui.menu_settings.setVisible(false);
				Gui.menu_credits.setVisible(false);
				Gui.menu_quit.setVisible(false);
			}
		}
	}

	private void BACKTOMENU_basic(){
		if(Data.mode.equals("menu_credits")||Data.mode.equals("menu_settings")){
			Gui.backToMenu.update(change);
			if(!Gui.backToMenu.isVisible()){
				Gui.backToMenu.setVisible(true);
			}
		}else{
			if(Gui.backToMenu.isVisible()){
				Gui.backToMenu.setVisible(false);
			}
		}
	}
	
	private void CAMERA_FOLLOW_PLAYER(){
		if(Data.mode.equals("game")){
			Camera_View.x = (-Data.windowWidth+Data.player.width)/2+Data.player.x;
			Camera_View.y = (-Data.windowHeight+Data.player.height)/2+Data.player.y;
			double maxWorldWidth = (double)Map._static.length*33;
			double maxWorldHeight =(double)Map._static[0].length*33;
			if(Camera_View.x<0){
				Camera_View.x=0;
			}
			if(Camera_View.y<0){
				Camera_View.y=0;
			}
			if(Camera_View.x>maxWorldWidth){
				Camera_View.x=maxWorldWidth;
			}
			if(Camera_View.y>maxWorldHeight){
				Camera_View.y=maxWorldHeight;
			}
		}
	}
	
	double ratioX=1;
	double ratioY=1;
	private void changeDetection(){
		if(ratioX!=Data.ratioX || ratioY!=Data.ratioY){
			ratioX=Data.ratioX;
			ratioY=Data.ratioY;
			change=true;
		}
	}
	
}
