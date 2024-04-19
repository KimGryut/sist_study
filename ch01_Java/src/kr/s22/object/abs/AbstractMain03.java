package kr.s22.object.abs;

abstract class Animal {
	public void breathe() {
		System.out.println("숨을 쉬다");
	}
	// 추상 메서드
	public abstract void sound();
}

// 자식 클래스
class Dog extends Animal {
	@Override
	public void sound() { // 추상 메서드 구현
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	@Override
	public void sound() { // 추상 메서드 구현
		System.out.println("냥냥");
	}
}


public class AbstractMain03 {
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();
		
		d.sound();
		c.breathe();
		c.sound();
		
	}
}
