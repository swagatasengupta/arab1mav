package rnd;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONDemo1 {

	public static void main(String[] args) {
		JSONObject jobj = new JSONObject();
		JSONArray jarr = new JSONArray();
		jobj.put("name", "Swagata");
		jobj.put("experience", 14);
		
		JSONObject address1 = new JSONObject();
		address1.put("house_num", "H123/172");
		address1.put("street_num", 30);
		address1.put("area", "Manikonda, Hyderabad");
		jarr.put(address1);

		JSONObject address2 = new JSONObject();
		address2.put("house_num", "F-482, Phase 1");
		address2.put("street_num", 267);
		address2.put("area", "Shyambazar, Kolkata");
		jarr.put(address2);


		JSONObject contact = new JSONObject();
		contact.put("phone","+91-9374849920");
		contact.put("email", "swagata.sengupta@devop-trics.com");
		jobj.put("addresses", jarr);
		jobj.put("contact", contact);
		
		System.out.println(jobj.toString());
		System.out.println(jobj.length());

		System.out.println(jobj.getJSONArray("addresses"));
		System.out.println(jobj.getJSONObject("contact"));
		JSONObject cont = jobj.getJSONObject("contact");
		System.out.println(cont.get("phone"));
		
	}
}
