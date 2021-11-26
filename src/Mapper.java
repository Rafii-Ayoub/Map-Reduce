 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


public class Mapper {
	

    // Declaring variables
	private Readable file;
	private static HashMap<String, Integer> map = new HashMap<>();
	
	
	/**
	 * Constructor
	 * @param path
	 */
	
    public Mapper(String path) {
		super();
		File file = new File(path);
	}

    
    /**
     * function to convert the text file to a hashMap
     * @return HashMap<String, Integer>
     */
	
	public HashMap<String, Integer> convert() {
		
    List<String> textLines = new ArrayList<String>();
    Scanner scan = new Scanner(this.file);
    int i =0;
   
    // Convert scan object to List of string that contains lines of the text
    while (scan.hasNextLine()){	
    	String line = scan.nextLine();
    	textLines.add(line);
    	i++;	 	
    }
  
    
    // We count words for each line 
    // We store the result in the hashMap
    for(int k=0; k<textLines.size(); k++) {
    	String line = textLines.get(k);
    	
    	
    	line = line.replaceAll("[^a-zA-Z0-9]", " "); 
    	String[] pairs = line.split(" ");

    	for (int k1=0;k1<pairs.length;k1++) {
    	    String pair = pairs[k1];
    	     
    	     if (map.containsKey(pair)){ 	 
    	    	 int k2= map.get(pair) ;
    	         map.put(pair, k2 +1 );}
    	     
    	     else { map.put(pair, 1);}
    	     
    	 }
    	
	  }
     return map;
	}   
    
	
	
	/**
	 * Function to traverse through the hashmap and print frequencies 
	 */
	private void showMapperResult() {
		
		 for (Entry<String, Integer> entry : this.map.entrySet())
		    {
		        System.out.println(entry.getKey() + " " + entry.getValue());
		        
		    }
	}
	
	// setters and getters
	
	public Readable getFile() {
		return file;
	}

	public void setFile(Readable file) {
		this.file = file;
	}

	
	
}    
	
	
	

  
	
