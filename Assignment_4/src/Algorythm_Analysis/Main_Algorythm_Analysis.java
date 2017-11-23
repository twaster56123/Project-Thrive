/**
 * Eric Purvis, 160550
 */

package Algorythm_Analysis;

public class Main_Algorythm_Analysis {

	//Tests the code
	public static void main(String args[]){
	
		double startTime = System.nanoTime();
		
		String entry[] = {"Hello", "World", "And", "Good", "Bye"};
		
		VectorTest test = new VectorTest(entry);
	
		out("isEmpty: "+test.isEmpty());
		
		test.add(0, "Bye");
		test.add(0, "Good");
		test.add(0, "And");
		test.add(0, "World");
		test.add(0, "Hello");

		
		out("Removed: "+test.remove(0));
		out("Rewrote: "+test.set(0, "Hi"));
		out("Retrieved: "+test.get(3));
		
		out("isEmpty: "+test.isEmpty());
		
		out("Current Array: "+test.toString());
		
		double endTime = System.nanoTime();
		double delta = (endTime-startTime)/1000000000.0;
		
		out("Compute Time: "+delta+" seconds");
		
	}
	
	private static void out(String msg){
		System.out.println(msg);
	}
	
}

class VectorTest<E> implements Vector<E>{

	//Data for being able to perform the given actions of the program
	private int size;
	private E[] table;
	
	
	//Constructors to start the programs array and size with
	public VectorTest(E[] list){
		table=list;
		size=list.length;
	}
	
	public VectorTest(){
		table =(E[])new Object[1];
		size=0;
	}
	
	//Stores and returns a string in a nice ish format to be displayed onto the screen
	public String toString(){
		String result = "[";
		for(int i=0; i<size; i++){
			if(i!=0){
				result+=", ";
			}
			result+=table[i];
		}
		return(result+"]");
	}
	
	//Returns the size of contents and not the actual array size
	@Override
	public int size() {
		return(size);
	}

	//Returns if the array is empty or not
	@Override
	public boolean isEmpty() {
		return(size==0);
	}

	//Adds element to indexed location and shoves everything else right if it is within bounds
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if( !(i<0 || i>size) ){
			//Double growth
			if(size==table.length){
				E[] temp = (E[]) new Object[table.length*2];
				for(int x=0; x<size+1; x++){
					if(x<i){
						temp[x]=table[x];
					}
					if(x==i){
						temp[i]=e;
					}
					if(x>i){
						temp[x]=table[x-1];
					}
				}
				table=temp;
			}else{
			//Regular addition
				for(int x=size; x>i; x--){
					table[x]=table[x-1];
				}
				table[i]=e;
			}
			size++;
		}
	}

	//gets and returns the value of array at given index if within bounds to
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		E got = null;
		if(! (i<0 || i>size) ){
			got = table[i];
		}
		return(got);
	}
	
	//gets and returns the value of array at given index if within bounds to, but also removes that index and collapses everything left to fill the gap
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		E removed = null;
		if(! (i<0 || i>size) ){
			removed = table[i];
			if(i==size-1){
				table[i]=null;
			}
			for(int x=i; x<size-1; x++){
				table[x]=table[x+1];
			}
			size--;
		}
		return(removed);
	}

	//Changes the value of an index to element if within bounds and returns what was replaced
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		E replaced = null;
		if(! (i<0 || i>size) ){
			replaced = table[i];
			table[i]=e;
		}
		return(replaced);
	}
	
}
