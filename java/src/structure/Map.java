package structure;

import java.util.HashMap;

/*
 * HashMap 
 * - 키(key)와 값(value)을 묶어서 하나의 데이터(entry)로 저장
 * - key는 중복 허용하지 않고, value는 중복 가능
 * - Key와 Value값에 null값을 허용
 * - 이미 존재하는 key를 포함하는 key-value가 들어오면 최근에 들어온 key-value로 갱신.
 */

public class Map {

	public static void main(String[] args) {
	
		//HashMap 정의
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//데이터 저장
		map.put(1,"Apple");
		map.put(2, "Banana");
		map.put(3, "Carrot");
		
		System.out.println(map);
		
		//데이터 제거 -> key값으로 제거
		map.remove(3);
		
		System.out.println(map);
		
		map.put(3, "Candy");
		map.put(4, "Donut");
		
		System.out.println(map.entrySet());	// HashMap에 저장된 모든 key-value 엔트리를 반환
		
		System.out.println(map.size()); 	//HashMap의 크기 반환
		System.out.println(map.get(2)); 	//key값이 2인 value 반환
		
		System.out.println(map.containsKey(1)); 	//해당 key가 HashMap에 존재하는지 여부를 알려준다. (true/false)
		System.out.println(map.containsKey(10)); 
		System.out.println(map.containsValue("Candy"));	//해당 value가 HashMap에 존재하는지 여부를 알려준다. (true/false)
		System.out.println(map.containsValue("Elmo"));
		System.out.println(map.isEmpty());	// 해당 HashMap이 비어있는지 여부를 알려준다. (true/false)
		
		System.out.println(map.keySet());	// HashMap에 저장된 모든 key를 보여줌. (return: Set)
		System.out.println(map.values());	// HashMap에 저장된 모든 value를 collection형태로 반환 
		
		HashMap newmap = (HashMap)map.clone();	// HashMap 복제
		map.clear(); 	// HashMap 초기화
		System.out.println(map);
		System.out.println(newmap);
		
	}
}
