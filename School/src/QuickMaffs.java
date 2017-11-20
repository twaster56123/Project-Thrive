
public class QuickMaffs {

	public static void main(String args[]){
		
		//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
		
		int dest = 5;
		int answer =1;
		
		int prev=answer;
		
		double timeStart = System.nanoTime();
		for(int i=2; i<=dest; i++){
			answer+=prev;
			prev=answer;
		}
		double timeEnd = System.nanoTime();
		double delta= ((timeEnd-timeStart)/1000000000.0);
		
		System.out.println(answer+" took "+delta+"seconds");
		
	}
	
}
