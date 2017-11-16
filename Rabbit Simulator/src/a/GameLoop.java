package a;

import _a_.Data;

public class GameLoop {

	double start=0.0;
	double end  =0.0;
	double delta=0.0;
	double fps  =0.0;
	boolean firstRun=true;
	
	
	Draw draw = new Draw();
	public void loop(){
		
		start = System.nanoTime();
		
		if(!firstRun){
			delta = ( (start-end)/1000000000.0 );
			fps = 1/delta;
		}
		
		
		//Cap frames at 60 fps
		if(fps<=60 || firstRun){
			
			//Randomly move rabbits
			for(int i=0; i<Data.rabbit.size(); i++){
				Data.rabbit.get(i).randomMove(delta);
				if(Data.rabbit.get(i).dead){
					
					if(Data.rabbit.get(i).age>Data.oldestRabbit){
						Data.oldestRabbit=Data.rabbit.get(i).age;
						Data.aliveOldestRabbit=0.0;
					}
					
					if(Data.rabbit.get(i).gender){
						Data.males--;
					}else{
						Data.females--;
					}
					Data.rabbitsDied++;
					Data.rabbit.remove(i);
				}
			}
			
			if(Data.rabbit.size()<=0 && !Data.extinctionTaken){
				Data.extinctionTaken=true;
				Data.extinctionPeriod=Data.timePassed;
			}
			
			//Check for collisions
			
			//Update screen
			Frame.scr.updateScreen();
			
			
			Data.timePassed+=delta;
			firstRun=false;
			end = start;
			
		}
		
	}
	
}
