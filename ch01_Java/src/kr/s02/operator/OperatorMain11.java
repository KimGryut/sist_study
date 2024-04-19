package kr.s02.operator;

public class OperatorMain11 {
	public static void main(String[] args) {
		
		char ch = 'h';
		String str; // 대문자인지 판단한 결과를 저장할 문자열 변수 선언
		// str = ch>=65 && ch<90 ? "대문자" : "대문자x";
		str = ch>='A' && ch<'Z' ? "대문자" : "대문자x"; // 아스키코드 이용해도 좋고 실제 문자 이용해도 좋음
		
		System.out.println("ch = " + str);
		
		
	}
}
