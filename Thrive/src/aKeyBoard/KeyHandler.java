package aKeyBoard;

import aaa.Data;

public class KeyHandler {

	public void update(){
		
		if(Data.mode.equals("game")){
			
			int anims = Data.player.anims;
			int dd=anims*0;
			int ww=anims*1;
			int aa=anims*2;
			int ss=anims*3;
			anims--;
			
			if(Data.player.canMove){
				if(isKeyDown(a)){
					Data.player.x-=Data.delta*Data.player.moveSpeed;
					if(Data.player.pointer>=aa+anims || Data.player.pointer<aa){
						Data.player.pointer=aa;
					}
					else{
						Data.player.pointer+=Data.delta;
					}
				}
				if(isKeyDown(d)){
					Data.player.x+=Data.delta*Data.player.moveSpeed;
					if(Data.player.pointer>=dd+anims || Data.player.pointer<dd){
						Data.player.pointer=dd;
					}else{
						Data.player.pointer+=Data.delta;
					}
				}
				if(isKeyDown(w)){
					Data.player.y-=Data.delta*Data.player.moveSpeed;
					if(Data.player.pointer>=ww+anims || Data.player.pointer<ww){
						Data.player.pointer=ww;
					}
					else{
						Data.player.pointer+=Data.delta;
					}
				}
				if(isKeyDown(s)){
					Data.player.y+=Data.delta*Data.player.moveSpeed;
					if(Data.player.pointer>=ss+anims || Data.player.pointer<ss){
						Data.player.pointer=ss;
					}
					else{
						Data.player.pointer+=Data.delta;
					}
				}
			}
			
			if( ! ( isKeyDown(d) || isKeyDown(w) || isKeyDown(a) || isKeyDown(s) ) ){
				if(Data.player.pointer<ww+anims && Data.player.pointer>=ww){
					Data.player.pointer=ww;
				}
				if(Data.player.pointer<ss+anims && Data.player.pointer>=ss){
					Data.player.pointer=ss;
				}
				if(Data.player.pointer<aa+anims && Data.player.pointer>=aa){
					Data.player.pointer=aa;
				}
				if(Data.player.pointer<dd+anims && Data.player.pointer>=dd){
					Data.player.pointer=dd;
				}
			}
			
			
		}
		
	}
	
	
	
	
	public static boolean isKeyDown(int keyCode){
		return(KeyBoardData.keysDown[keyCode]);
	}
	
	// function keys
	public static int f1=112, f2=113, f3=114, f4=115, f5=116, f6=117, f7=118, f8=119, f9=120, f10=121, f11=122, f12=123;
	// special keys
	public static int backspace=8,escape=27,left=37,up=38,right=39,down=40;
	// number keys
	public static int zero=48,one=49, two=50, three=51, four=52, five=53, six=54, seven=55, eight=56, nine=57;
	// letter keys
	public static int q=81, w=87, e=69, r=82, t=84, y=89, u=85, i=73, o=79, p=80;
	public static int a=65, s=83, d=68, f=70, g=71, h=72, j=74, k=75, l=76;
	public static int z=90, x=88, c=67, v=86, b=66, n=78, m=77; 	
	
	
}
