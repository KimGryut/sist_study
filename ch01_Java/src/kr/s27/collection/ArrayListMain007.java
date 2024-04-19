package kr.s27.collection;

/*
 * [실습]
 * 로또 프로그램 제작
 * 1~45까지 중복되지 않는 6개의 숫자를 구해서 ArrayList에 저장하고 출력
 * 오름차순으로 정렬하여 출력하시오
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListMain007 {
	public static void main(String[] args) {
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		Random ra = new Random();
		
		while(lotto.size()<6) {
			int num = ra.nextInt(45) + 1;
			if (! lotto.contains(num)) {
				lotto.add(num);
			}
		}
		
		Collections.sort(lotto);
		System.out.println(lotto);
	}
}
