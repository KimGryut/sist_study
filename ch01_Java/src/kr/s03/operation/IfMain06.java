package kr.s03.operation;

public class IfMain06 {
	public static void main(String[] args) {
		
		/*
		 * 실습
		 * 
		 *  두 수를 입력했을 때 비교하여 결과 도출하는 프로그램
		 *  
		 *  예시
		 *  첫번째 : 3, 두번째 : 2
		 *  최대:3 최소:2
		 *  
		 *  첫번째 : 5, 두번째 : 5
		 *  두 수는 같다
		 */
		
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int a = input.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int b = input.nextInt();
		
		
		
		if (a==b) {
			System.out.print("두 수는 같습니다.");
		} else if (a>b) {
			System.out.printf("최댓값: %d%n최솟값: %d%n", a, b);
		} else {
			System.out.printf("최댓값: %d%n최솟값: %d%n", b, a);
		}
		
		input.close();
		

		
		
	}
}
