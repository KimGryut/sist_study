package kr.s16.object.extention;

// 부모 클래스
class Parent{
	int a = 100;
}
// 자식 클래스
class Child extends Parent{ // 상속은 자식 쪽에 부모를 명시
	int b = 200;
}



public class ExtentionMain01 {
	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a); // 부모한테 있던 것도 쓸 수 있음 
		
	}
}
