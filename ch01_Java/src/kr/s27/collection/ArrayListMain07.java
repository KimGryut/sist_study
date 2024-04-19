package kr.s27.collection;

/*
 * [실습]
 * 로또 프로그램 제작
 * 1~45까지 중복되지 않는 6개의 숫자를 구해서 ArrayList에 저장하고 출력
 * 오름차순으로 정렬하여 출력하시오
 */


import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain07 {
	public static void main(String[] args) {
		// 리스트 생성
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		
		int i=0;
		while (i!=6) { // 6이 되면 멈추기 때문에 5까지 작동 -> 6개 숫자 뽑기
			int num = (int)(Math.random()*45)+1; // 난수 생성
			// 위에서 생성한 난수가 포함되는지 확인
			boolean tf = lotto.contains(Integer.valueOf(num)); 
			if (tf == false) { // 없다면
				lotto.add(num); // 리스트에 추가
				i++; // i +1
			}
		}
		
		// 오름차순 정렬
		Collections.sort(lotto);
		System.out.println(lotto);
	}
}

