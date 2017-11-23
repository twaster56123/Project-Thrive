/**
 * Eric Purvis, 160550
 */
package Java_Program;

public class StartUp {

	public static void main(String args[]){
		
		double StartTime = System.nanoTime();
		
		new Span2();
		
		double EndTime = System.nanoTime();
		double delta = (EndTime-StartTime)/1000000000.0;
		
		System.out.println("Compute Time: "+delta+" seconds");
		
	}
	
}
