/**
 * Eric Purvis, 160550
 */
package Java_Program;

import java.util.EmptyStackException;

public interface Stack<E> {

	public int size();
	
	public boolean isEmpty();
	
	public E top() 
			throws EmptyStackException;
	
	public void push(E e);
	
	public E pop() 
			throws EmptyStackException;
}
