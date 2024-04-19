package kr.s04.array;

public class ArrayMain06 {
	public static void main(String[] args) {
		// 문자열 배열 선언 및 생성
		// 기본값 null임을 확인
		String[] array = new String[3];
		
		array[0] = "Java";
		array[1] = "Oracle";
		array[2] = "JSP";
		
		// for문을 이용한 배열의 요소 출력
		for(int i=0; i<3; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("=============");
		
		// 확장 for문을 이용한 배열의 요소 출력
		for(String str: array) {
			System.out.println(str);
		}
		
	}
}
