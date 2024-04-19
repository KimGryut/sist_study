package kr.s03.operation;

public class IfMain08 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int result = 0;
		
		System.out.print("첫 번째 수 : ");
		int first = input.nextInt();
		System.out.print("연산자 : ");
		String operator = input.next(); // +, -, *, /, %
		System.out.print("두 번째 수: ");
		int second = input.nextInt();
		
		if(operator.equals("+")) { // 문자열 비교할 땐 함수 이용해야 함 .equals("")
			result = first + second;
		} else if(operator.equals("-")) {
			result = first - second;
		} else if(operator.equals("*")) {
			result = first * second;
		} 
		
		
		else if(operator.equals("/")) {
			if (second !=0) {
				result = first / second;
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
				// 그 즉시 프로그램 종료시키기
				System.exit(0); // 밑에 있는 코드 실행x
			}
		} else if(operator.equals("%")) {
			if (second !=0) {
				result = first % second;
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
				// 그 즉시 프로그램 종료시키기
				System.exit(0); // 밑에 있는 코드 실행x
			}
		} else {
			System.out.println("잘못된 연산자 입력");
			// 그 즉시 프로그램 종료시키기
			System.exit(0); // 밑에 있는 코드 실행x
		}
		
		System.out.println(); // 단순 줄바꿈 효과
		System.out.printf("%d %s %d = %d ", first, operator, second, result);
		input.close();
		
	}
}
