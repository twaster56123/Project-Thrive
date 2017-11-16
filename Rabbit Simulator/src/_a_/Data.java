package _a_;

import java.util.ArrayList;

import entities.Carrot;
import entities.Rabbit;

public class Data {

	public static boolean running = true;

	public static double scrollX=0.0;
	public static double scrollY=0.0;
	public static double sizeX;
	public static double sizeY;
	
	public static ArrayList<Rabbit> rabbit = new ArrayList();
	public static ArrayList<Carrot> carrot = new ArrayList();
	
	public static int males=0;
	public static int females=0;
	
	public static double timePassed=0.0;
	public static double extinctionPeriod=0.0;
	public static boolean extinctionTaken=false;
	public static int carrotsEaten=0;
	public static int rabbitsDied=0;
	public static int rabbitsBirthed=0;
	public static double oldestRabbit=0.0;
	public static double aliveOldestRabbit=0.0;
	
}
