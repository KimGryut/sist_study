package kr.s01.basic;

public class PrintMain03 {
	public static void main(String[] args) {
		
		// 문자 : 한 문자
		System.out.println('A');
		System.out.println('강');
		// 작은 따옴표 : 문자를 의미하는 특수 문자 ; A : 일반 문자
		// 특수 문자는 출력되지 않고, 일반 문자는 출력됨
	
		// 문자열 : 한 문자 이상의 문자들
		System.out.println("Z");
		System.out.println("city");
		System.out.println("한강");
		
		// 숫자 (정수)
		System.out.println(23);
		System.out.println("23"); // 문자열 -> 연산 불가
		
		// 숫자 (실수)
		System.out.println(3.14);
		System.out.println("3.14"); // 문자열 -> 연산 불가
				
		// 논리값(boolean 불린, 불리언)
		System.out.println(true); // 참값
		System.out.println(false); // 거짓값
		System.out.println("true"); //문자열 -> 논리값 체크 불가
	}
	
}




