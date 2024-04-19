package kr.s18.object.poly;

// 부모 클래스
class Parent{
	int a = 100;
}

// 자식 클래스
class Child extends Parent {
	int b = 200;
}

public class PolyMain01 {
	public static void main(String[] args) {
		Child ch = new Child(); // Child < 참조자료형
								// 상속관계에 있으면 자료형을 변경 가능
		System.out.println(ch.a);
		System.out.println(ch.b);
		
		Parent p = ch; // 자식 클래스 타입 -> 부모 클래스 타입 형변환 
						// 업 캐스팅, 자동적으로 형변환
		
		System.out.println(p.a); // 호출 가능
		
		// System.out.println(p.b); // 호출 불가능
		// 타입이 부모로 바뀌면 부모 영역에 있는 것들만 호출 가능해짐 (사용 가능한 범위가 줄어듦)
		
		Child ch2 = (Child)p; // 호출 범위가 줄어든 상태에서 다시 넓히기 위해선 명시적 형변환을 해줘야 함.
		// 부모 클래스 타입 -> 자식 클래스 타입 형변환
		// 다운 캐스팅, 명시적으로 형변환
		
		// 다시 모두 호출 가능
		System.out.println(ch2.a);
		System.out.println(ch2.b);
		
		
		
		
		
		
	}
}	
