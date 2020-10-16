import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {
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
			System.out.println(myEntries.size());
				
		    for(String[] row: myEntries) {
		    	Primate primate = new Primate(row);
		    	primates.insertAlpha(primate);
		    		//add primate to the linkedlist
		    }
		    
		    
		    Scanner input = new Scanner(System.in);
		    openQ(input,primates);
		    
		    System.out.println(askRanQ(primates));
		    //TODO:answer
		  
		    
		    
		    
		    
		    //System.out.println(primates.toString());
		    
		    
	}
	
	
	public static void openQ(Scanner input, LinkedList primates) {
		System.out.println("Hello, I'm Apenator, or you can call me Api!");
		System.out.println("Would you like to see how many primates I know? "
				+ "Press 1 to list all the name of primates in the database,"
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
		
	}
	
	
	public static String askRanQ(LinkedList primates) {
		String[] traits = new String[13];
		traits[0]="Post-orbital closure";
		traits[1]="Ectotympanic";
		traits[2]="Dental formula";
		traits[3]="Act time";
		traits[4]="Diet";
		traits[5]="Location";
		traits[6]="Color";
		traits[7]="Locomotion";
		traits[8]="Nostril";
		traits[9]="Tail";
		traits[10]="Dental Com";
		traits[11]="Grooming claw";
		traits[12]="Sexual dimorphism";
		int i = (int)(Math.random()*13);
		String s ="Is your primate: " + traits[i]+"=";
		Primate p = primates.getHeader().next().getData();
		switch (i) {
		case 0:
			s+= p.isPostOrbClo();
			break;
		case 1:
			s+= p.getEcto();
			break;
		case 2:
			s+= p.getDenFormu();
			break;
		case 3:
			s+= p.getActTime();
		case 4:
			s+= p.getDiet();
			break;
		case 5:
			s+= p.getLocation();
			break;
		case 6:
			s+= p.getColor();
			break;
		case 7:
			s+= p.getLoco();
			break;
		case 8:
			s+= p.getNostril();
			break;
		case 9:
			s+= p.isTail();
			break;
		case 10:
			s+= p.isDenCom();
			break;
		case 11:
			s+= p.isGroClaw();
			break;
		case 12:
			s+= p.isSexualDimor();
			break;

		}
		return s+"?";
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
