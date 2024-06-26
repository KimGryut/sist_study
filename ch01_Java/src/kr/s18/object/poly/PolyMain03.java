package kr.s18.object.poly;
// 부모 클래스
class Parent2 {
	public void make() {
		System.out.println("부모 클래스의 make");
	}
}

// 자식 클래스
class Child2 extends Parent2 {
	@Override // 메서드 재정의
	public void make() {
		System.out.println("자식 클래스의 make");
	}
}


public class PolyMain03 {
	/*
	 * 다형성(Polymorphism)
	 * 객체 지향 개념에서 다형성이란 '여러 가지 형태를 가질 수 있는 능력'을
	 * 의미하며, 자바에서는 한 타입의 참조 변수로 여러 타입의 객체를 참조할 수 있도록
	 * 함으로써 다형성을 프로그램적으로 구현.
	 * 부모 클래스 타입의 참조 변수로 자식 클래스의 인스턴스를 참조할 수 있도록 하였음.
	 * 
	 */
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make();
		
		Parent2 p = ch; // 자식 클래스 타입 -> 부모 클래스 타입 형변환
						// 업 캐스팅, 자동적으로 형변환
		// 재정의된 메서드가 호출됨
		p.make();
		
	}
}
