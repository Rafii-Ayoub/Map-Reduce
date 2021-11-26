import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDivider {

        // declaring variables
	    private String path;
	    private long numSplits; 
	    
	    /**
	     * Constructor
	     * @param path
	     * @param numSplits
	     */
	    
        public FileDivider(String path, long numSplits) {
			super();
			this.path = path;
			this.numSplits = numSplits;
		}
        
       /**
        * function to divide the origianl file into sub files depending to numSplits
        * @throws Exception
        */

		public void divideFile() throws Exception {
			
		RandomAccessFile raf = new RandomAccessFile(this.path, "r");
        long sourceSize = raf.length();
        long bytesPerSplit = sourceSize/numSplits ;
        long remainingBytes = sourceSize % numSplits;
        int maxReadBufferSize = 8 * 1024; 
        
        // We will create files depending to remainingBytes 
        // Size of file must be smaller or equal to remainingBytes
        
        for(int destIx=1; destIx <= numSplits; destIx++) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split."+destIx));
            if(bytesPerSplit > maxReadBufferSize) {
                long numReads = bytesPerSplit/maxReadBufferSize;
                long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                for(int i=0; i<numReads; i++) {
                    readWrite(raf, bw, maxReadBufferSize);
                }
                if(numRemainingRead > 0) {
                    readWrite(raf, bw, numRemainingRead);
                }
            }else {
                readWrite(raf, bw, bytesPerSplit);
            }
            bw.close();
        }
        if(remainingBytes > 0) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split."+(numSplits+1)));
            readWrite(raf, bw, remainingBytes);
            bw.close();
        }
            raf.close();
        }
		
	/**
	 * 
	 * @param raf
	 * @param bw
	 * @param numBytes
	 * @throws IOException
	 */

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if(val != -1) {
            bw.write(buf);
        }
    
    }
    
    
    // getters and setters
    
    public long getNumSplits() {
 			return numSplits;
 		}

 	public void setNumSplits(long numSplits) {
 			this.numSplits = numSplits;
 		}
    
}