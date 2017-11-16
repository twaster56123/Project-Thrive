package guiScript;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aaa.Data;

public class Menu_Quit implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent action) {
		System.exit(0);
	}

}
