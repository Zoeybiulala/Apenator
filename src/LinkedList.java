import java.util.ArrayList;
/*
 * Name: Yitian Cao(Zoey)
 * File: LinkedList.java
 * Desc:
 * 
 * This is class can create a doublyLinkedList implementing the Node class.
 * It can create an alphabeticallyy ordered list and have functions of calculate
 * target name's yearly rank, number and percentage of that year, and target
 * name's total rank, number and percentage.
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
	
	/*	
	 * @returns the number of elements in the linked list.
	 */
	public int size() { 
		return size; 
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
	public void addFirst(Name target) {
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
	 * returns total number of all names of requested year
	 * @param year is the requested year
	 */
	public int totalNumberOfOneYear(int year) {
		int num = 0;
		for(Primate temp: entireList) {
			if(temp.getYear() == year) {
				num += temp.getNumber();
			}
			//if the year matched, add the number to the total
		}
		//go through the entire arraylist to find names that is of the requested year
		return num;
	}
	
	/*
	 * returns the total numbers of all names of all years
	 */
	public int totalNumberOfAllYear() {
		int totalNum = 0;
		
		for(Primate temp:entireList) {
			totalNum += temp.getNumber();
		}//go through the entire arraylist and add all the numbers
		return totalNum;
	}
	
	/*
	 * returns the number of requested names in entire arraylist
	 * @param target is the requested name to find in the list
	 */
	public int numOfName(String target) {
		int numOfName =0;
		for(int i=0; i<entireList.size();i++) {
			if(target.equals(entireList.get(i).getName())) {
				numOfName += entireList.get(i).getNumber();
			}
		}//go through the entire arraylist and add the same name's number together
		return numOfName;
	}
	
	/*
	 * returns the percentage of requested name's total number over total number of all year
	 * @param target is the requested name to calculate the percentage
	 */
	public double totalPercentage(String target) {
		return ((double)numOfName(target))/totalNumberOfAllYear();
	}

	/*
	 * returns the rank of requested name in all years
	 * @param target is the reuested name
	 */
	public int findRank(String target) {//pretend this is every name
		double[] percentages = new double[size];
		//initialize an array of double with size of the linked list(distinctive names)
		
		Node curr = header.next();
		int k=0; //index of the array of double
		while(curr!=trailer) {
			percentages[k] = totalPercentage(curr.getData().getName());
			//store current node's name's total percentage in the current index of array
			curr = curr.next();
			k++;
			//move current node and index of array to next one at the same time
		}
		
		for(int i=0; i<percentages.length-1;i++) { //the numbers of sorting 
			for(int j=0;j<percentages.length-1;j++) {//each time we change position 
				if(percentages[j]<percentages[j+1]) {
					double temp = percentages[j];
					percentages[j]=percentages[j+1];
					percentages[j+1]=temp;
				}//if current double less than the next double, change position
			}
		}
		//sort the double array from the biggest percentage to the smallest
		//so the index of the current array will be the rank
		
		for(int i=0; i<percentages.length;i++) {
			if(totalPercentage(target)==percentages[i]) {
				return i+1;
				//rank start from 1 but the index start from 0
			}
			//match target perentage with one of the double stored in the array
		}
		return -1;//default return
	}
	
	/*
	 * @param target is the requested name
	 * will print out requested name's position in the linked list
	 * and print out yearly rank, number and percentage
	 * and finally print out total rank, number and percentage
	 */
	public void printResult(String target) {
		for(int i=0; i<entireList.size();i++) {
			if(target.equals(entireList.get(i).getName())) {//find target name
				Name info = entireList.get(i);
				int number = info.getNumber();
				double fraction = ((double)number) / totalNumberOfOneYear(info.getYear());
				//fraction of yearly name number over total number of one year
				System.out.println(info.getYear());
				System.out.println(target+ ": " + info.getRank()+ ", "
						+info.getNumber()+ ", "+String.format("%.6f%n", fraction));
			}
		}//find all the same name in different year
		
		System.out.println("Total:");
		System.out.println(target+ ": "+findRank(target)+ ", "+numOfName(target)
				+", "+ String.format("%.6f%n",totalPercentage(target)));
		//print out this name's total rank, number and percentage
	}
	
	/*
	 * returns string of alphabetically ordered linked list
	 * for testing purpose
	 */
	public String toString() {
		Node curr = header.next();
		String s= curr.getData().getName() + curr.getData().getYear();
		while(curr.next().next()!=null) {
			s += ", " + curr.next().getData().getName();
			curr = curr.next();
		}
		return s;
	}
	

}
