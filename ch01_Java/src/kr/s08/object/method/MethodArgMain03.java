package kr.s08.object.method;

public class MethodArgMain03 {
	// Variable Arguments
	// 자료형이 일치할 때 전달하고자 하는 값의 개수를 다르게 지정할 수 있음
	// 전달되는 데이터는 내부적으로 배열로 인식됨
	
	public void argTest(int ... n) { // 여러 개가 되면 배열이 됨
		for (int i=0; i<n.length; i++) {
			System.out.println("n[" + i + "]: " + n[i]);
			System.out.println("---------");
		}
	}
	
	public static void main(String[] args) {
		MethodArgMain03 ma = new MethodArgMain03();
		ma.argTest();
		ma.argTest(100); 
		ma.argTest(100, 200, 300);
	}
	
	
	
	
	
	/*
	public void argTest(int a, double b) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		MethodArgMain03 ma = new MethodArgMain03();
		ma.argTest(100, 2.6);
	}
	*/
	
	
	
}
