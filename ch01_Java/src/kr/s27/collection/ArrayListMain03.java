package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		/*
		 * 제네릭 표현 : 객체를 생성할 때 객체에 저장할 수 있는 요소의 타입을 지정
		 * 
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동"); // String => Object
		list.add("장영실"); // String => Object
		// list.add(100); // Integer => Object <- String 명시한 덕분에 오류
		list.add("김유신"); // String => Object
		
		// 반복문을 이용한 요소의 출력
		for (int i=0; i<list.size(); i++) {
			String name = (String) list.get(i);
			System.out.println(name);
			}
		
		System.out.println("================");
		
		// 확장 for문을 이용한 요소의 출력
		for (String name : list) {
			System.out.println(name);
		}
	}
}
