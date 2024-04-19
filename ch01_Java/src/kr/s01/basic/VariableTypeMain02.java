package kr.s01.basic;

public class VariableTypeMain02 {
	public static void main(String[] args) {
		// 확장 특수 출력 문자(escape sequence)
		char single = '\''; //가운데 있는 작은 따옴표는 출력이 되지 않는 특수 문자 따라서 일반 문자로 바꿔줘야 함 (그 역할을 역슬래시가 함)
		System.out.println(single);
			
		String str = "오늘은 \"월요일\"입니다."; // 큰 따옴표도 마찬가지
		System.out.println(str);
		
		String str2 = "오늘은 '서울'에 비가 와요."; // 큰 따옴표를 썼을 땐 작은 따옴표를 안에 쓰는 건 문제가 되지 않음 (역슬래시 필요x)
		System.out.println(str2);
		
		String str3 = "C:\\javaWork\\workspace"; // 역슬래시도 출력하고 싶다면 앞에 역슬래시 붙여야 함
		System.out.println(str3);
		
		String str4 = "오늘은 월요일\n내일은 화요일"; // \n은 줄바꿈
		System.out.println(str4);
		
		String str5 = "이름\t나이\t취미"; // \t 일정간격 띄우기 (tab효과)
		System.out.println(str5);
		
	}
}
