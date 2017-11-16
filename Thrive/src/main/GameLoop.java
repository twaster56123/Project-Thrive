package main;

import aKeyBoard.KeyHandler;
import aMouse.MouseHandler;
import aScript.ScriptHandler;
import aaa.Data;

public class GameLoop {

	private double start=0.0;
	private double end=0.0;
	private boolean firstTime=true;
	private double fps=0.0;
	
	private KeyHandler kh = new KeyHandler();
	private MouseHandler mh = new MouseHandler();
	private ScriptHandler sh = new ScriptHandler();
	public void loop(Screen scr){
		
		start=System.nanoTime();
		if(!firstTime){
			Data.delta=(start-end)/1000000000.0;
			fps=1/Data.delta;
		}
		
		if(fps<=60 || firstTime){
			firstTime=false;
			kh.update();
			mh.update();
			sh.update();
			scr.update();
			end=start;
		}
		
	}
	
}
