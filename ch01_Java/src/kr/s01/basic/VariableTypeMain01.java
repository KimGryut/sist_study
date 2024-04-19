package kr.s01.basic;

public class VariableTypeMain01 {
	public static void main(String[] args) {

		System.out.println("===논리형===");
		// 논리형 (true, false)
		boolean b = true;
		System.out.println("b : " + b);
		
		
		System.out.println("===문자형===");
		// 문자형, 크기 : 2byte(16bit), 표현범위 : 0 ~ 65,535
		// 다국어 처리를 위한 유니코드(unicode)방식 사용
		char c1 = 'A'; // 내부적으로 아스키코드값 65가 2byte로 변수 c1에 담김
		System.out.println("c1 : " + c1);
		
		char c2 = 65; // A에 해당하는 아스키코드값
		System.out.println("c2 : " + c2); //아스키코드값으로 문자형 지정해도 무방
		
		char c3 = '\u0041'; // A를 의미하는 유니코드(16진수)
		System.out.println("c3 : " + c3);
		
		char c4 = '자'; 
		System.out.println("c4 : " + c4);
		
		char c5 = '\uc790'; // 자를 의미하는 유니코드
		System.out.println("c5 : " + c5);
		
		
		System.out.println("===정수형===");
		// byte, 크기 : 1 byte, 표현범위 : -128 ~ 127 
		// 표현범위가 좁아서 나중에 입출력할 때나 쓰임 (연산에서는 거의 안 쓰임)
		byte b1 = 127;
		System.out.println("b1 : " + b1);
		// short, 크기 : 2byte, 표현범위 : -32,768 ~ 32,767
		// 표현범위가 바이트보단 넓지만 마찬가지로 좁음. (게다가 다른 활용방법도 거의 없어서 빈도수가 낮음)
		short s1 = 32767;
		System.out.println("s1 : " + s1);
		// int, 크기 : 4Byte, 표현범위 : -2,147,483,648 ~ 2,147,483,647
		int in = 2147483647;
		System.out.println("in : " + in);
		//long, 크기 : 8Byte
		long lg = 1234L; // L은 long형 데이터를 의미 // 소문자로 써도 무방하나 1과 헷갈리므로 권장x
		System.out.println("lg : " + lg);
		
		
		System.out.println("===실수형===");
		// float, 크기 : 4byte
		float f1 = 9.1f; // 실수형의 기본은 더블이기 때문에 플롯임을 써야 함
		System.out.println("f1 : " + f1);
		// double, 크기 : 8Byte
		double du = 9.8;
		System.out.println("du : " + du);	
		
		System.out.println("===실수형===");
		// 문자열 표시(기본자료형이 아니고, 참조자료형)
		String str = "Hello World!!"; // String의 S는 무조건 대문자
		System.out.println("str : " + str);
		
		// 기본 자료형들의 이름과 크기는 외우기 (표현범위는 안 외워두고 있어도 됨)
		// 불리언은 크기가 중요한 건 아님
		
		
		
		
	
		
	}
}
