package kr.s25.object.inner;

public class StaticMain {
	// static 내부 클래스
	// static 내부 클래스를 포함한 클래스를 먼저 객체 생성하는 것이 아니라,
	// static 내부 클래스를 단독으로 객체 생성해서 사용
	public static class Inner {
		// 인스턴스 변수
		int iv = 100;
		
		// static 변수
		static int cv = 200;
		
		// static 메서드
		public static void make() {
			System.out.println("하하하");
		}
	}
	
	public static void main(String[] args) {
		// static 내부 클래스는 바로 객체 생성 가능 (외부 클래스 생성 필수x)
		Inner i = new Inner();
		
		// 인스턴스 변수 호출
		System.out.println(i.iv);
		
		// static 변수 호출
		// 객체.cv 로 하지 않고 클래스.cv로 생성해도 됨
		System.out.println(Inner.cv);
		
		// static 메서드 호출
		Inner.make();
		
		
		
	}
}
