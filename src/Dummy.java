import java.util.*;

public class Dummy {
    public static int nthLowestSelling(int[] sales, int n) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");        
       // int response = 0 ;
        Map<Integer, Integer> books = new LinkedHashMap<>();
        int count = 1 ;
        for(int i : sales){
            if(books.containsKey(i)){
                count = (int) books.get(i);
                count++;
                books.put(i, count);
            } else {
                books.put(i, count);
            }
        }
        
       /* Set<Integer> keys = books.keySet();
        for (int k : keys ) {
        	if((int)books.get(k) == n){
                response = k;
        	    break;
            }
          
        }*/
        
       System.out.println("Before Sorting:");
         Set set = books.entrySet();
         Iterator iterator = set.iterator();
         while(iterator.hasNext()) {
               Map.Entry me = (Map.Entry)iterator.next();
               System.out.print(me.getKey() + ": ");
               System.out.println(me.getValue());
         }
         Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(books); 
         System.out.println("After Sorting:");
         Set set2 = sortedMap.entrySet();
         Iterator iterator2 = set2.iterator();
         while(iterator2.hasNext()) {
              Map.Entry me2 = (Map.Entry)iterator2.next();
              System.out.print(me2.getKey() + ": ");
              System.out.println(me2.getValue());
            
         }
        int response = sortedMap.entrySet().stream()
					   .skip(n)
					   .map(map -> map.getValue()).findFirst().get();
        System.out.println(response);
        
        
        return response;
    }

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5,2 }, 2);
        System.out.println(x);
    }
}