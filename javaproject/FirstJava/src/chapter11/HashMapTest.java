package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, SmartPhone> hashMap = new HashMap<>();
		
		hashMap.put("Spring", new SmartPhone("Spring", "010-1111-1111"));
		hashMap.put("king", new SmartPhone("king", "010-9999-3333"));
		
		System.out.println(hashMap.get("king"));
		
		hashMap.put("Son", new SmartPhone("Son", "010-9911-3223"));
		hashMap.put("king", new SmartPhone("Son", "010-7777-7777"));	// 이전 king 덮어쓴다
		
		
		
		System.out.println(hashMap.get("Son"));
		System.out.println(hashMap.get("son"));
		System.out.println(hashMap.get("king"));
		System.out.println("=================================");
		
		// 키 값들을 Set 객체로 받는다
		Set<String> keySet = hashMap.keySet();
		
		for(String key : keySet) {
			// System.out.println(key);	Son king Spring 출력
			 System.out.println(key + "=" + hashMap.get(key));
		}
	}

}
