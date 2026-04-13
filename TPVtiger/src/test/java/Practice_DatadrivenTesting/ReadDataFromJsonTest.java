package Practice_DatadrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	//step1: parse json physical file into java object using JsonParse Class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\priya\\OneDrive\\Desktop\\appCommonData.json"));

	//Step2: Convert java object into JSONObject using downcasting
		JSONObject map=(JSONObject)obj;
		
   //step3: get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		System.out.println(map.get("browser"));
	}

}
