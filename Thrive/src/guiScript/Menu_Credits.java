package guiScript;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aaa.Data;

public class Menu_Credits implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent action) {
		Data.mode="menu_credits";
	}

}
