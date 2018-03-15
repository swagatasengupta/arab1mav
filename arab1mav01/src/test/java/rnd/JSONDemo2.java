package rnd;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo2 {

	public static void main(String[] args) {
		
		//Method 1 of converting from String to JSON
		String jsonBodyString = "{"
				+ "\"key1\":\"String Value\","
				+ "\"key2\":56,"
				+ "\"key3\":[10,20,30,40,50]}";		
		JSONObject jobj1 = new JSONObject(jsonBodyString);
		System.out.println("Key1: " + jobj1.get("key1"));
		System.out.println("Key2: " + jobj1.getInt("key2"));
		
		JSONArray key3 = (JSONArray)jobj1.get("key3");
		for(int i=0; i<key3.length(); i++) {
			System.out.println(key3.get(i));
		}
		
		//Method 2 - 
		JSONObject jobj2 = new JSONObject();
		jobj2.put("2.1", "Name");
		jobj2.put("2.2", 8760);
		jobj2.put("2.3", new JSONObject().put("2.3.1", "Test"));
		
		System.out.println(jobj2.toString());
	}

}
