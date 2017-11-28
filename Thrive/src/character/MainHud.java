package character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import aaa.Data;

public class MainHud {

	private static BufferedImage[] image = new BufferedImage[6];
	
	public static void loadImages(){
		try{
			String path = "res\\mainHud\\basicStats\\";
			String ext = ".png";
			
			image[0]= ImageIO.read(new File(path+"HealthBarTotal"+ext));
			image[1]= ImageIO.read(new File(path+"HealthBar"+ext));
			
			image[2]= ImageIO.read(new File(path+"ManaBarTotal"+ext));			
			image[3]= ImageIO.read(new File(path+"ManaBar"+ext));	
			
			image[4]= ImageIO.read(new File(path+"EnergyBarTotal"+ext));
			image[5]= ImageIO.read(new File(path+"EnergyBar"+ext));
			
		}catch(Exception ex){
			System.out.println("Error Loading mainHud image: \n"+ex.getLocalizedMessage());
		}
	}
	
	public static void draw(Graphics g){
		
		if(Data.mode.equals("game")){
			//Health bar
			int x=(int)(Math.floor((20)*Data.ratioX));
			int y=(int)(Math.floor(0*Data.ratioY));
			int width=(int)(Math.floor(300*Data.ratioX));
			int height=(int)(Math.floor(25*Data.ratioY));
			
			g.drawImage(image[0],x,y,width,height,null);
			g.drawImage(image[1],x,y, (int)Math.floor((double)width*(Data.player.health/Data.player.maxHealth)),height,null);
			
			//Mana bar
			x=(int)(Math.floor((20+325)*Data.ratioX));
			y=(int)(Math.floor(0*Data.ratioY));
			width=(int)(Math.floor(300*Data.ratioX));
			height=(int)(Math.floor(25*Data.ratioY));
			
			g.drawImage(image[2],x,y,width,height,null);
			g.drawImage(image[3],x,y, (int)Math.floor((double)width*(Data.player.mana/Data.player.maxMana)),height,null);
			
			//Mana bar
			x=(int)(Math.floor((20+325*2)*Data.ratioX));
			y=(int)(Math.floor(0*Data.ratioY));
			width=(int)(Math.floor(300*Data.ratioX));
			height=(int)(Math.floor(25*Data.ratioY));
			
			g.drawImage(image[4],x,y,width,height,null);
			g.drawImage(image[5],x,y, (int)Math.floor((double)width*(Data.player.energy/Data.player.maxEnergy)),height,null);
			
		}
		
	}
}
