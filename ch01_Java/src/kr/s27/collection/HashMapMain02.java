package kr.s27.collection;

import java.util.HashMap;
// import java.util.Set;
import java.util.Iterator;

public class HashMapMain02 {
	public static void main(String[] args) {
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// HashMap에 key와 value에 저장
		for(int i=0; i<msg.length; i++) {
			map.put(i, msg[i]);
		}
		
		// HashMap의 데이터 목록 호출
		System.out.println(map);
		System.out.println("-------------------------------------------------");
		
		// 해쉬맵에선 호출하는 메서드가 없어서 이터레이터의 메서드를 사용하기 위해
		// HashMap -> Set -> Iterator
		
		/* 
		 * Set<Integer> s = map.keySet();
		Iterator<Integer> keys = s.iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ", " + map.get(key)); 		
		}	
		*/
		
		// 짧게 명시
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ", " + map.get(key)); 		
		}	
	}
}
