package kr.s01.basic;

public class VariableMain02 {
	public static void main(String[] args) {
		/*
		 * <실습>
		 * 정수를 담을 수 있는 변수를 3개 지정한다.
		 * 변수명은 각각 a b c라고 지정하고 원하는 정수로 초기화한다
		 * a+b 연산 후 출력할 때
		 * 
		 * 예시.
		 * 결과 : 50 < 형식으로 출력
		 * 
		 * c에 저장된 데이터를 80으로 변경 후 출력
		 * 
		 */
		
		int a = 10, b = 20, c = 30;
		
		
		System.out.println("결과 : " + (a+b));
		
		c = 80;
		
		System.out.println("C : " + c);
		
	}
}
