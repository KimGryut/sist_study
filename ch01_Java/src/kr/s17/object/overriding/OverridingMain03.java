package kr.s17.object.overriding;

// 부모 클래스
class Mother2 {
	public String getLunch() {
		return "밥";
	}
}

// 자식 클래스
class Daugter2 extends Mother2 {
	// 메서드 오버라이딩
	@Override
	public String getLunch() {
		return "빵";
	}
	
	public String getRice() {
		return super.getLunch(); // 부모 클래스의 getLunch() 메서드 호출
		// super.메서드() 로 부모 영역의 메서드 호출
	}
}
public class OverridingMain03 {
	public static void main(String[] args) {
		Daugter2 d = new Daugter2();
		System.out.println("딸은 " + d.getLunch() + "을 먹습니다.");
		System.out.println("하지만 오늘은 왠지 " + d.getRice() + "을 먹고 싶습니다.");
	}
}
