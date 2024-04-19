package kr.s17.object.overriding;

// 부모 클래스
class GrandParent {
	public String getCar() {
		return "구형 자동차";
	}
}

class Father extends GrandParent {
	// Method Overriding (메서드 재정의)
	// 상속 관계일 때, 자식 클래스에 메서드 재정의를 하면
	// 부모 클래스의 메서드가 호출되는 게 아니라 자식 클래스의 메서드가 호출됨
	// 틀은 그대로 유지하고 내용만 변경해서 재정의
	
	
	@Override // 재정의가 됐는지 안 됐는지 검증 가능
	public String getCar() { // 문법 오류 -> 밑줄 그임
		return "신형 자동차";
	}
}

class Uncle extends GrandParent {
	
}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father f = new Father();
		System.out.println("아버지는 " + f.getCar() + "를 좋아해요.");
		
		Uncle u = new Uncle();
		System.out.println("삼촌은 " + u.getCar() + "를 좋아해요.");
	}
}
