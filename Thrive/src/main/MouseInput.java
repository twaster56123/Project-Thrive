package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import aMouse.MouseData;

public class MouseInput implements MouseListener, MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent mouse) {
		MouseData.x=mouse.getX();
		MouseData.y=mouse.getY();
	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		MouseData.x=mouse.getX();
		MouseData.y=mouse.getY();
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {}

	@Override
	public void mouseEntered(MouseEvent mouse) {
		MouseData.mouseIn=false;
	}

	@Override
	public void mouseExited(MouseEvent mouse) {
		MouseData.mouseIn=false;
	}

	@Override
	public void mousePressed(MouseEvent mouse) {
		int button = mouse.getButton();
		if(button>=0 && button<=9){
			MouseData.mouseDown[button]=true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {}

}
