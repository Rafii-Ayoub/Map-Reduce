import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Reducer {
	
	private List<HashMap<String,Integer>> hashMapsList;

	/**
	 * Constructor
	 * @param hashMapsList
	 */
	
	public Reducer(List<HashMap<String,Integer>> hashMapsList) {
		super();
		this.hashMapsList = hashMapsList;
	}
	
	// Methods and functions
	
	/**
	 * function that returns the final hashMap that contains number of occurens.
	 * this function take a list of hashMaps each hashMap resulting bu mapping a sub file.
	 * @return HashMap<String, Integer> (the final hashMap)
	 */
	
	public HashMap<String, Integer> reduce() {
		
		  HashMap<String, Integer> map = hashMapsList.get(0) ;

	        for (int i = 0; i < this.hashMapsList.size(); ++i) {
	            for (Map.Entry<String, Integer> m : this.hashMapsList.get(i).entrySet()) {
	                if (map.containsKey(m.getKey())) 
	                	map.put(m.getKey(),  map.get(m.getKey()) + m.getValue());
	                else {
	                	map.put(m.getKey(),  m.getValue());
	                }
	            }
	            
	        }

	        return map;
	
	      }
	    
	

}
