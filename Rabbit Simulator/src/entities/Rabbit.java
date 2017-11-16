package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import _a_.Data;

public class Rabbit {

	double liveingPoints=15;
	
	public double age=0.0;
	double ageOfConsent=10.0;
	double hunger=25;
	double speed=200;
	boolean reproduce=false;
	public boolean gender=false;
	public boolean dead=false;
	
	double x=0.0;
	double y=0.0;
	BufferedImage img;
	int width=0;
	int height=0;
	
	double rest=0;
	double restCD=1;
	
	double eating =0.0;
	double eatingCD=12.0;
	
	int lockDirX=0;
	int lockDirY=0;
	
	public Rabbit(){
		
		int ran = (int)Math.floor(Math.random()*2);
		if(ran==0){
			gender=true;
			Data.males++;
		}else{
			Data.females++;
		}
		
		defaultImage();
		width = img.getWidth();
		height = img.getHeight();
		
		x=Math.random()*(Data.sizeX-img.getWidth());
		y=Math.random()*(Data.sizeY-img.getHeight());
		
	}
	
	public Rabbit(double startX, double startY){
		
		int ran = (int)Math.floor(Math.random()*2);
		if(ran==0){
			gender=true;
			Data.males++;
		}else{
			Data.females++;
		}
		
		defaultImage();
		width = img.getWidth();
		height = img.getHeight();
		
		x=startX;
		y=startY;
		
	}
	
	private void die(){
		if(!dead){
			if(hunger<=0.0){
				dead=true;
			}
		}
	}
	
	private void mate(){
		if(!gender && age>ageOfConsent){
			for(int i=0; i<Data.rabbit.size(); i++){
				if(Data.rabbit.get(i).gender!=gender && Data.rabbit.get(i).age>Data.rabbit.get(i).ageOfConsent){
					double rx = Data.rabbit.get(i).x;
					double ry = Data.rabbit.get(i).y;
					double rw = Data.rabbit.get(i).width;
					double rh = Data.rabbit.get(i).height;
					if( !( x>(rx+rw) || (rx)>(x+width) || y>(ry+rh) || ry>(y+height) )){
						//Prevent females from mass producing
						if(reproduce){
							Data.rabbit.add(new Rabbit((x+rx)/2,(y+ry)/2));
							Data.rabbitsBirthed++;
							reproduce=false;
						}
					}
				}
			}
		}
	}
	
	private void defaultImage(){
			try{
				if(gender){
					img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyM.png"));
				}else{
					img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyF.png"));
				}
			}catch(Exception ex){
				System.out.println("Rabbit: Image not found!");
			}
	}
	
	private void eatingImage1(){
		try{
			if(gender){
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating1M.png"));
			}else{
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating1F.png"));
			}
		}catch(Exception ex){
			System.out.println("Rabbit: Image not found!");
		}
	}
	
	private void eatingImage2(){
		try{
			if(gender){
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating2M.png"));
			}else{
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating2F.png"));
			}
		}catch(Exception ex){
			System.out.println("Rabbit: Image not found!");
		}
	}
	
	private void eatingImage3(){
		try{
			if(gender){
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating3M.png"));
			}else{
				img = ImageIO.read(new File("Resources\\Animal\\Rabbit\\bunnyEating3F.png"));
			}
		}catch(Exception ex){
			System.out.println("Rabbit: Image not found!");
		}
	}
	
	private void carrotCollect(){
		for(int i=0; i<Data.carrot.size(); i++){
			
			double cx = Data.carrot.get(i).x;
			double cy = Data.carrot.get(i).y;
			double cw = Data.carrot.get(i).width;
			double ch = Data.carrot.get(i).height;
			
			if( !( (x>(cx+cw)) || cx>(x+width)  || y>(cy+ch) || cy>(y+height) ) ){
				
				
				
				Data.carrot.remove(i);
				Data.carrot.add(new Carrot());
				eating=eatingCD;
				
				Data.carrotsEaten++;
				hunger+=liveingPoints;
				reproduce=true;
				
			}
			
		}
	}
	
	public void randomMove(double delta){
		
		if(age>Data.aliveOldestRabbit){
			Data.aliveOldestRabbit=age;
		}
		
		if(!dead){
			
			age+=delta;
			hunger-=delta;
			
			die();
			mate();
			
			if(eating<=0){
				if(rest<=0){
					
					int up = (int)Math.floor(Math.random()*3);
					int right = (int)Math.floor(Math.random()*3);
					
					lockDirX=right;
					lockDirY=up;
					rest=restCD;
					
				}else{
					
					//up-down
					switch(lockDirY){
						case 0: 
							if(y>0){
								y-=speed*delta;
							}
						case 1: break; //don't move
						case 2: 
							if((y+height)<600){
								y+=speed*delta;
							}
						default: break; //don't move
					}
					
					//left-right
					switch(lockDirX){
						case 0: 
							if(x>0){
								x-=speed*delta;
							}
						case 1: break; //don't move
						
						case 2: 
							if((x+width)<1000){
								x+=speed*delta;
							}
						default: break; //don't move
					}
		
					carrotCollect();
					rest-=delta;
				}
			}else{
				
				int cutScene = (int)Math.floor(eating/3);
				
				switch(cutScene){
	
					case 1:
						eatingImage3();
						break;
					case 2:
						eatingImage2();
						break;
					case 3:
						eatingImage1();
						break;
					default:
						defaultImage();
						break;
				}
				
				eating-=delta;
			}
		}
		
	}
	
	public void drawRabbit(Graphics g){
		if( !(x>1000+Data.scrollX && (x+img.getWidth())<Data.scrollX && y>600+Data.scrollY && (y+img.getHeight())<Data.scrollY) ){
			g.drawImage(img,(int)Math.round(x), (int)Math.round(y), null);
		}
	}
	
}
