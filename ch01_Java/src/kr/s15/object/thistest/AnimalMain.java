package kr.s15.object.thistest;

public class AnimalMain {
	/*
	 * [실습]
	 * AnimalMain
	 * 인자가 있는 생성자를 이용해서 객체 생성
	 * 이름, 나이, 비행여부를 출력.
	 * 비행여부 true.false -> 가능/불가능
	 * 
	 * 인자가 없는 생성자를 이용해서 객체 생성
	 * 이름, 나이, 비행여부 설정
	 * 이름, 나이, 비행여부 출력. 비행여부 true.false -> 가능/불가능
	 */
	
	private static String printFly(boolean fly) {
		return fly ? "가능" : "불가능";// 삼합 연산자 사용
	}
	
	public static void main(String[] args) {
		
		// 인자가 있는 생성자를 이용해서 객체 생성
		Animal a1 = new Animal("기러기", 3, true);
		System.out.println("이름 : " + a1.getName());
		System.out.println("나이 : " + a1.getAge());
		// System.out.println("비행여부 : " + (a1.isFly() ? "가능" : "불가능")); // 삼합 연산자 사용
		System.out.println("비행여부 : " + printFly(a1.isFly()));
		
		System.out.println("---------------");
		
		// 인자가 없는 생성자를 이용해서 객체 생성
		Animal a2 = new Animal();
		a2.setName("강아지");
		a2.setAge(6);
		a2.setFly(false);
		System.out.println("이름 : " + a2.getName());
		System.out.println("나이 : " + a2.getAge());
		// System.out.println("비행여부 : " + (a2.isFly() ? "가능" : "불가능")); // 삼합 연산자 사용
		System.out.println("비행여부 : " + printFly(a2.isFly()));
		
		
		
		
		
		
		
		/*
		//인자가 있는 생성자를 이용해서 객체 생성
		Animal a1 = new Animal("강아지", 5, false);		
		
		// 출력		
		System.out.println("이름: " + a1.getName() + "\n나이: " + a1.getAge());
		if (a1.getFly() == false) {
			System.out.println("비행여부: 불가");
		} else {
			System.out.println("비행여부: 가능");
		}
		
		System.out.println("--------------------");
		
		// 인자가 없는 생성자를 이용해서 객체 생성
		Animal a2 = new Animal();
		// 이름, 나이, 비행여부 설정
		a2.set("비둘기", 3, true);
		
		// 출력
		System.out.println("이름: " + a2.getName() + "\n나이: " + a2.getAge());
		if (a2.getFly() == false) {
			System.out.println("비행여부: 불가");
		} else {
			System.out.println("비행여부: 가능");
		}
		*/
		
	}
}
