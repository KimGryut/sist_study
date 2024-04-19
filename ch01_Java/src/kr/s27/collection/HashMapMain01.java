package kr.s27.collection;

import java.util.HashMap;

public class HashMapMain01 {
	public static void main(String[] args) {
		/*
		 * Map : key와 value의 쌍으로 저장
		 */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("김신", 95);
		map.put("지은탁", 100);
		map.put("저승사자", 85);
		map.put("써니", 93);
		map.put("유덕화", 70);
		
		// 키가 중복되면 마지막에 입력한 값이 인정됨
		map.put("지은탁", 0); 
		
		// key와 value에 null을 허용
		map.put("강호동", null); // value를 비워둬도 오류가 나지 않음
		map.put(null, 22); // key를 비워둬도 오류가 나지 않음
		
		
		// 저장된 데이터(key와 value의 쌍)의 목록
		System.out.println(map); // 뒤죽박죽 나옴
		System.out.println("---------------------");
		
		Integer num = map.get("지은탁");
		System.out.println("지은탁의 성적은 " + num);
		
		
		
	}
}
