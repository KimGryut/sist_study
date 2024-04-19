package kr.s22.object.abs;

// 추상 클래스
// 미완성된 개념으로 단독으로 객체 생성이 불가능하고 일반적으로 자식 클래스에 상속되어 사용됨
abstract class A {
	private int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}

class B extends A {
	int b = 200;
}

public class AbstractMain01 {
	public static void main(String[] args) {
		// A ap = new A(); // 오류. 추상 클래스는 직접 객체 생성이 불가능. 오직 부모 클래스 역할 수행.
		B bp = new B();
		bp.setX(100);
		System.out.println(bp.getX()); // A의 것들 호출 가능
		System.out.println(bp.b); // 본인 것도 호출 가능
	}
}
