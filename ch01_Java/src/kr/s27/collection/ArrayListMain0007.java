package kr.s27.collection;

/*
 * [실습]
 * 로또 프로그램 제작
 * 1~45까지 중복되지 않는 6개의 숫자를 구해서 ArrayList에 저장하고 출력
 * 오름차순으로 정렬하여 출력하시오
 */


import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain0007 {
	public static void main(String[] args) {
		// 리스트 생성
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		// 6개 뽑기
		for (int i=0; i<6; i++) {
			// 난수 생성
			int num = (int)(Math.random()*45)+1;
			// 로또 리스트 안에 생성한 난수가 있는지 없는지 확인
			boolean tf = lotto.contains(Integer.valueOf(num));
			if (tf == false) { // 없다면
				lotto.add(num); // 리스트에 추가
			} else { // 있다면
				i--; // 없는 일로 하기 위해 i를 -1
			}
		}
		
		// 오름차순 정렬
		Collections.sort(lotto);
		System.out.println(lotto);
	}
}
