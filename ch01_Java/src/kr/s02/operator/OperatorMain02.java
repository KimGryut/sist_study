package kr.s02.operator;

public class OperatorMain02 {
	public static void main(String[] args) {
		System.out.println("===산술연산자===");
		
		System.out.println(1 + 1);
		System.out.println(10 * 3);
		System.out.println(10 / 3); // 몫 구하기 (소수가 안 남음. 자료형을 맞춰야 하기 때문에)
		System.out.println(10 % 3); // 나머지 구하기
		
		System.out.println("-------------");
		
		System.out.println(10.0/3); // 3.3333333 이 만들어짐 (정수끼리의 계산이 아니기 때문)더블 / 인트 => 더블 자동 현변환
		System.out.println(2.4 * 4); // 더블 * 인트 -> 자동 더블 형변환
		
		
		
	}
}
