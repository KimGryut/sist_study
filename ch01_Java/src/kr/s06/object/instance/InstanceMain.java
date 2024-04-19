package kr.s06.object.instance;

public class InstanceMain {
	// 클래스의 기본 구조
	// 멤버 필드(속성)
	int var1; // 멤버 변수
	String var2; // 멤버 변수
	
	// 생성자, 생략 가능하며 생략하면 컴파일시 자동 생성
	public InstanceMain() {} // 객체 생성시 호출
	
	// 멤버 매서드 (동작)
	//               함수 입구
	public int sum(int a, int b) {
		return a+b;
		// 함수 출구
	}
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		InstanceMain im = new InstanceMain();
		// 객체의 멤버 변수에 값을 할당
		im.var1 = 100;
		im.var2 = "서울";
		// 객체의 메버 변수 값 호출
		System.out.println(im.var1 + "," + im.var2);
		
		// 객체의 멤버 메서드 호출
		int result = im.sum(10, 20);
		System.out.println("result = " + result);
	}
	
	
}
