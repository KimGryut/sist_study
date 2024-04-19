package kr.s20.object.lang;

public class WrapperMain01 {
	public static void main(String[] args) {
		
		/*
		// 예전 방식 (생성자 이용)
		boolean b = true; // 기본 자료형
		Boolean wrap_b = new Boolean(b); // 기본 자료형 데이터 -> 참조 자료형 데이터
		// 참조 자료형 데이터 -> 기본 자료형 데이터
		boolean b2 = wrap_b.booleanValue();
		System.out.println(b2);
		
		System.out.println("-----------------");
		*/
		
		// 최근 방식 (메서드 이용)
		char c = 'A'; // 기본 자료형
		Character wrap_c = c; // 기본 자료형 데이터 -> 참조 자료형 데이터
							  // auto boxing
		// 참조 자료형 데이터 -> 기본 자료형 데이터
		// auto unboxing
		System.out.println(wrap_c);
		
		
	}
}
