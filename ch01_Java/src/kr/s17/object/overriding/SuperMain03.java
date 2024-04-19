package kr.s17.object.overriding;

// 부모 클래스
class People2 {
	int a;
	public People2(int a) {
		this.a = a;
	}
}

// 자식 클래스
class Student2 extends People2 {
	// 생성자
	public Student2() {
		super(700);
	}
}
		
public class SuperMain03 {
	public static void main(String[] args) {
		Student2 s = new Student2();
		System.out.println(s.a);
	}
}
