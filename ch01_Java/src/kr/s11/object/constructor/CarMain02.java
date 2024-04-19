package kr.s11.object.constructor;

// 같은 패키지에 동일한 클래스 쓰려고 하면 충돌
class Car2{
	String color;
	String gearType;
	int door;
	
	// 생성자 오버로드 
	// 생성자를 여러개 정의하는데 인자의 타입과 개수, 배치 순서를 기준으로 
	// 생성자를 구분
	public Car2() {}
	
	public Car2(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}
public class CarMain02 {
	public static void main(String[] args) {
		// 객체 생성 및 선언
		Car2 c2 = new Car2("red", "auto", 4);
		
		System.out.println(c2.color + ", " + c2.gearType + ", " +c2.door);
		
		
		Car2 c1 = new Car2();
		c1.color = "골드";
		c1.gearType = "auto";
		c1.door = 6;
		System.out.println(c1.color + ", " + c1.gearType + ", " +c1.door);		
		
	}
}
