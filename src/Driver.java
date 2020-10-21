import java.util.HashMap;

public class Driver {

	public static void main(String[] args) {
		XMLParser parser = new XMLParser("/home/sudipta/Downloads/Source_data.xml");
		HashMap<String, String> elements = parser.parse();
		System.out.println("parser.get example: "+parser.get(".document.error.login-faild"));
		System.out.println("hashmap size: "+elements.size());
		for (String i : elements.keySet()) {
			  System.out.println(i + ": " + elements.get(i));
			}

	}

}
