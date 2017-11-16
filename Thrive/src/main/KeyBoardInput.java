package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import aKeyBoard.KeyBoardData;

public class KeyBoardInput implements KeyListener{

	@Override
	public void keyPressed(KeyEvent key) {
		KeyBoardData.keysDown[key.getKeyCode()]=true;
	}

	@Override
	public void keyReleased(KeyEvent key) {
		KeyBoardData.keysDown[key.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent key) {
		if(KeyBoardData.typed==' '){
			KeyBoardData.typed=key.getKeyChar();
		}
	}

}
