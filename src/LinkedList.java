import java.util.ArrayList;
/*
 * Name: Yitian Cao(Zoey)
 * File: LinkedList.java
 * Desc:
 * 
 * This is class can create a doublyLinkedList implementing the Node class.
 * It can create an alphabeticallyy ordered list and have functions of printing
 * primate in alphabetical order and so on
 */
public class LinkedList {
	
	private Node header;
	private Node trailer; //two sentinels
	private int size;
	private ArrayList<Primate> entireList; //store unsorted list
	
	//end of instances field
 	
	/* 
	 * construct an empty list with two sentinels
	 * initialize instance variables
	 */
	public LinkedList() {
		header = new Node();
		trailer = new Node();
		header.setNext(trailer);
		trailer.setPrev(header); //connect header and trailer because the list is empty
		size =0;
		entireList = new ArrayList<Primate>();

	}
	/**
	 * @return the header
	 */
	public Node getHeader() {
		return header;
	}

	/*	
	 * @returns the number of elements in the linked list.
	 */
	public int size() { 
		Node curr = header.next();
		int count = 0;
		while(curr!=trailer) {
			count++;
			curr = curr.next();
		}
		return count;
	}
	
	/*
	 * @returns boolean type
	 * whether the list is empty 
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * returns if the target name is exist in the alphabetically
	 * ordered list
	 * @param target is the newly required name to add in the list
	 */
	public boolean ifExist(Primate target) {
		boolean flag = false;
		if(isEmpty())
			return flag; //if the list is empty then the name is not existed
		
		Node curr = header.next();
		while(curr != trailer && !flag){ 
			flag = target.getName().equals(curr.getData().getName());
			curr = curr.next();
		} //walking process and test if find the same name
		return flag;
	}
	
	/*
	 * returns the position of requested name in the
	 * alphabetically ordered list
	 * @param target is the string of requested name
	 */
	public int indexOf(String target) {
		int i = 0;
		if(isEmpty()) {
			return -1; //if the list is empty then -1 indicate
					   //there is no index of the target
		} else {
			Node curr = header.next();
			while(curr != trailer && !target.equals(curr.getData().getName())){
				curr = curr.next();
				i++;
			}//walk until find the target Name in the list
			return i;
		}
	}
	

	/*
	 * @param target is the requested name to add to the head of the list
	 * uses addBetween method to add the node between header and trailer
	 */
	public void addFirst(Primate target) {
		addBetween(header,target, header.next());
	}
	
	/*
	 * @param predecessor is the previous node of target node 
	 * @param target is the content of new Node
	 * @param successor is the next node of target node
	 */
	private void addBetween(Node predecessor,Primate target, Node successor) {
		 // create and link a new node
		Node newest = new Node(predecessor,target, successor);
		//create a new node with prev pointer points to predecessor node and next pointer
		//points to successor node
		predecessor.setNext(newest);//make predecessor's next points to new node
		successor.setPrev(newest);//make successor's prev points to new node
		size++;//update the size of the list
	}
	
	private boolean compare(Node curr,int i,String trait) {
		String tTrait = "";
		switch (i) {
		case 0:
			tTrait = String.valueOf(curr.getData().isPostOrbClo());
			break;
		case 1:
			tTrait = curr.getData().getEcto();
			break;
		case 2:
			tTrait = String.valueOf(curr.getData().getDenFormu());
			break;
		case 3:
			tTrait = curr.getData().getActTime();
			break;
		case 4:
			tTrait = curr.getData().getDiet();
			break;
		case 5:
			tTrait = curr.getData().getLocation();
			break;
		case 6:
			tTrait = curr.getData().getColor();
			break;
		case 7:
			tTrait = curr.getData().getLoco();
			break;
		case 8:
			tTrait = curr.getData().getNostril();
			break;
		case 9:
			tTrait = String.valueOf(curr.getData().isTail());
			break;
		case 10:
			tTrait = String.valueOf(curr.getData().isDenCom());
			break;
		case 11:
			tTrait = String.valueOf(curr.getData().isGroClaw());
			break;
		case 12:
			tTrait = String.valueOf(curr.getData().isSexualDimor());
			break;
		}
		return trait.equals(tTrait);
	}
	
	public void delNo(String trait,int i) {
		Node curr = header.next();
		boolean flag = false;
		while(curr != trailer){ 
			flag = compare(curr,i,trait);
			curr = curr.next();
			if(size()>1) {
				if(flag == true) {
					curr.setPrev(curr.prev().prev());
					curr.prev().setNext(curr);
				}
			} else {
				break;
			}
		} //walking process and test if find the same traits
		
	}
	
	public void delYes(String trait,int i) {
		Node curr = header.next();
		boolean flag = true;
		while(curr != trailer){ 
			flag = compare(curr,i,trait);
			curr = curr.next();
			if(size()>1) {
				if(flag==false) {
					curr.setPrev(curr.prev().prev());
					curr.prev().setNext(curr);
				}
			} else {
				break;
			}
		} //walking process and test if find the same traits
	}
	
	/*
	 * @param target is the content of new Node that is going to be add to the list
	 * this method will create an unordered arrayList of all names of all years
	 * and also create an alphabetically ordered linkedlist of distinctive names
	 */
	public void insertAlpha(Primate target) {
		entireList.add(target);//add to the unordered arrayList

		String tName = target.getName();
		if(isEmpty() || tName.compareTo(header.next().getData().getName())<0) {
			addFirst(target); 
			// if the list is empty or the target name is alphabetically smaller
			//than the first node, then add it to the beginning of the list
		} else {
			if(!ifExist(target)) {//if the name isn't in the list then add it
				Node curr = header.next();
				while(curr != trailer && tName.compareTo(curr.getData().getName())>0) {
					curr = curr.next();
				}//walk until it find the right position, with pointer at the next node
				addBetween(curr.prev(),target,curr);
				//the new node should be between the previous node and the current node
			} 
		}	
	}
	
	
	/*
	 * returns string of alphabetically ordered linked list
	 * for testing purpose
	 */
	public String toString() {
		Node curr = header.next();
		String s= curr.getData().getName();
		while(curr.next().next()!=null) {
			s += ", \n" + curr.next().getData().getName() ;
			curr = curr.next();
		}
		return s;
	}
	/*
	 * returns string of alphabetically ordered linked list
	 * for testing purpose but only name not all the info
	 */
	public String toString2() {
		Node curr = header.next();
		String s= curr.getData().toString();
		while(curr.next().next()!=null) {
			s += ", \n" + curr.next().getData().toString() ;
			curr = curr.next();
		}
		return s;
	}
	
	
	
	

}
