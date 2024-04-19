package kr.s03.operation;

public class IfMain05 {
	public static void main(String[] args) {
		/*
		 * 실습
		 * 
		 * 정수 하나를 입력하여 짝수면 10을 더하고 홀수면 20을 더하여 결과값 출력
		 * 
		 * 정수 : 5
		 * 결과 : 25
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("정수를 하나 입력하시오: ");
		int a = input.nextInt();
		
		if (a%2 == 0) { // a가 짝수이면
			a += 10;
		} else {
			a += 20;
		}
		
		System.out.print("결과 : " + a);
		
		input.close();
		
	}
}
