import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BackupFile {
	
	public String replaceLogic(String input){
		input = input.replaceAll("\\$", "e");
		input = input.replaceAll("\\^", "y");
		input = input.replaceAll("\\&", "u");
//		System.out.println(input);
		return input;
	}
	
	public String reverseLogic(String input){
		
		String words[]=input.split(" ");  
	    String reverseWord="";  
	    for(String w:words){  
	        StringBuilder sb=new StringBuilder(w);  
	        sb.reverse();  
	        reverseWord+=sb.toString()+" ";  
	    }  
		
		return reverseWord.trim();
	}
	
	public void runMethod(){
		boolean replaceLogic = false;
		boolean reverseLogic = false;
		StringBuilder st = new StringBuilder();
		Map<String,StringBuilder > map = new HashMap<String, StringBuilder>();
		 try {
		      File myObj = new File("/Users/sandeepkoyyada/Documents/workspace/MessageTransformer/src/132443504.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.startsWith("To") && data.contains("domain.com")){
		        	replaceLogic = true;
		        	st.append(data);
		        	map.put("To", st);
		        }else if(data.startsWith("From")){
		        	st = new StringBuilder();
		        	st.append(data);
		        	map.put("From", st);
		        }else if(data.startsWith("Subject")){
		        	reverseLogic = true;
		        	st = new StringBuilder();
		        	st.append(data);
		        	map.put("Subject", st);
		        }else if(data.startsWith("Body")){
		        	
		        }else {
		        	if(replaceLogic){
		        		data = replaceLogic(data);
		        	}
		        	if(reverseLogic){
		        		data = reverseLogic(data);
		        	}
		        } 
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void main(String[] args) {
		BackupFile ob = new BackupFile();
		ob.runMethod();
	   
	  }

}
