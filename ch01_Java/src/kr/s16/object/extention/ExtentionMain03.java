package kr.s16.object.extention;

// 부모 클래스
class A {
	int x = 100;
	private int y = 200;
	
	public int getY() {
		return y;
	}
}

class B extends A {
	int z = 300;
}

public class ExtentionMain03 {
	public static void main(String[] args) {
		B bp = new B();
		System.out.println(bp.x);
		// System.out.println(bp.y); // 상속은 받음 은닉화돼서 바로 쓸 수 없을 뿐
		System.out.println(bp.getY()); // getY() 메서드로 사용 가능하게 만듦
		System.out.println(bp.z);
	}
	
}
