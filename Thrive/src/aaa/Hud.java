package aaa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hud {

	public static BufferedImage[] image = new BufferedImage[3];
	
	public static void loadImages(){
		
		String ext = ".png";
		String path="res\\Inventory\\hud\\";
		
		String images[] = {"bg","fg1","fg2"};
		for(int i=0; i<images.length; i++){
			try{
				image[i]=ImageIO.read(new File(path+images[i]+ext));
			}catch(IOException ex){
				System.out.println(images[i]+" Does not exist");
			}
		}
		
	}
	
}
