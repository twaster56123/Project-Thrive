package a;

import _a_.Data;

public class GameLoopPrimitive implements Runnable{

	private final GameLoop game = new GameLoop();
	
	public void run(){
		while(true){
			while(Data.running){
				game.loop();
			}
		}
	}
	
}
