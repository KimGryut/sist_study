package kr.s02.operator;

public class OperatorMain01 {
	public static void main(String[] args) {
		System.out.println("===증감연산자===");
		// 증가연산자
		int i = 5;
		// 증가연산자를 변수 앞에 명시하면 변수값을 1 증가시킨 후
		// 증가된 값을 읽어옴
		System.out.println(++i);// (6)
		System.out.println("--------");
		
		// 증가연산자를 변수 뒤에 명시하면 출력한 후 1 증가시킴 (뒤늦게 메모리 공간에다가)
		// == 변수값을 우선 읽어온 후 값을 1 증가시킴
		System.out.println(i++); // (6)
		System.out.println(i); // (7) 따라서 후에 확인해보면 1이 증가되어 있음을 확인 가능
		
		
		// 감소연산자
		int j = 10;
		// 증가연산자와 동일 (감소)
		System.out.println(--j); // (9)
		// 그 외의 내용도 증가연산자와 동일
		System.out.println(j--); //(9)
		System.out.println(j); // (8)
		
		
		//
		
		
		
		
	}
}
