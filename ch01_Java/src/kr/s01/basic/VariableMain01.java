package kr.s01.basic;

public class VariableMain01 {
	public static void main(String[] args) {
		// 변수(Variable)는 값을 저장할 수 있는 메모리의 공간

		// 변수 선언 
		int num;
		// 데이터 종류 / 변수 이름 
		
		// 변수의 초기화
		num = 8;
		
		// 변수의 값 출력
		System.out.println(num);
		
		System.out.println("============");
		
		// 변수 선언과 동시에 초기화
		int number = 20;
		System.out.println(number);
		
		System.out.println("============");
		
		// 데이터 변경 
		number = 100;
		System.out.println(number);
		
		// 주의사항
		// int number = 30;
		// 위의 것은 변수 선언문으로 동일한 변수 이름으로 생성하면 안 된다
		
		System.out.println("============");
		
		// 동일한 자료형을 사용하기 때문에 두번째 변수명 앞의 자료형은 생략함
		// int a = 10;
		// int b = 20;
		int a=10, b=20;
		
		// 정수끼리 연산
		int result = a+b;
		
		System.out.printf("결과 : %d%n", result);
		System.out.println("결과 : " + result);
		
		// 숫자 + 숫자 => 연산
		// 문자열 + 숫자 => 연결
		// 숫자 + 문자열 => 연결
		// 문자열 + 문자열 => 연결
		
		System.out.println("결과 : " + a + b); // 앞에서부터 작동되기 때문에 결과10 + 20이라 1020이 됨
		// for 위 문제점 해결
		System.out.println("결과 : " + (a + b));
		
		/*
		int no;
		System.out.println(no);
		
		변수를 선언하기만 하고 값을 넣어주지 않는다면 에러 발생 == 반드시 초기화시켜야 함
		*/
		
		
	}
}

