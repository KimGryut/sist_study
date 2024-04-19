package kr.s14.object.statictest;

public class StaticMain01 {
	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("c: " + sc1.c + ", count: " + StaticCount.count);
		// System.out.println("c: " + sc1.c + ", count: " + sc1.count);
		// 위처럼 호출해도 작동하지만, static 변수를 호출하는 방법으로 올바른 것이 아니라는 경고 메시지가 뜸
		
		StaticCount sc2 = new StaticCount();
		System.out.println("c: " + sc2.c + ", count: " + StaticCount.count);
		
		StaticCount sc3 = new StaticCount();
		System.out.println("c: " + sc3.c + ", count: " + StaticCount.count);
	}
}
