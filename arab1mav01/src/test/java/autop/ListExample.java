package autop;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		
		List <String> myList = new ArrayList<String>();
		myList.add("First Element");
		myList.add("Second Element");
		myList.add("Third Element");
		System.out.println("List Size: " + myList.size());
		for(String str : myList) {
			System.out.println(str);
		}
		
		myList.remove("Second Element");
				
		System.out.println("List Size (after removal): " + myList.size());
		for(int i=0; i< myList.size(); i++) {
			System.out.println(myList.get(i));
		}

	}

}
