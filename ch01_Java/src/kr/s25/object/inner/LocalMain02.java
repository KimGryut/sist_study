package kr.s25.object.inner;

public class LocalMain02 {
	// 멤버 변수 : 클래스 내부
	int a = 100;
	
	// 멤버 메서드 
	public void innerTest() {
		int b = 500; // 지역 변수 : 메서드나 생성자 내부
		// 로컬 내부 클래스
		class Inner {
			public void getData() {
				// 멤버 변수 호출
				System.out.println("변경 전 : " + a);
				System.out.println("----------------");
				a = 200;
				System.out.println("변경 후 : " + a);
				System.out.println("----------------");
				
				// 지역 변수 호출
				System.out.println("지역 변수 호출 전 : " + b);
				System.out.println("----------------");
				// 로컬 내부 클래스가 포함된 메서드의 지역 변수를 호출할 때, 자동으로 상수화 진행
				// 따라서 데이터를 변경할 수 없음
				// b = 800; 
			}			
		}
		
		// 내부 클래스 객체 생성 < 반드시 필요한 작업
		Inner i = new Inner();
		i.getData();
	}
		
	public static void main(String[] args) {
		LocalMain02 m = new LocalMain02();
		m.innerTest();		
	}	
}
