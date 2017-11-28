package aaa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Items {

	public static String[] name ={null,"axe","pickaxe","hoe", 
		"cottonwood", "oakwood",
		"copper", "tin", "bronze"};
	
	public static int 
	nothing=0,
	axe=1,
	pickaxe=2,
	hoe=3,
	cottonwood=4,
	oakwood=5,
	copper=6,
	tin=7,
	bronze=8
	;
	
	public static BufferedImage[] icon = new BufferedImage[100];
	
	public static void loadItemIcons(){
		String ext = ".png";
		String path = "res\\Inventory\\icons\\";
		for(int i=1; i<name.length; i++){
			try{
				icon[i]=ImageIO.read(new File(path+name[i]+ext));
			}catch(IOException ex){
				System.out.println(name[i]+" Does not exist!!");
			}
		}
		
	}
	
}
