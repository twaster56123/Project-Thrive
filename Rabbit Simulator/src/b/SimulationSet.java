package b;

import entities.Carrot;
import entities.Rabbit;
import _a_.Data;

public class SimulationSet {

	public SimulationSet(double WorldWidth, double WorldHeight, int StartRabbits, int StartCarrots){
		
		Data.sizeX=WorldWidth;
		Data.sizeY=WorldHeight;
		
		for(int i=0; i<StartRabbits; i++){
			Data.rabbit.add(new Rabbit());
		}
		
		for(int i=0; i<StartCarrots; i++){
			Data.carrot.add(new Carrot());
		}
		
	}
	
}
