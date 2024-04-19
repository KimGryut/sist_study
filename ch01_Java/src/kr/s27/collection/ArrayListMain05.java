package kr.s27.collection;

import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(15);
		list.add(16);
		
		// 저장된 요소의 목록
		System.out.println(list);
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i)%2==0) {
				list.remove(i);
				i--; // 인덱스 변동하면 확인하기 전에 인덱스 번호가 앞으로 당겨지는 경우가 있기 때문에
					 // 요소가 사라졌다면 인덱스도 1만큼 사라질 것이기 때문에 i도 1 깎아준다
			} 
		}
		
		System.out.println(list);
		
		System.out.println("----------------");
	
		// 인덱스 변동 해결 (2)
		// 마지막 인덱스부터 확인
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(15);
		list2.add(16);
		
		// 저장된 요소의 목록
		System.out.println(list2);
		
		for (int i=list2.size()-1; i>=0; i--) {
			if(list2.get(i)%2==0) {
				list2.remove(i);
			}
		}
		
		System.out.println(list2);
		
		
	}	
}
