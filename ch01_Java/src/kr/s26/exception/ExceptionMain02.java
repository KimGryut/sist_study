package kr.s26.exception;

public class ExceptionMain02 {
	public static void main(String[] args) {
		int[] array = {10, 20, 30};
		
		for(int i=0; i<=array.length; i++) {
			// 예외처리
			// 예외가 발생해도 정상 종료 될 수 있도록 프로그램적으로 처리하는 것
			try {
				// 예외가 발생할 가능성이 있는 코드 명시
				// 만약, 예외가 발생하면 예외가 발생한 코드의 실행을 멈추고.
				// catch 블럭으로 이동
				System.out.println("array[" + i + "] :" + array[i]);
			} catch(ArrayIndexOutOfBoundsException e) { // 예외 발생 시 실행 
														// 정상 종료를 도움
				System.out.println("없는 인덱스를 호출했습니다.");
			}
		}
		
		// 예외 처리가 없었다면 비정상 종료가 되어 이 문구가 나오지 않음
		// 예외 처리가 있어서 정상 종료
		System.out.println("프로그램이 끝났습니다.");
		
	}
}
