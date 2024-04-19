package kr.s15.object.thistest;

public class ThisMain03 {
	// 생성자
	public ThisMain03() {
		// 생성자 내부에서 또다른 생성자를 호출할 때 this()를 표시
		// 반복적인 코드를 제거하고 코드를 재사용하기 위해 또다른 생성자를 호출해서 동작시킴
		// this() 전에 다른 코드를 사용하면 오류 발생
		// System.out.println("====="); << 오류 발생
		this("여름");
		System.out.println("==========="); // 오류 발생하지 않음
	}
		
	public ThisMain03(String msg) {
		System.out.println(msg);
	}
	
	public ThisMain03(int a) { 
		// int -> String
		this(String.valueOf(a));
	}
	
	public static void main(String[] args) {
		ThisMain03 tm = new ThisMain03();
		ThisMain03 tm2= new ThisMain03("겨울");
		ThisMain03 tm3 = new ThisMain03(50000);

		System.out.println(tm);
		System.out.println(tm2);
		System.out.println(tm3);
	}
}
