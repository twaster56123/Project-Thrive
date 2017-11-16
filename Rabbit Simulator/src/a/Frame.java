package a;

import aa.Screen;
import aa.Window;

public class Frame {

	public static Screen scr = new Screen();
	
	public Frame(){
		
		Window win = new Window("Rabbit Simulator", 1000, 600, false);
		win.add(scr);
		
	}
	
}
