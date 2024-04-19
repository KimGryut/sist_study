package kr.s22.object.abs;

// 추상 클래스
abstract class A2 {
	private int x;
	public void setX(int x) {
		this.x = x;
	} 
	public int getX() {
		return x;
	}
	
	// 추상 메서드
	// 메서드 명과 접근 지정자는 존재하지만 중괄호가 없음
	// 메서드를 구현하지 않고 형식만 존재한단 뜻 (내용x)
	public abstract void make();
}

class B2 extends A2 { 
	// 부모 클래스의 추상 메서드를 구현해줘야만 오류가 안 남
	@Override
	public void make() {
		System.out.println("make");
	}
	
}
public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.make();
	}
}
