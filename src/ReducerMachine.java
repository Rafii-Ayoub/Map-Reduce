import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class ReducerMachine {
	
	
     private int port;
     
    /**
     * Constructor
     * @param port
     */
    public ReducerMachine(int port) {
		super();
		this.port = port;
	}
    
    /**
     * This function are used to call the reducer function that will be executed in a VM 
     * @param mapsList
     * @return HashMap<String, Integer>
     */
    
    public HashMap<String, Integer> reducing (List<HashMap<String,Integer>> mapsList)
    {
        // establish a connection by providing host and port
        
        try (Socket socket = new Socket("localhost", this.port)) {
            
           Reducer r = new Reducer (mapsList);
           return r.reduce();
           
        }
        catch (IOException e) {
            e.printStackTrace();
            return null ; 
        }
        
    }

}
