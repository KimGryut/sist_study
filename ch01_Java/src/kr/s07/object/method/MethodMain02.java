package kr.s07.object.method;

public class MethodMain02 {
	/*
	 * [실습]
	 * 입력한 int형 정수값이 음수이면 -1, 0이면 0, 양수이면 1을 반환하는 메서드
	 * signOf 메서드
	 */
	
	
	// 메서드 생성
	public int signOf(int a) {
		if(a<0) {
			return -1;
		} else if (a==0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/*
	public int signOf(int a) {
		if(a<0) {
			return -1;
		} else if (a>0) {
			return 1;
		} // 0일 때 0 반환하기 -> 음수도 양수도 아닌 경우는 어차피 0
		// -> 기본값 0이기  때문에 이런 경우 코드 절약 가능
	}
	*/
	
	
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// 객체 생성
		MethodMain02 practice = new MethodMain02();
		
		// 정수값 입력 받기
		System.out.print("정수 : ");
		int num = input.nextInt();
		
		// 메서드 실행
		int result = practice.signOf(num);
		
		// 결과
		System.out.printf("입력한 정수: %d%n반환값: %d", num, result);
		
		input.close();
	}
}
