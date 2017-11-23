/**
 * Eric Purvis, 160550
 */
package Java_Program;

public class Span2 {

	int span[];
	
	public Span2(){
	
		int pricesToGen = 10;//Array size to be
		span = new int[pricesToGen];
		
		int priceRangeLow=1; //Dollars
		int priceRangeHigh=1000;//Dollars
		
		Array prices = new Array();
		
		for(int i=0; i<pricesToGen; i++){
			double rand = Math.floor(Math.random()*priceRangeHigh)+priceRangeLow;
			prices.push(rand);
		}
		
		
		
		System.out.println("Span: "+toString());
		System.out.println("Prices: "+prices.toString());
		
		
		
	}
	
	public String toString(){
		String temp="[";
		for(int i=0; i<span.length; i++){
			if(i!=0){
				temp+=", ";
			}
			temp+=span[i];
		}
		return(temp+"]");
	}
	
}
