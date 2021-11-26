import java.io.*;
import java.net.*;
import java.util.*;


public class VM {
    
    private int machineNum;
    
    /**
     * Constructor 
     * @param machineNum
     */
    
    public VM(int machineNum) {
		super();
		this.machineNum = machineNum;
	}

    /**
     * This method create a socket for the VM and executes the mapper.convert() method 
     * @return public HashMap<String, Integer>
     */
	public HashMap<String, Integer> process ()
    {
        // Mapping the file 
        int a = 3000 + machineNum;
        try (Socket socket = new Socket("localhost", a)) {
           String fileName = "split."+ this.machineNum;
           Mapper mapper = new Mapper(fileName);
           // use the convert method to  convert the file to hashmap 
           return mapper.convert();
         
        }
        catch (IOException e) {
            e.printStackTrace();
            return null ; 
        }
        
    }
	

	// getters and setters
	
	public int getMachineNum() {
		return machineNum;
	}

	public void setMachineNum(int machineNum) {
		this.machineNum = machineNum;
	}
	
	
}