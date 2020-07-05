import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MessageTransformer {
	
	
	public StringBuilder replaceLogic(StringBuilder input){
		StringBuilder resp = new StringBuilder();
		String output = input.toString().replaceAll("\\$", "e");
		output = output.replaceAll("\\^", "y");
		output = output.replaceAll("\\&", "u");
		resp.append(output);
		return resp;
	}
	
	
	public StringBuilder reverseLogic(StringBuilder input){
		
		StringBuilder resp = new StringBuilder();
		String[] lines = input.toString().split("\\n");
		String reverseWord="";  
		for(String s:lines){
			String temp[] = s.split(" ");
			for(String w:temp){  
		        StringBuilder sb=new StringBuilder(w);  
		        sb.reverse();  
		        reverseWord+=sb.toString()+" ";  
		    }
			reverseWord = reverseWord.concat("\n");
		}
		
		resp.append(reverseWord.trim());
		return resp;
	}
	
	public void runMethod(){
		boolean replaceLogic = false;
		boolean reverseLogic = false;
		boolean replaceAndReverse = false;
		StringBuilder st = null;
		Map<String,StringBuilder > map = new HashMap<String, StringBuilder>();
		 try {
		      File myObj = new File("/Users/sandeepkoyyada/Documents/workspace/MessageTransformer/src/132443500.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.startsWith("To")){
		        	st = new StringBuilder();
		        	st.append(data);
		        	map.put("To", st);
		        	if(data.contains("domain.com")){
		        		replaceLogic = true;
		        	}
		        }else if(data.startsWith("From")){
		        	st = new StringBuilder();
		        	st.append(data);
		        	map.put("From", st);
		        }else if(data.startsWith("Subject")){
		        	st = new StringBuilder();
		        	st.append(data);
		        	map.put("Subject", st);
		        	if(data.startsWith("Subject:SECURE:")){
		        		reverseLogic = true;
		        	}
		        }else if(data.startsWith("Body")){
		        	st = new StringBuilder();
		        }else {
		        	st.append(data);
		        	st.append("\n");
		        	if(data.matches("^.*[0-9]{10,}.*?$")){
		        		replaceAndReverse = true;
		        	}
		        } 
		      }
		      map.put("Body", st);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 System.out.println(map.get("To"));
		 System.out.println(map.get("From"));
		 System.out.println(map.get("Subject"));
		 StringBuilder bodyObj = map.get("Body");
		 StringBuilder output = new StringBuilder();
		 if(replaceAndReverse){
			 output = replaceLogic(bodyObj);
			 output = reverseLogic(output);
		 }else if(replaceLogic){
			 output = replaceLogic(bodyObj);
		 }else if(reverseLogic){
			 output = reverseLogic(bodyObj);
		 }else {
			 output = bodyObj;
		 }
		 System.out.println("Body:");
		 System.out.println(output.toString());
	}
	
	public static void main(String[] args) {
		MessageTransformer ob = new MessageTransformer();
		ob.runMethod();
	   
	  }

}
