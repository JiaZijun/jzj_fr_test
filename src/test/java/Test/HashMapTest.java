package Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {
	
	public static void main(String[] args) {
		//hashMap是无序的
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("a3", "aa");
		hashmap.put("b2", "bb");
		hashmap.put("c1", "cc");
		System.out.println(hashmap.values());//[bb, aa, cc]
		
		//linkMap是有序的
		Map<String, String> linkMap = new LinkedHashMap<String, String>();
		linkMap.put("a3", "aa");
		linkMap.put("b2", "bb");
		linkMap.put("c1", "cc");
		System.out.println(linkMap.values());
		
		
	}

}
