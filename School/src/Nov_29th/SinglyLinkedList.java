package Nov_29th;

public class SinglyLinkedList<E> {
//1. Complete the following codes
  protected Node<E> start;

  protected int size;
  public SinglyLinkedList(){
	  start = null;
	  size = 0;
	  }
	  //insertAtLast
	  public void add(E data){
		  insertAtLast(data);
	  }
	  public void insertAtLast(E data){
		  if(size==0){
			  start = new Node<E>();
			  start.next = null;
			  start.element = data;
			  }
		  else{
			  Node<E> currentNode = getNodeAt(size-1);
			  Node<E> newNode = new Node<E>();
			  newNode.element = data;
			  newNode.next = null;
			  currentNode.next = newNode;   }
			  size++;
		  }

	   public void insertAtFirst(E data){
		   if(size==0){
			   start = new Node<E>();
			   start.next = null;
			   start.element = data;   }
		   else{
				   Node<E> newNode = new Node<E>();
				   newNode.element = data;
				   newNode.next = start;
				   start = newNode;   }
				   size++;  }

		public Node<E> getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException{
			if(nodePos>=size || nodePos<0){    throw new ArrayIndexOutOfBoundsException();   }
			Node<E> temp = start; //Move pointer to front   int counter = 0;
			for(int counter = 0;counter<nodePos;counter++){
				temp = temp.next;   }   return temp;
		    }

//TODO Did stuff here
		public void insertAt(int position, E data){ //  0 <= position <= size - 1
			if(position == 0){
				insertAtFirst(data);   }
			else if(position==size-1){
				insertAtLast(data); 
			}else{
				
				Node<E> newNode = new Node();
				newNode.setElement(data);
				Node<E> PriorNode = getNodeAt(position-1);
				newNode.setNext(PriorNode.getNext());
				PriorNode.setNext(newNode);
				size++;
				
			}  
		}

		public Node<E> getFirst(){
			if (size == 0)
			   return null;
			   return getNodeAt(0);  }

		public Node<E> getLast(){
			if (size == 0) return null;
		    return getNodeAt(size-1);  }

		public E removeAtFirst(){
			if(size==0){
				return null;  }
			E data = start.element;
			start = start.next;
			size--;
			return data;  }

//TODO also did stuff here
		public E removeAtLast(){
			if(size==0){
				throw new ArrayIndexOutOfBoundsException();   }
			if (size == 1) {
				E temp = start.element;
				start = null;
				size--;
				return temp;
			}
			
				Node<E> PriorNode = getNodeAt(size-2);
				E data = PriorNode.getNext().getElement();
				PriorNode.setNext(PriorNode.getNext().getNext());
//				PriorNode.getNext().setNext(null);
				
				size--;
				
				return data;  
		}

			public E removeAt(int position){
				if(position==0){    return removeAtFirst();   }
				else if(position == size-1){    return removeAtLast();   }
				     else{
						 Node<E> tempNode = getNodeAt(position-1);
						 E data = tempNode.next.element;
						 tempNode.next = tempNode.next.next;
						 size--;
						 return data;   }  }

		public int size(){   return size;  }

		public static void main(String[] args) {
			SinglyLinkedList<Integer> SLL = new SinglyLinkedList<Integer>();
			for (int i = 0; i <= 11; i++) {
			//	SLL.add(i);
				SLL.insertAt(0, i);
				if(i%2==0){
					SLL.removeAtLast();
				}
			}
			System.out.println("The Size of List is:  " + SLL.size());
			Node node = SLL.start;
			for(int i=0; i<SLL.size(); i++){
				System.out.println(node.getElement());
				node=node.getNext();
			}
		}


}


class Node<E> {
  // Instance variables:
  public E element;
  public Node<E> next;
  /** Creates a node with null references to its element and next node. */
  public Node() {
    this(null, null);
  }
  /** Creates a node with the given element and next node. */
  public Node(E e, Node<E> n) {
    element = e;
    next = n;
  }
  // Accessor methods:
  public E getElement() {
    return element;
  }
  public Node<E> getNext() {
    return next;
  }
  // Modifier methods:
  public void setElement(E newElem) {
    element = newElem;
  }
  public void setNext(Node<E> newNext) {
    next = newNext;
  }
}


//TODO
/*2.  Find the running times in O-notation for the following methods if your list contains n elements:

(a) public E removeAtLast()
	O(n-1) = O(n) // -Must scan thru every Node to reach 2nd last node
	
(b) public E removeAtFirst()
	O(1) only has to switch the head to the heads next

(c) public void insertAt(n/2, data)
	O(n) due to getNodeAt(), has to scan array to n'th spot
*/
