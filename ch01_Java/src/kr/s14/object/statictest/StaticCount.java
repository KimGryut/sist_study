package kr.s14.object.statictest;

public class StaticCount {
	// 인스턴스 변수 : 객체가 생성될 때 객체에 포함되는 변수
	int c;
	
	// static(클래스) 변수 : 객체 생성과 무관, 객체에 포함되지 않음.
	// 호출하면 메모리(static 영역)에 올라감
	// 약간 공유의 개념을 가짐
	static int count;
	
	// 생성자
	public StaticCount() {
		c++;
		count++;
	}
}
