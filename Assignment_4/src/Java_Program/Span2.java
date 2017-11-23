/**
 * Eric Purvis, 160550
 */
package Java_Program;

public class Span2 {

	int span[];
	
	public Span2(){
	
		int pricesToGen = 1000;//Array size to be
		
		int priceRangeLow=1; //Dollars
		int priceRangeHigh=1000;//Dollars
		
		Array prices = new Array();
		
		for(int i=0; i<pricesToGen; i++){
			double rand = Math.floor(Math.random()*priceRangeHigh)+priceRangeLow;
			prices.push(rand);
		}
		
		calcSpan(pricesToGen, prices);
		
		System.out.println("Span:   "+toString());
		System.out.println("Prices: "+prices.toString());
		
		
		
	}
	
	public void calcSpan(int size, Array list){
		span = new int[size];
		
		span[0]=1;
		for(int y=1; y<span.length; y++){
			int tracker =1;
			for(int x=y-1; x>=0; x--){
				if((double)list.get(y)>(double)list.get(x) ){
					tracker++;
				}else{
					break;
				}
			}
			span[y]=tracker;
		}
		
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
