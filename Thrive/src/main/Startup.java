package main;

import character.MainHud;
import aaa.Data;
import aaa.Gui;
import aaa.Hud;
import aaa.Items;
import aaaMap.Map;
import aaaMap.MapNode;

public class Startup {

	public static void main(String args[]){
		
		MapNode.temp();
		
		Map._loadImages();
		Items.loadItemIcons();
		Hud.loadImages();
		MainHud.loadImages();
		
		Data.player.loadPlayerImages("res\\characters\\Sarengeti\\", 2);
		
		Screen scr = new Screen();
		Window win = new Window(scr);
		
		Gui.addGui(scr);
		
		//Networking Thread here
		
		Thread gameThread = theGameThread(win, scr);
		gameThread.start();
	
		
	}
	
	
	
	
	
	public static Thread theGameThread(final Window win, final Screen scr){
		final GameLoop game = new GameLoop();
		Thread gameThread = new Thread(
				new Runnable(){
					public void run(){
						while(Data.gameRunning){
							while(true){
								win.update();
								game.loop(scr);
							}
						}
					}
				}
		);
		return(gameThread);
	}
	
}
