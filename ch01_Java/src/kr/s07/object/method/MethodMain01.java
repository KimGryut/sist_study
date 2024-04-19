package kr.s07.object.method;

public class MethodMain01 {
	
	// 반환하는 데이터가 있는 경우
	//		  메서드명     인자     인자
	public int add (int a, int b) {
		return a+b; // 반환하는 데이터
	} // return이 있으면 반환형 메서드
	
	
	// 반환하는 데이터가 없는 경우
	public void print(String str) { // void => 비어있다
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		MethodMain01 method = new MethodMain01();
		// 객체의 멤버 메서드 호출
		int result = method.add(5, 8);
		System.out.println("result = " + result);
		
		method.print("오늘은 월요일");		
		
	}
}
