import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DummyRest {
	
	public void Data() throws IOException{
		String finalResponse = "";
		int first =1;
		int last = 10;
		
		StringBuffer response = new StringBuffer();
		do{
			String GET_URL = "https://9e6ebde9-4dce-4bbf-914a-09738c38c389.mock.pstmn.io/employee?page="+first+"-"+last;
			response = new StringBuffer();
			URL obj = new URL(GET_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	
			finalResponse += response.toString()+"\n";
			first +=10;
			last +=10;
		}while(!response.toString().equalsIgnoreCase("done"));
		System.out.println(finalResponse);
		
	}
	
	public static void main(String[] args) {
		
		try {
			new DummyRest().Data();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
