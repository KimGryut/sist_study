package kr.s27.collection;

import java.util.Vector;

public class VectorMain {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		// 요소의 추가
		v.add(100.3);
		v.add(3.14);
		v.add(1000.);
		
		// 확정 for문 이용한 요소 출력
		for(Double n : v) {
			System.out.println(n);
		}
		
		System.out.println("--------------------");
		
		// 요소 검색
		double search = 1000.0; // 검색할 요소
		int index = v.indexOf(search); // 검색
		if (index != -1) { // 있단 뜻 
			System.out.println("검색 요소 " + search + "의 위치: " + index);
 		} else {
 			System.out.println("검색 요소 " + search + " 없습니다.");
 		}
		
		System.out.println("--------------------");
		
		// 요소 삭제
		double de1 = 3.14; // 삭제할 요소
		if(v.contains(de1)) { // 삭제할 요소가 Vsctor의 요소인지 검사
			v.remove(de1);
			System.out.println(de1 + "삭제 완료");
		}
		
		
		
		
	}
}
