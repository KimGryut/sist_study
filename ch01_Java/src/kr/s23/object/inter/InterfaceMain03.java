package kr.s23.object.inter;


// 인터페이스 : 형식만 있고 내용이 없음
// 팀 리더가 틀을 정의
// 표준화
interface CookieMold {
	// 추상 메서드
	public abstract void makeStar();
	public abstract void makeCircle();
	public abstract void makeDiamond();
}

class Cookie implements CookieMold {
	// 인터페이스가 형식을 제공하면 클래스에서 제공된 형식을 이용해 내용을 채운다
	// 추상 메서드 구현
	@Override
	public void makeStar() {
		System.out.println("별 모양 쿠키를 구웠습니다.");
	}
	
	@Override
	public void makeCircle() {
		System.out.println("원 모양 쿠키를 구웠습니다.");
	}
	
	@Override
	public void makeDiamond() {
		System.out.println("다이아몬드 모양 쿠키를 구웠습니다.");
	}
	
}

public class InterfaceMain03 {
	public static void main(String[] args) {
		Cookie cookie = new Cookie();
		cookie.makeCircle();
		cookie.makeDiamond();
		cookie.makeStar();
	}
}
