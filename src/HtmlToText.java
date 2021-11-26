
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlToText {
	
	/**
	 * function to scrape a website and extract the code source (HTML) in a txt file
	 * @param startSite
	 * @throws Exception
	 */
    public void htmlToTxt(String startSite) throws Exception {

    URL u = new URL(startSite);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    BufferedWriter bw = new BufferedWriter(new FileWriter("html.txt"));
    String code = new String();
    while ((code = br.readLine()) != null) {
        bw.write(code);
        bw.newLine();
    }
    bw.close();
    br.close();
    isr.close();
    is.close();
}
    
}