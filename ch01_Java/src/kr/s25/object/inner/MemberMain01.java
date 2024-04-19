package kr.s25.object.inner;

class Outer {
	// Outer의 멤버 변수
	int x = 100;
	
	// 내부클래스 (멤버 내부 클래스)
	// 종속 관계이기 때문에 Outer 객체 생성 후 해야 함
	class Inner {
		// Inner의 멤버 변후
		int y = 200;
	}
}

public class MemberMain01 {
	public static void main(String[] args) {
		Outer ot = new Outer();
		// Outer 내부 클래스인 Inner 클래스를 객체 생성
		Outer.Inner oi = ot.new Inner();
		
		// Outer의 멤버 변수 호출
		System.out.println(ot.x);
		System.out.println(oi.y);
		
	}
}
