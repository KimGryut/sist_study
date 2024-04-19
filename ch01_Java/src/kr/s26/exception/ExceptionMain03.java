package kr.s26.exception;

public class ExceptionMain03 {
	public static void main(String[] args) {
		/*
		// 예외 처리
		try {
			System.out.println(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) { // arg 배열에 데이터 입력하지 않았을 시
			System.out.println("입력한 데이터가 없습니다.");
		} */

		
		int var = 50;
		
		// 예외 처리 
		// 다중 catch문 : 예외가 발생하면 예외 객체가 전달되는 catch 블럭으로 이동해서 수행문 수행
		try {
			int data = Integer.parseInt(args[0]);
			System.out.println(var/data);
			// 다중 캐치 주의사항
			// Exception과 하위 예외 클래스를 동시에 명시할 때 
			// 하위 예외 클래스를 먼저 명시하고 가장 뒤에 Exception 을 명시해야 동작상 문제가 발생하지 않음
		} catch (ArrayIndexOutOfBoundsException e) { // arg 배열에 데이터 입력하지 않았을 시
			System.out.println("입력한 데이터가 없습니다.");
		} catch (NumberFormatException e) { // arg 배열 데이터에 숫자가 아닌 것을 입력했을 시
			System.out.println("숫자가 아닙니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (Exception e) { // 알고 있는 예외(하위 예외 클래스)는 위에다 쓰고 Exception은 맨마지막에 포지션
			System.out.println("나머지 예외는 이곳으로");
		} 

		System.out.println("프로그램 종료");
	}
}
