package kr.s01.basic;

public class VairableTypeMain03 {
	public static void main(String[] args) {
		System.out.println("===묵시적 형변환(자동 변환)===");
		// 더 큰 자료형으로 승격이 일어나는 형태, 정보의 손실이 전혀 없으며 자동 발생
		byte b1 = 127; // byte 표현 범위 : -128 ~ 127
		byte b2 = 127; 
		int result1 = b1 + b2; // byte 사용 시 표현 범위를 넘어서 오류 발생
		System.out.println("result1 : " + result1);
		
		short s1 = 32767; // short의 표현범위 : -32,768 ~ 32,767
		short s2 = 32767;
		int result2 = s1 + s2; // 위와 마찬가지
		System.out.println("result2 : " + result2);
		
		int in1 = 1234;
		long lg1 =5678L;
		long result3 = in1 + lg1; //in1이 long으로 자동 형변환된 것.
		System.out.println("result3 : " + result3);
		
		int in2 = 245;
		double du1 = 98.2;
		double result4 = in2 + du1; // int가 자동으로 double로 자동 형변환된 것.
		System.out.println("result4 : " + result4);
		
	}
}
