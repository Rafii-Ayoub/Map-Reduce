import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	/**
	 * This class runs the server
	 * @throws IOException 
	 */
	
	
	public static void main(String args[]) throws IOException {
	
	 ServerSocket serverSocket = new ServerSocket(8000);
    
	
    
	 // Call the run method from VMHandler to execute the program and to run to run VMs and ReducerMachine 
	 
	 while (true) {
	    Socket socket ;
		try {
	        socket = serverSocket.accept();
	        new VMHandler( socket,"html1.txt").run();
	    } catch (IOException e) {
	        System.out.println("I/O error: " + e);
	   
            }
		
	     }
	}
	
}



