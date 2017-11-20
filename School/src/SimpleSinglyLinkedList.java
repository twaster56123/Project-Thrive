
//	1.  What does the following program do?
/*
 * It creates singley linked Node system that can only access the next in the chain and adds a new one onto the end for each word you input
 * but it gets stuck at the first while loop and never procedes or has a way of proceding after extensive testing, so you can only add
 * more words to the chain, but if it were not to get stuck there it would proceed to print out the chained node data in order of front to back
 * then it would do it again with another way for doing it via for loop instead of while loop
 */

import java.util.Scanner;

public class SimpleSinglyLinkedList <E> {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Node <String> front = null;    // First element of list.
		Node <String>  back  = null;    // Last element of list.

		//... Read a list of words.
		System.out.println("please enter a list of words:");
		while (in.hasNext()) {
			String word = in.next();

			Node <String> e = new Node <String>();     // Create a new list element.
			e.data = word;           // Set the data field.
			//... Two cases must be handled differently
			if (front == null) {
				//... When the list is empty, we have to set the front pointer.
				front = e;            // Back element will be set below.
			} else {
			    //... When we already have elements, we need to link to it.
				back.next = e;    // Link last elem to new element.
			}
			back = e; // Update back to link to new element.
			
		}

			//... While loop to print list in forward order.
			System.out.println("*** Print words in order of entry");
			Node<String> curr = front;
			while (curr != null) {
				System.out.println(curr.data);
				curr = curr.next;
			}

			System.out.println("*** Print words in order of entry");
			for (Node<String> e = front; e != null; e = e.next) {
				System.out.println(e.data);
			}
	}
	
}

////////////////////////////////////////////////////////////////////////// Elem
// Simple class to hold data are sometimes defined with public fields.
// This practice isn't good, but was done here for simplicity.
class Node <E> {
	public Node <E> next;    // Link to next element in the list.
	public E data;  // Reference to the data.
}
	
