package kr.s08.object.method;

public class OverloadingMain02 {

	public void getLength(float n) {
		String s = String.valueOf(n);
		getLength(s);
	}
	public void getLength(int n) {
		String s = String.valueOf(n); // 입력한 숫자를 문자로 바꾸기
		getLength(s);
	}

	public void getLength(String s) {
		System.out.println(s + "의 길이: " + s.length());
	}
	
	public static void main(String[] args) {
		OverloadingMain02 om = new OverloadingMain02();
		om.getLength("Hello");
		om.getLength(312312);
		om.getLength(3.14f); // 3.14의 문자로 변경
	}
	
	
}
