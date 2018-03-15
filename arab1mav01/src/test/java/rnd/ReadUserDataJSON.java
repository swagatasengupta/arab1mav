package rnd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadUserDataJSON {

	public static void main(String[] args) throws FileNotFoundException {

		String relJSONFilePath = "resources/userdata.json";
		JSONTokener tokener = new JSONTokener(
				new FileReader(
						new File(relJSONFilePath).getAbsolutePath()
						)
				);
		JSONArray jarr= new JSONArray(tokener);
		System.out.println(jarr.toString());
		
		//a.	Age of second user
		JSONObject user2 = (JSONObject) (
								(JSONObject)jarr.get(0)
								)
							.get("usr2");
		System.out.println(user2.get("age"));

		//b.	Second address’s city (Jubiyami) of the first user.
		JSONObject user1 = (JSONObject) ((JSONObject)jarr.get(0)).get("usr1");
		JSONObject user1Address2 = (JSONObject)user1.getJSONArray("addresses").get(1);
		System.out.println(user1Address2.get("city"));
	}

}
