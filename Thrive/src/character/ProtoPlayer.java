package character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import aaa.Data;
import aaaMap.Map;

public class ProtoPlayer {

	public String username="";
	
	public double maxHealth=100;
	public double health=maxHealth;
	
	public double maxMana=100;
	public double mana=maxMana;
	
	public double maxEnergy=100;
	public double energy=maxEnergy;
	
	public boolean canMove=true;
	public double moveSpeed=150;
	public double x=100;
	public double y=100;
	public int width=40;
	public int height=108;
	public int range =100;
	
	public static ArrayList<BufferedImage> walkAnim =new ArrayList<BufferedImage>();
	public int anims=0;
	public double pointer =0;
	public String animation="walk";
	
	public boolean inventoryOpen=false;
	public int[][][] inventory = new int[9][4][2];
	public int hotbar[] = new int[9];
	public int hotKeySelected=1;
	
	//Player Collect stuff???
	///////Player Inventory????
	
	public void drawPlayer(Graphics g){
		try{
			double ratioX = Data.ratioX;
			double ratioY = Data.ratioY;

			int pointer = (int)Math.round(this.pointer);
			
			int xx =(int)Math.round(this.x-Camera_View.x);
			int yy =(int)Math.round(this.y-Camera_View.y);
			int rw =(int)Math.round(walkAnim.get(pointer).getWidth()*ratioX); 
			int ry =(int)Math.round(walkAnim.get(pointer).getHeight()*ratioY); 
			
			if(animation.equals("walk")){
				g.drawImage(walkAnim.get(pointer), (int)(xx*Data.ratioX), (int)(yy*Data.ratioY), rw, ry, null);
			}
		}catch(Exception ex){}
		
	}
	
	public void loadPlayerImages(String path, int anims){
		try{
			this.anims=anims;
			//Right
			for(int i=0; i<anims; i++){
				walkAnim.add(ImageIO.read(new File(path+"Right"+(i+1)+".png")));
			}
			//Up
			for(int i=0; i<anims; i++){
				walkAnim.add(ImageIO.read(new File(path+"Up"+(i+1)+".png")));
			}
			//Left
			for(int i=0; i<anims; i++){
				walkAnim.add(ImageIO.read(new File(path+"Left"+(i+1)+".png")));
			}
			//Down
			for(int i=0; i<anims; i++){
				walkAnim.add(ImageIO.read(new File(path+"Down"+(i+1)+".png")));
			}
		}catch(IOException ex){
			System.out.println(ex.getLocalizedMessage());
		}
	}
	
	public void CollisionObjectRendering(){
		Camera_View cam = new Camera_View();
		for(int i=0; i<Map._objects_name.length; i++){
			if(Map._objects_name[i]!=null){
				
				int leeway=100;
				int screenX=(int)Math.round(cam.x);
				int screenY=(int)Math.round(cam.y);
				
				if( (Map._objects[i*2]-screenY)>=(0-leeway) || (Map._objects[i*2]-screenX)<=(Data.windowWidth+leeway) || (Map._objects[i*2+1]-screenY)>=(0-leeway) || (Map._objects[i*2+1]-screenY)<=(Data.windowHeight+leeway) ){
					try{
						int IWidth = (Map.objectImages[Map._objects_id[i]].getWidth());
						int IHeight = (Map.objectImages[Map._objects_id[i]].getHeight());
						int Ix = Map._objects[i*2];
						int Iy = Map._objects[i*2+1];
						
						int tempX=(int)Math.round(x);
						int tempY=(int)Math.round( (double)y+(double)height*0.8);
						int tempHeight =(int)Math.round( (double)height*0.2);
						
						boolean above = ( y+height<Iy+IHeight );
						boolean renderBounds = ( !( (x>=Ix+IWidth) || (x+width<=Ix) || (y>=Iy+IHeight) || (y+height<=Iy) ) );
						
						Iy = (int)Math.round((double)Map._objects[i*2+1]+(double)IHeight*0.9);
						IHeight=(int)Math.round((double)IHeight*0.1);
								
						boolean upperBounds = (  !( (tempX>=Ix+IWidth*0.8) || (tempX+width<=Ix+IWidth*0.1) || (tempY>=Iy+IHeight/1000) || (tempY+tempHeight<=Iy) ) );
						boolean lowerBounds = (  !( (tempX>=Ix+IWidth*0.8) || (tempX+width<=Ix+IWidth*0.1) || (tempY>=Iy+IHeight) || (tempY+tempHeight/1000<=Iy) ) );
///Revise left+right bounds						
						boolean leftBounds = (  !( (tempX>=Ix+IWidth/1000) || (tempX+width<=Ix) || (tempY>=Iy+IHeight) || (y+tempHeight<=Iy  ) ) );
						boolean rightBounds = (  !( (tempX>=Ix+IWidth) || (tempX+width/1000<=Ix) || (tempY>=Iy+IHeight) || (y+tempHeight<=Iy   ) ) );
	
			////Priority Rendering
						if(renderBounds && above){
							Map.objectPriority[i]=true;
						}else{
							Map.objectPriority[i]=false;
						}
			////Collision of objects	
						if( !( Map._objects_name[i].equals("") ) ){
							if(upperBounds){
								y-=moveSpeed*Data.delta;
							}
							if(lowerBounds){
								y+=moveSpeed*Data.delta;
							}
							if(leftBounds){
								x-=moveSpeed*Data.delta;
							}
							if(rightBounds){
								x+=moveSpeed*Data.delta;
							}
						}
						
					}catch(Exception ex){}
				}
				
			}
		}
	}

