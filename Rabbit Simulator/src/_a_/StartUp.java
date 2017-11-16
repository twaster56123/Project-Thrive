package _a_;

import a.Frame;
import a.GameLoopPrimitive;
import b.SimulationSet;

public class StartUp {
	
	public static void main(String args[]){
		
		//Window gui etc
		new Frame();
		
		new SimulationSet(1000, 600, 5, 3);
		
		//Game Loop
		Thread gameThread = new Thread(new GameLoopPrimitive());
		gameThread.start();
		
	}
	
	
}
