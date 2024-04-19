package kr.s23.object.inter;

// 인터페이스
interface I {
	// 추상 메서드
	public abstract void play();	
}

class Pianist implements I {
	@Override
	public void play() {
		System.out.println("피아노 연주하다");
	}
}

class Cellist implements I {
	public void play() { 
		System.out.println("첼로를 연주하다");
	}
}

class Stage {
	public void autoPlay(I i) { // 공통분모 Object o < 대신 I(인터페이스) i 사용
		i.play();
	}
}

public class InterfaceMain04 {
	public static void main(String[] args) {
		Stage a = new Stage();
		a.autoPlay(new Pianist()); // pianist -> i
									// 클래스타입 -> 인터페이스타입 형변환
		a.autoPlay(new Cellist());
		
	}
}
