package kr.s20.object.lang;

/*
 * [실습]
 * 로또 프로그램 제작
 * 길이가 6인 int형 배열을 생성하고 1~45 숫자 범위로 난수를 구함
 * 중복되지 않은 6개의 숫자를 생성해서 배열에 저장하고 출력하시오
 * 난수 생성 : Math.random() 또는 Random 클래스의 nextInt() 메서드 사용
 */

import java.util.Arrays;



public class MathMain04 {
	
	public static void main(String[] args) {
		// lotto 번호 저장할 배열 생성
		int[] lotto = new int[6];

		// 로또 번호 6자리 생성
		for (int i=0; i<lotto.length; i++) {
			// 난수*n => 0~(n-1) 따라서 +1 => 1~45 
			lotto[i] =(int)(Math.random()*45) + 1;
			
			
			// 중복 제거 / 현재 배열의 길이만큼 비교하면 되기 때문에 i보다 작을 때까지 비교
			// 자기 자신과의 비교는 삼가 (등호 붙지 않은 이유)
			for (int j=0; j<i; j++) {
				// 방금 뽑은 숫자(i번째)가 이전에 뽑은 숫자(0~j)와 같다면
				if (lotto[i]==lotto[j]) {
					i--; // i-- => 다시 i번째 숫자를 뽑으러 가기 때문에 중복은 제거됨
					break;
				} 
			}			
		}
		
		Arrays.sort(lotto); // 배열 오름차순 정렬
		
		
		// 로또 번호 출력
		System.out.print("로또 번호 : ");
		
		for (int num : lotto) {
			System.out.print(num + " ");
		}
		
		/*
		// 로또 번호 출력
		System.out.print("로또 번호 : ");
		for (int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		*/

	}


}
