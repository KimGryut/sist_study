package kr.s15.object.thistest;

public class LocalVariable {
	// 멤버 변수 : 클래스 블럭 내에서 정의된변수
	int b = 200;
	
	public void make() {
		// 지역 변수 : 메서드, 생성자, 제어문 블럭 내에서 생성된 변수
		// 해당 블럭이 종료되면 해당 변수는 소멸함
		int a = 100;
		
		System.out.println("지엽 변수 a: " + a);
		System.out.println("멤버 변수 b: " + b);
	}
	
	public void fun() {
		// a는 make() 메서드에서 선언한 지역 변수이기 때문에 다른 메서드에서 호출 불가능
		// System.out.println("지엽 변수 a: " + a); // 호출 불가능 (지역 변수)
		System.out.println("멤버 변수 b: " + b); // 호출 가능 (멤버 변수)
	}
	
	public static void main(String[] args) {
		// 제어문
		for(int i=1; i<=5; i++) { // {} < 제어문 블럭
			System.out.print(i + "\t");
		}
		
		System.out.println("\n------------------------------------");
		// System.out.println(i); 
		// 에러. i는 제어문 안에서만 사용 가능한 지역 변수
		// 따라서 제어문 블럭 밖에서는 호출 불가
		
		// 제어문이 끝났으나 변수를 사용하고 싶다면 제어문 전에 선언해야 함
		int a; // 제어문 시작 전에 먼저 선언
		for(a=1; a<=5; a++) {
			System.out.print(a + "\t");
		}
		System.out.println("\n------------------------------------");
		System.out.println(a); // 제어문 안에서 선언한 변수가 아니기 때문에 호출 가능 
		
		
		
	}
}
