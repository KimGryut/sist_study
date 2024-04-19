package kr.s27.collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableMain {
	public static void main(String[] args) {
		// String 썼다가 Integer 썼다가 할 거면 Object를 써야 함
		Hashtable<String, Object> h = new Hashtable<String, Object>();
		h.put("name", "홍길동");
		h.put("age", 29);
		h.put("tel", "010-1234-5678");
		h.put("job", "경찰");
		h.put("address", "서울");
		// key가 중복되면 마지막에 입력한 값이 인정
		h.put("name", "홍길순");
		
		// Hashtable -> key와 value에 null 불허
		// h.put("hobby", null)
		// h.put(null, "프로그래머");
		
		// 저장된 데이터(key, value의 쌍) 목록
		System.out.println(h);
		System.out.println("-------------------------------");
		
		// key를 통해서 value 구하기
		String name = (String)h.get("name");
		Integer age = (int)h.get("age");
		System.out.println(name + ", " + age);
		
		// Enumeration
		Enumeration<String> en = h.keys();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key + ", " + h.get(key));
		}
	}
}
