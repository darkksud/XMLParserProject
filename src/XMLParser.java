
import java.util.HashMap;

import javax.xml.parsers.SAXParser;  
import javax.xml.parsers.SAXParserFactory;  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;
public class XMLParser {
	private HashMap<String, String> elements;
	private String xmlPath;
	XMLParser(String xmlPath)
	{
		elements = new HashMap<String, String>();
		this.xmlPath = xmlPath;
	}
	public HashMap<String, String> parse()
	{

		try   
		{  
			SAXParserFactory factory = SAXParserFactory.newInstance();  
			SAXParser saxParser = factory.newSAXParser();  
			DefaultHandler handler = new DefaultHandler()   
			{  
				String tree="";
				   
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException   
				{  
					tree+="."+qName.toLowerCase();
				}  
				  
				public void endElement(String uri, String localName, String qName) throws SAXException   
				{  
					tree=tree.substring(0,tree.length()-qName.length()-1);
				}  
				
				public void characters(char ch[], int start, int length) throws SAXException   
				{  
					String value = new String(ch, start, length);
					value=value.trim();
					if(value.length()>0)
						elements.put(tree,value);
				}  
			};  
			saxParser.parse(xmlPath, handler);  
		}   
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}
		return elements;  
	}  
	String get(String str)
	{
		return elements.get(str);
	}
}  
