package kr.s03.operation;

public class DoWhileMain {
	public static void main(String[] args) {
				
		int su = 0;
		String str = "Hello World!";
		
		// 선 처리, 후 비교
		// 한 번 실행한 후!
		do {
			System.out.println(str);
		} while (su++ < 5);
		System.out.println("--------------");
		// -> 6번 실행
		
		
		int su2 = 0;
		while (su2++ <5) {
			System.out.println(str);
		}
		// -> 5번 실행
	}
}
