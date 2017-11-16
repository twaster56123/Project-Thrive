package a;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import _a_.Data;

public class Draw {
	
	public void update(Graphics g){
		
		drawBackground(g);
		drawCarrot(g);
		drawBunny(g);
		drawStats(g);
		
	}
	
	private void drawStats(Graphics g){
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", 1, 16));
		g.drawString("Rabbits Alive: "+Data.rabbit.size(), 0, 20);
		g.drawString("Rabbits Birthed: "+Data.rabbitsBirthed, 0, 40);
		g.drawString("Rabbits Died: "+Data.rabbitsDied, 0, 60);
		g.drawString("Carrots Eaten: "+Data.carrotsEaten, 0, 80);
		g.drawString("M/F ratio: "+Data.males+"/"+Data.females, 0, 100);
		g.drawString("Oldest rabbit: "+(float)Data.oldestRabbit, 0, 120);
		g.drawString("Current Oldest: "+(float)Data.aliveOldestRabbit, 0, 140);
		
		g.drawString("Carrots/second "+(float)(Data.carrotsEaten/Data.timePassed), 0, 600-70);
		g.drawString("Extinction Period: "+(int)Data.extinctionPeriod+" seconds", 0, 600-50);
		g.drawString("Time Passed: "+(int)Data.timePassed+" seconds", 0, 600-30);
		
	}
	
	private void drawBackground(Graphics g){
		
		g.setColor(new Color(0, 200, 0));
		g.fillRect(0,0,1000,600);
		
	}
	
	private void drawCarrot(Graphics g){
		
		for(int i=0; i<Data.carrot.size(); i++){
			Data.carrot.get(i).drawCarrot(g);
		}
		
	}
	
	private void drawBunny(Graphics g){
		
		for(int i=0; i<Data.rabbit.size(); i++){
			Data.rabbit.get(i).drawRabbit(g);
		}
		
	}

}
