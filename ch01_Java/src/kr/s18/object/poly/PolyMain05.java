package kr.s18.object.poly;

// 부모 클래스
class Parent3 {
	// Object의 toString() 재정의
	@Override
	public String toString() {
		return "Parent3 클래스";
	}
}

// 자식 클래스
class Child3 extends Parent3 {
	@Override
	public String toString() {
		return "Child3 클래스";
	}
}
public class PolyMain05 {
	public static void main(String[] args) {
		Parent3 p = new Parent3();
		
		// Child3 ch = (Child3)p; // 컴파일 오류는 뜨지 않지만, 실행하면 오류가 남 
		// ch.toString();
		// 자식에서 부모가 된 다음 다시 자식이 되는 건 가능하지만,
		// 처음부터 부모였던 게 자식이 될 수는 없다
		
		// 위와 같은 실수를 없애기 위해 필요한 작업 -> (좌측)객체가 (우측)타입을 쓸 수 있는지 검증해주는 역할
		// 객체            타입
		if(p instanceof Child3) { // 사용할 수 있는 경우
			Child3 ch2 = (Child3)p;
			System.out.println(ch2);
			System.out.println("-------------");
		} else { // 사용할 수 없는 경우
			System.out.println(p);
			System.out.println("++++++++++++++");
		}
		
		// instanceof 연산자는 상속관계일 때 사용
		// 상속관계가 아닐 때 쓰면 오류가 남 
	}
}
