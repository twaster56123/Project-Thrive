package aaa;

import guiScript.BackToMenu;
import guiScript.Menu_Credits;
import guiScript.Menu_Play;
import guiScript.Menu_Quit;
import guiScript.Menu_Settings;
import main.Button;
import main.Screen;

public class Gui {

	//Menu
	public static Button menu_play = new Button("Play", 0, 150, 300, 50, 25);
	public static Button menu_settings = new Button("Settings", 0, 200, 300, 50, 25);
	public static Button menu_credits = new Button("Credits", 0, 250, 300, 50, 25);
	public static Button menu_quit = new Button("Quit", 0, 300, 300, 50, 25);
	///...multi
	public static Button backToMenu = new Button("Return", 0, 500, 200, 50, 25);
	
	public static void addGui(Screen scr){
		//...multi
		backToMenu.addActionListener(new BackToMenu());
		scr.add(backToMenu);
		//Menu
		menu_play.addActionListener(new Menu_Play());
		scr.add(menu_play);
		menu_settings.addActionListener(new Menu_Settings());
		scr.add(menu_settings);
		menu_credits.addActionListener(new Menu_Credits());
		scr.add(menu_credits);
		menu_quit.addActionListener(new Menu_Quit());
		scr.add(menu_quit);
	}
	
}
