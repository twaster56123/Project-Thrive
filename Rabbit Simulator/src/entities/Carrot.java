package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import _a_.Data;

public class Carrot {
	
	double x=0.0;
	double y=0.0;
	BufferedImage img;
	int width=0;
	int height=0;
	
	public Carrot(){
		
		try{
			img = ImageIO.read(new File("Resources\\Vegies\\Carrot\\carrot.png"));
		}catch(Exception ex){
			System.out.println("Carrot: Image not found!");
		}
		
		width = img.getWidth();
		height=img.getHeight();
		
		x=Math.random()*(Data.sizeX-img.getWidth());
		y=Math.random()*(Data.sizeY-img.getHeight());
		
	}
	
	public void drawCarrot(Graphics g){
		
		if( !(x>1000+Data.scrollX && (x+img.getWidth())<Data.scrollX && y>600+Data.scrollY && (y+img.getHeight())<Data.scrollY) ){
			g.drawImage(img,(int)Math.round(x), (int)Math.round(y), null);
		}
		
	}
	
}
