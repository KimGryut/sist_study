package kr.s03.operation;

public class SwitchMain01 {
	public static void main (String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
				
		/* switch(5) { // 이렇게 명시하면 int로 인식됨
		} */
		
		System.out.print("정수형 숫자 입력 : ");
		int a = input.nextInt();
		// switch 인자값은 long 제외한 정수형(byte, short, int) -> 실질적 전부 int
		// char, 문자열 사용 가능
		
		switch(a) {
		
		case 1:
			System.out.println("1.입력");
			break; // 브레이크 하지 않을 시 아래 케이스도 전부 출력하게 됨
		case 2:
			System.out.println("2.입력");
			break;
		case 3:
			System.out.println("3.입력");
			break;
		default : // 만약 케이스로 모든 경우를 썼다면 디폴트 쓰지 않아도 괜찮음
			System.out.println("1,2,3이 아닌 숫자 입력");
			break;
		
		}
		
		input.close();
	}
}
