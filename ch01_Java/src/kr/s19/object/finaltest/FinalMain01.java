package kr.s19.object.finaltest;

class A {
	// 멤버 필드
	final int NUM = 10; // 상수
	// 상수는 변경되지 않는 걸 원하기 때문에 final을 꼭 붙여줘야 함
	
	public static final int NUMBER = 20; // static이라 호출도 안 하고 쓸 수 있음
	
	
}

public class FinalMain01 {
	public static void main(String[] args) {
		A ap = new A();
		
		// 이미 만들어진 상수를 고칠 순 없음
		// 상수 => 변경 불가
		// ap.NUM = 20;
		
		// only 사용만 가능
		System.out.println(ap.NUM); // 객체명.상수
		
		// static 상수 호출
		System.out.println(A.NUMBER); // 클래스명.상수
		
		// 객체 생성과 무관하게 상수 지정
		// 메서드 내에서만 사용 가능 (main 내? 로 추정..)
		final int NO = 30;
		System.out.println(NO);
	}
}
