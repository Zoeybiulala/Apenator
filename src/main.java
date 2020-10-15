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
		    
		    System.out.println(primates.toString());
		    	
	}

}
