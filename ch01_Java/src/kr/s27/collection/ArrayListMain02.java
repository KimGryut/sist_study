package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		/*
		 * list 구조의 특징
		 * 저장된 순서 유지, 중복 저장 허용
		 * 
		 */
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동"); // String -> Object
		list.add("장영실"); // String -> Object
		list.add("박문수"); // String -> Object
		list.add("양아아"); // String -> Object
		
		// 저장된 요소의 목록
		System.out.println(list);
		
		// 반복문을 통한 저장된 요소 출력
		for (int i=0; i<list.size();i++) {
			String name = (String)(list.get(i)); // 다운캐스팅 해주지 않으면 타입 오류.
			System.out.println(name);
		}
	}
}
