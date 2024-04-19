package kr.s23.object.inter;

// 인터페이스 -> 클래스를 돕기 위해서
// 형식만 있고 내용이 없음
// 그 형식을 클래스에 도입해서 내용을 넣음
interface A2 {
	// 추상 메서드
	public abstract void abc(); // 원형
	void def ();
}

class B2 implements A2 {
	// 인터페이스의 추상 메서드 구형
	@Override 
	public void abc() {
		System.out.println("abc 메서드");
	}
	
	public void def() {
		System.out.println("def 메서드");
	}
}

public class InterfaceMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.abc();
		bp.def();
	}
}
