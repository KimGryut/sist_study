package kr.s03.operation;

public class SwitchMain04 {
	// main 단축키 : 탭 후 main 쓰고 컨트롤 스페이스바 -> 자동완성됨
	public static void main(String[] args) {
		
		
		/*
		 * 실습
		 * 
		 * 두 개의 정수와 한 개의 연산자를 입력한 후 연산 결과 보여주는 프로그램
		 * switch 사용
		 * 
		 * 첫번째 정수 : 10
		 * 연산자 : +
		 * 두번째 정수 : 20
		 * 
		 * 10 + 20 = 30
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int result = 0;
		
		System.out.print("첫 번째 수 : ");
		int first = input.nextInt();
		System.out.print("연산자 : ");
		String operator = input.next(); // +, -, *, /, %
		System.out.print("두 번째 수: ");
		int second = input.nextInt();
		
		
		// 따로 if 만들어서 미리 0으로 못 나누게 만들기
		/*
		// 0으로 나눌 수 없기 때문에, 나누는 경우 두 번째 받는 숫자 !=0
		if ((operator.equals("*") || operator.equals("%")) && second==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			System.exit(0);
		}
		
		switch(operator) {
		case "+" :
			result = first + second; break;
		case "-" :
			result = first - second; break;
		case "*" :
			result = first * second; break;
		case "/" :
			result = first / second; break;
		case "%" :
			result = first % second; break;
		default :
			System.out.print("연산자를 잘못 입력하셨습니다.");
			System.exit(0);
		}
		*/
		
		
		// 스위치 안에 if 넣어서 0으로 못 나누게 하기
		switch(operator) {
		case "+" :
			result = first + second; break;
		case "-" :
			result = first - second; break;
		case "*" :
			result = first * second; break;
		case "/" :
			if (second != 0) { // 0으로 나눌 수 없기 때문에, 두 번째 받는 숫자 !=0
				result = first / second; break;
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
				System.exit(0);
			}
		case "%" :
			if (second != 0) { // 0으로 나눌 수 없기 때문에, 두 번째 받는 숫자 !=0
				result = first % second; break;
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
				System.exit(0);
			}
		default :
			System.out.print("연산자를 잘못 입력하셨습니다.");
			System.exit(0);
		}
		
		
		System.out.println(); // 단순 줄바꿈 효과
		System.out.printf("%d %s %d = %d ", first, operator, second, result);
		
		input.close();
		
		
	}
}
