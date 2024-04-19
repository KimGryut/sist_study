package kr.s01.basic;

public class VariableTypeMain04 {
	public static void main(String[] args) {
		System.out.println("===명시적 형변환(강제 변환)===");
		//더 작은 자료형으로 강등이 일어나는 형태, 정보의 손실이 발생할 수 있음
		byte b1 = 127;
		byte b2 = 127;
		byte result1 = (byte)(b1 + b2); // 자동으로 승격된 int값을 byte로 끌어내리는 것
		System.out.println("result1 : " + result1); // 결과값이 -2가 됨 = 정보의 왜곡
		
		short s1 = 32767;
		short s2 = 32767;
		short result2 = (short)(s1+s2); // 괄호 안에 있는 걸 캐스트 연산자라고 함 (바이트) (쇼트)
		System.out.println("result2 : " + result2); // 정보의 왜곡 발생
		
		float f1 = 3.14f;
		int in1 = 15;
		int result3 = (int)(f1 + in1); // float로 자동 승격된 걸 int로 강제 강등
		System.out.println("result3 : " + result3); // int로 표현할 수 있는 범주라 손실은 없고 소수만 사라짐
		
		long lg1 = 1234L;
		int in2 = 59;
		int result4 = (int)(lg1 + in2); //ㅣlong형으로 자동 승격된 걸 int로 강제 강등
		System.out.println("result4 : " + result4); // int로 표현할 수 있는 범주라 정보의 손실 발생하지 않음
	}
}
