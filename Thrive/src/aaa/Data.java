package aaa;

import character.ProtoPlayer;

public class Data {

	public static ProtoPlayer player = new ProtoPlayer();
	
	public static String gameName = "Thrive";
	public static double ratioX = 1;
	public static double ratioY =1;
	public static int windowWidth=1000;
	public static int windowHeight=600;
	public static int currentWindowWidth=windowWidth;
	public static int currentWindowHeight=windowHeight;
	public static boolean windowResizable=true;
	
	
	public static boolean gameRunning=true;
	public static double delta=0.0;
	public static String mode="menu";
	
}
