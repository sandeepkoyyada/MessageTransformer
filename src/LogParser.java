import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
    	List<Integer> list = new ArrayList();
    	try {
   		 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("entry");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  
                  String emessage = eElement
                          .getElementsByTagName("message")
                          .item(0)
                          .getTextContent();
                  
                  String key =  eElement.getAttribute("id");
                 if(emessage.equalsIgnoreCase(message)){
                	 list.add( Integer.parseInt(key));
                 }
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
		return list;
    }
    
    public static void main(String[] args) throws Exception {
        String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" + 
                "    <entry id=\"1\">\n" + 
                "        <message>Application started</message>\n" + 
                "    </entry>\n" + 
                "    <entry id=\"2\">\n" + 
                "        <message>Application ended</message>\n" + 
                "    </entry>\n" + 
                "</log>";
        
        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println(id);
        
        
    }
    
}