	public void CollisionBlockRendering(){
		
		try{
			int blockX = (int)Math.floor( (x+width/2)/33);
			int blockY = (int)Math.floor((y+height-height/10)/33);
			//Head
			if(Map._static[blockX][blockY]==0){
				y+=Data.delta*moveSpeed;
			}
			//Feet
			blockX = (int)Math.floor( (x+width/2)/33);
			blockY = (int)Math.floor( (y+height)/33);
			if(Map._static[blockX][blockY]==0){
				y-=Data.delta*moveSpeed;
			}
			//Left Side
			blockX = (int)Math.floor( (x)/33);
			blockY = (int)Math.floor((y+height-height/10)/33);
			if(Map._static[blockX][blockY]==0){
				x+=Data.delta*moveSpeed;
			}
			//Right Side
			blockX = (int)Math.floor( (x+width)/33);
			blockY = (int)Math.floor((y+height-height/10)/33);
			if(Map._static[blockX][blockY]==0){
				x-=Data.delta*moveSpeed;
			}
		}catch(Exception ex){}
		
	}
	
	public void CollisionVoidRendering(){
		double maxWorldWidth = (double)Map._static.length*33;
		double maxWorldHeight =(double)Map._static[0].length*33;
		if(x<0){
			x=0;
		}
		if(y<0){
			y=0;
		}
		if(x>maxWorldWidth){
			x=maxWorldWidth;
		}
		if(y>maxWorldHeight){
			y=maxWorldHeight;
		}
	}
	
	public void MagnitudeRange(){
		Camera_View cam = new Camera_View();
		for(int i=0; i<Map._objects_name.length; i++){
			if(Map._objects_name[i]!=null){
				
				int leeway=100;
				int screenX=(int)Math.round(cam.x);
				int screenY=(int)Math.round(cam.y);
				
				if( (Map._objects[i*2]-screenY)>=(0-leeway) || (Map._objects[i*2]-screenX)<=(Data.windowWidth+leeway) || (Map._objects[i*2+1]-screenY)>=(0-leeway) || (Map._objects[i*2+1]-screenY)<=(Data.windowHeight+leeway) ){
					try{
						int Ix = Map._objects[i*2];
						int Iy = Map._objects[i*2+1];
						int IWidth = (Map.objectImages[Map._objects_id[i]].getWidth());
						int IHeight = (Map.objectImages[Map._objects_id[i]].getHeight());

						double newX = (Ix+IWidth/2-x-width/2);
						double newY = (Iy+IHeight/2-y-height/2);
						
						double magnitude = Math.sqrt( (Math.pow(newX, 2) + Math.pow(newY, 2)) );
						
						if(magnitude<=range){
							
							switch(Map._objects_name[i]){
							
								case("portal1"): System.out.println("hi1"); break;
								case("portal2"): System.out.println("hi2"); break;
								case("tree1"): System.out.println("hi3"); break;
								case("ore1"): System.out.println("hi4"); break;
								case("ore2"): System.out.println("hi5"); break;
							
								default: break;
							
							}
							
						}
						
						
					}catch(Exception ex){}
				}
				
			}
		}
	}
	
}
