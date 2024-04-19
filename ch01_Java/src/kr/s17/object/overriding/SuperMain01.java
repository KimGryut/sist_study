package kr.s17.object.overriding;

// 부모 클래스
class Parent {
	int a = 100;
	public void play() {
		System.out.println("Parent의 play 메서드");
	}
}

class Child extends Parent {
	int a = 200;
	
	public Child() {
		System.out.println(super.a);
		super.play();
		System.out.println("-------------");
	}
	
	
	@Override
	public void play() {
		System.out.println("Child의 play 메서드");
	}
	
	
}

public class SuperMain01 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.a);
		
		c.play();
		
		
		
	}
	
}
