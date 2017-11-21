package main;

import aaa.Data;
import aaa.Gui;
import aaa.Hud;
import aaa.Items;
import aaaMap.Map;

public class Startup {

	public static void main(String args[]){
		
		Map._loadImages();
		Items.loadItemIcons();
		Hud.loadImages();
		
	//	Map._import("ProtoMap");
		Map._import("beb");
		Data.player.loadPlayerImages("res\\characters\\Sarengeti\\", 1);
		
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
