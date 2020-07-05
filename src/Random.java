import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.StringTokenizer;

class Random {  
  public static void main (String[] args) {
    System.setProperty("http.agent", "Chrome");
    try {
      URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
      try {
        URLConnection connection = url.openConnection();
        //System.err.println();
        InputStream inputStream = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();
        
        String subStrVar = sb.toString();
        subStrVar = subStrVar.substring(subStrVar.indexOf("data")+6, subStrVar.length());
        subStrVar = subStrVar.replaceAll("}", "");
        subStrVar = subStrVar.replaceAll("\"", "");
        subStrVar = subStrVar.replaceAll(" ", "");
        subStrVar = subStrVar.trim();
        
        StringTokenizer st = new StringTokenizer(subStrVar,",");
        int count = 0;
        while(st.hasMoreElements()){
        	String ele = (String) st.nextElement();
        	String[] innerStr = ele.split("=");
        	if(innerStr[0].equalsIgnoreCase("age")){
        		if(Integer.parseInt(innerStr[1]) >= 50){
        			count ++;
        		}
        	}
        }
        
        System.out.println(count);
        
        
      } catch (IOException ioEx) {
        System.out.println(ioEx);
      }
    } catch (MalformedURLException malEx) {
      System.out.println(malEx);
    }
  }
}