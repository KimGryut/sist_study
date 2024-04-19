package kr.s15.object.thistest;

public class Animal {
	/*
	 * [실습]
	 * Animal
	 * 멤버 변수 : 이름(name), 나이(age), 비행여부(fly) - private
	 * 멤버 메서드 : public set/get 메서드
	 * 생성자 : 인자가 있는 생성자, 인자가 없는 생성자
	 */
	
	
	// 내 답안
	/*
	private String name;
	private int age;
	private boolean fly;
	
	public Animal() {}
	
	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}
	
	public void set(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean getFly() {
		return fly;
	}
	*/
	
	// 모범 답안
	
	private String name; // 이름
	private int age; // 나이
	private boolean fly; // 비행여부
	
	// 인자가 없는 생성자
	public Animal() {}
	
	// 인자가 있는 생성자
	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}
	
	// 게터스 세터스 만드는 이유
	// 프라이빗 변수 만들고 퍼블릿으로 쓰려면 사용할 수 있는 메서드가 필요함
	// 일일이 만들지 않아도 되는 자동 방법
	// 우클릭 -> 소스 -> 제너레이트 게터스 세터스
	// 만들고자 하는 것 체크 
	
	
	
	/*
	// 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isFly() {
		return fly;
	}
	
	public void setFly(boolean fly) {
		this.fly = fly;
	}
	*/
	
	
	
}

