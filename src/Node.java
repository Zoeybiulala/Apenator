
/*
 * Name: Yitian Cao
 * File: Node.java
 * Desc:
 * 
 * This is a node class for doubly linked list, contains Data type of
 * Name, has pointer of next node and previous node.
 * It has two constructors, one with no parameter for linkedlist sentinels
 * and one with three paramter can connect the node to its previous node
 * and next node immediately
 * 
 */
public class Node{
	
	private Primate primate;
	private Node next; //reference to the next Node
	private Node prev; //reference to the previous Node
	//end of the instances field
	
	/*
	 * construct a "dummy" node for header or trailer
	 */
	public Node() {
		primate = null;
		next = null;
		prev = null;
	}
	
	/*
	 * construct a node with pointers point to prev and next node
	 * @param prev is the previous node
	 * @param target is the information the node should carry, in this case
	 * it is a Name object
	 * @param next is the next node
	 */
	public Node(Node prev, Primate target, Node next) {
		this.primate = target;
		this.next = next;
		this.prev = prev;
	}
	
	//setters
	/*
	 * @param nextNode is the target next node
	 */
	public void setNext(Node nextNode) {
		next = nextNode;
	}
	/*
	 * @param prevNode is the target previous node
	 */
	public void setPrev(Node prevNode) {
		prev = prevNode;
	}
	
	//getters
	/*
	 * returns this node's next node
	 */
	public Node next(){
		return next;
	}
	
	/*
	 * returns this node's previous node
	 */
	public Node prev() {
		return prev;
	}
	
	/*
	 * returns the content of this node, which is of class Name
	 */
	public Primate getData() {
		return primate;
	}
	/*
	 * return a string of content of this node
	 * for testing purpose
	 */
	public String toString() {
		return primate.toString();
	}
}

