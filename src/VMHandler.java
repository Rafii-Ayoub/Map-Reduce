import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VMHandler implements Runnable {
		
	    // declaring attributes
	    private final Socket clientSocket;
		private String file;

		/**
		 * Constructor 1
		 * @param socket
		 * @param file
		 */
		public VMHandler(Socket socket , String file)
		{
			this.clientSocket = socket;
			this.file = file;
		}
		
		/**
		 * Constructor 2
		 * @param socket
		 */
		public VMHandler(Socket socket )
		{
			this.clientSocket = socket;
		
		}

		
		// methods and functions
		
		/**
		 * This function divide a file into many sub files 
		 * It create also VM's that will execute the process() method 
		 * @param machineNumber
		 * @return  List<HashMap<String, Integer>> (the hashMaps List)
		 * @throws Exception
		 */
		
		public List<HashMap<String, Integer>> createMappers(int machineNumber) throws Exception
		{
			FileDivider fd = new FileDivider(file,machineNumber);
			fd.divideFile();
			int i = 1;
			List<HashMap<String,Integer>> mapsList = new ArrayList<HashMap<String,Integer>>();
			
			// create a VM that will map and shuffle each file
			while (i <= machineNumber) {
				 VM vm = new VM(i); 
				 mapsList.add(vm.process()); 	
				 i++;
			}
			
           return mapsList;
		}
		
		/**
		 * funtion to run the createMapper() method and reducing() from ReducerMachine
		 */
		
		public void run () {
			List<HashMap<String, Integer>> mapsList ;
			try {
				mapsList = this.createMappers(10);
				ReducerMachine rm = new ReducerMachine(2500);
				rm.reducing(mapsList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		// run the VMHandler
		public void main (String args[]) throws UnknownHostException, IOException {
			Socket socket = new Socket("localhost", 8000);
			VMHandler vm = new VMHandler(socket );
		    
		}
		
		
		// getters and setters

		public Socket getClientSocket() {
			return clientSocket;
		}
		
		
}
