/*
 * Name: Yitian Cao
 * File: Apenator.java
 * Desc:
 * 
 * This file runs the most of methods or functions, and realize 
 * the interactive function. The game is called Apenator, which can
 * guess what primate is on the user's mind by asking a series of 
 * questions related to the traits. Finally, it will list all the triats
 * including the catagory of that primate.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Apenator {
	/*
	 * the main method
	 */
	public static void main(String[] args ) throws FileNotFoundException, IOException {
	    	
	    	LinkedList primates = new LinkedList();
	    	//initialize the linkedlist for all the primates
	    	
	    	String fileNames = "../Apenator/Apenator.csv";
	    	//store requested files to analyze in an array of strings
	    	
	    	
		    Scanner reader = 
		    		new Scanner(new FileReader(fileNames));
		    String header = reader.nextLine();//skip the header
		    ArrayList<String[]> myEntries = new ArrayList<String[]>();
		    while(reader.hasNextLine()) {
		    	String line = reader.nextLine();
		    	String[] rowInfo = line.split(",");
		    	myEntries.add(rowInfo);
		    }
			reader.close();
			//the end of reading cvs file
				
		    for(String[] row: myEntries) {
		    	Primate primate = new Primate(row);
		    	primates.insertAlpha(primate);
		    		//add primate to the linkedlist
		    }
		    //building the doubly linked list
		    
		    
		    Scanner input = new Scanner(System.in);
		    openQ(input,primates);//opening statements
		    boolean positive;
		    int[] queOrder = queOrder();
		    //generate a series of random order
		    //so that each time the questions will be different
		    int[] traitOrder = copy(queOrder);
		    //the copy process will guarantee the trait and question match 
		    String trait="";
		    for(int i=0;i<13;i++) {
		    	System.out.println(askRanQ(primates,queOrder[i]));
		    	trait = returnTrait(primates,traitOrder[i]);
		    	System.out.println("Press 1 for yes, 2 for no");
		    	
		    	positive = answer(input);
		    	if(positive) {
		    		primates.delYes(trait,traitOrder[i]);
		    		
		    	} else {
		    		primates.delNo(trait,traitOrder[i]); 
		    		
		    	}
		    	if(primates.size()==1) {
		    		break;
		    		//already find the final answer
		    	}
		    }
		    
		    System.out.println("This primate is most likely the answer:");
		    System.out.println(primates.toString2());

	}
	
	/*
	 * @param input, scanner class, will be the user's input
	 * @param primates, is the linkedlist of primates
	 * this opens the game with greetings and a option for user
	 * to check out all the possible primates
	 */
	public static void openQ(Scanner input, LinkedList primates) {
		System.out.println("Hello, I'm Apenator, or you can call me Api!");
		System.out.println("Would you like to see how many primates I know? "
				+ "\n"+
				"Press 1 to list all the name of primates in the database,"
				+ "or press 2 to list all the information of primates in the database.");
		int answer = Integer.parseInt(input.nextLine());
		if(answer == 1) {
			System.out.println(primates.toString());
		} else if(answer == 2) {
			System.out.println(primates.toString2());
		} else {
			System.out.println("sorry, please press 1 or 2 to continue");
		}
		
		System.out.println("Now, think of 1 primate and I will guess what's on your mind!!");
		String space = input.nextLine();
	}
	
	/*
	 * @param primates, the linked list of primates
	 * @param i, read in from the array of order of q&a
	 * @return String, the question prompt to the user
	 * a method to generate question based on the current
	 * first node in linked list
	 */
	public static String askRanQ(LinkedList primates,int i) {
		Primate p = primates.getHeader().next().getData();
		String[] traits = new String[13];
		traits[0]="Is your primate's post orbital closure=" +p.isPostOrbClo()+"?";
		traits[1]="Is your primate Ectotympanic area " +p.getEcto()+ "-like?";
		traits[2]="Is your primate Dental formula= "+p.getDenFormu()+"?";
		traits[3]="Is your primate "+p.getActTime()+"?";
		traits[4]="Is your primate "+p.getDiet()+"?";
		traits[5]="Does your primate live in "+p.getLocation()+"?";
		traits[6]="Is your primate "+p.getColor()+"color?";
		traits[7]="Is your primate "+ p.getLoco()+"?";
		traits[8]="Is your primate's nostril "+p.getNostril()+" facing?";
		traits[9]="Is your primate's tail=" +p.isTail()+"?";
		traits[10]="Is your primate's Dental Comb="+p.isDenCom()+"?";
		traits[11]="Is your primate's Grooming Claw="+p.isGroClaw()+"?";
		traits[12]="is your primate sexual dimorphism="+p.isSexualDimor()+"?";
		return traits[i];
		
	}
	
	/*
	 * @param input, the user's answer towards the question
	 * @return boolean, user's answer in boolean 
	 * this method just transform string input to boolean
	 */
	public static boolean answer(Scanner input) {
		int ans = Integer.parseInt(input.nextLine());
		if(ans==1) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @return int[] return an array represents 
	 * questions' order
	 */
	public static int[] queOrder() {
		Random randNum = new Random();
	    Set<Integer>set = new LinkedHashSet<Integer>();
	    while (set.size() < 13) {
	    	set.add(randNum.nextInt(13));
	    }
	    int[] queOrder = new int[13];
	    int i=0;
        for (int x : set) 
            queOrder[i++] = x; 
        return queOrder;
	}
	
	/*
	 * @return int[] return an array same as questions' order
	 */
	public static int[] copy(int[] o) {
		int[] d = new int[o.length];
		for(int i=0;i<o.length;i++) {
			d[i] = o[i];
		}
		return d;
	}
	
	/*
	 * @param primates, the current linked list of primates
	 * @param i, which trait are we looking for
	 * @return String of traits
	 */
	public static String returnTrait(LinkedList primates,int i) {
		Primate p = primates.getHeader().next().getData();
		String[] traits = new String[13];
		traits[0]=String.valueOf(p.isPostOrbClo());
		traits[1]=p.getEcto();
		traits[2]=String.valueOf(p.getDenFormu());
		traits[3]=p.getActTime();
		traits[4]=p.getDiet();
		traits[5]=p.getLocation();
		traits[6]=p.getColor();
		traits[7]=p.getLoco();
		traits[8]=p.getNostril();
		traits[9]=String.valueOf(p.isTail());
		traits[10]=String.valueOf(p.isDenCom());
		traits[11]=String.valueOf(p.isGroClaw());
		traits[12]=String.valueOf(p.isSexualDimor());
		return traits[i];
	}
	
}
