package kr.s15.object.thistest;

class ThisTest {
	// 은닉화
	private int a; // 멤버 변수
	// 캡슐화
	public void setA(int a) { // 지역 변수
		this.a = a; 
		// 이 블럭 안에선 지역 변수가 우선이기 때문에 다 지역 변수 a로 인식
		// 따라서 this.를 붙여줘야 구분하여 멤버 변수로 인식시킬 수 있음
	}
	public int getA() {
		return a;
	}
}

public class ThisMain02 {
	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		tt.setA(10);
		System.out.println(tt.getA());
		
		 
	}
}
