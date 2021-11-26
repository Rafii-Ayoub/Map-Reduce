import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tests {

	public static void main (String args[]) throws Exception {
		
	   // The first step is to scrape a website
	   // Then  
	   HtmlToText a = new HtmlToText();
	   a.htmlToTxt("https://en.wikipedia.org/wiki/Lionel_Messi");
	   FileReader reader = new FileReader("html.txt");
       BufferedWriter bw = new BufferedWriter(new FileWriter("html1.txt"));
       bw.write(HtmlUtilis.extractText(reader));
       bw.newLine();
       bw.close();
			
		// The second step is to create a FileDivider Object 
		// The first argument of this object is the path of the file
		// the second argument is the number of splits
		//FileDivider fd = new FileDivider("text.txt",10);
		//fd.divideFile();
		
		// The third step is to associate each file to a VM
		// Each VM will do mapping then a ReducerMachine will do reducing 
		// We used sockets to do multithreading and communicate beteween Vm's and server
		//Server server = new Server(4500);
		//server.run();
	}
	  
	
}



