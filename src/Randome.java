public class Randome {
	
	public String getD(String s,String t){
		String finalString = t;
		
		
		if (s.length() % t.length() !=0 ){
			return "none";
		}
		
		if(t.length() % 2 == 0){
			String sTemp = t.substring(0, t.length()/2);
			String tTemp = t.substring(t.length()/2,t.length());
		}
		
		return finalString;
	}
	
	
	
	
	public static void main(String[] args) {
		
		String s = "abababababab";
		String t = "ababab";
		
		Randome ob = new Randome();
		//System.out.println(ob.getD(s, t));
		System.out.println(t.substring(0, t.length()/2));
		
		
	}

}
