package kr.s25.object.inner;

class Inner7 {
	public void disp() {
		System.out.println("부모 클래스의 disp");
	}
}

public class AnonymousMain {
	public void make() {
		/*
		// 로컬 내부 클래스
		class Inner extends Inner7 {
			@Override
			public void disp() {
				System.out.println("내부 클래스의 disp");
			}
		}
		
		// 내부 클래스 객체 생성
		Inner i = new Inner();
		i.disp();
		*/ //-> 이걸 하나로 합쳐버림
		
		
		// 익명 내부 클래스
		// Inner7 클래스가 상속된 이름없는 클래스를 객체 생성 (부모 클래스 이름 빌리기)
		// 단, Object는 불편함
		Inner7 i = new Inner7() {
			@Override
			public void disp() {
				System.out.println("익명 내부 클래스의 disp");
			}
		}; // 세미콜론 잊지 말기
		i.disp(); // 메서드 호출
		
	}
	
	public static void main(String[] args) {
		AnonymousMain am = new AnonymousMain();
		am.make();
	}
}
