package kr.s27.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain06 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		
		// 인덱스 탐색
		int index1 = list.indexOf("사과"); // 중복값은 첫번째 사과
		System.out.println("첫 번째 사과: " + index1);
		
		int index2 = list.lastIndexOf("사과"); // 마지막 사과 찾기
		System.out.println("마지막 사과: " + index2);
		
		int index3 = list.indexOf("망고"); // 없는 값 찾을 땐 -1반환
		System.out.println("망고: " + index3);
		
		boolean f1 = list.contains("머루"); // 해당 요소가 있으면 true
		System.out.println("머루가 있나? : " + f1);
		
		boolean f2 = list.contains("망고"); // 없으면 false
		System.out.println("망고가 있나? : " + f2);
		
		System.out.println(list);
		
		System.out.println("--------------");
		
		// 사전 명시된 순서대로 정렬
		Collections.sort(list);
		System.out.println(list);
		
		// 역순으로 정렬
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("-------------");
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(100);
		list2.add(15);
		list2.add(2);
		list2.add(40);
		
		System.out.println(list2);
		
		// 오름차순 정렬 (낮은 -> 높은)
		Collections.sort(list2);
		System.out.println(list2);
		
		// 내립차순 정렬 (높은 -> 낮은)
		Collections.reverse(list2);
		System.out.println(list2);
		
	}
}
