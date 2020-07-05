import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {
        int response = 0;
        HashMap map = new HashMap<>();
    	for(int i : sales){
    		if(map.containsKey(i)){
    			int count = (int) map.get(i);
    			count = count +1;
    			map.put(i, count);
    		}else{
    			map.put(i, 1);
    		}
    	}
    	
    	System.out.println(map.toString());
    	HashMap redmap = sortByValues(map); 
    	System.out.println(redmap.toString());
    	
    	return response;
    	
    	
    }
    
    public static HashMap sortByValues(HashMap map) { 
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
             public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                   .compareTo(((Map.Entry) (o2)).getValue());
             }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
               Map.Entry entry = (Map.Entry) it.next();
               sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        return sortedHashMap;
   }
 

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 6, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}