package kr.s20.object.lang;

public class SpringMain02 {
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
				//  012345678910, 길이 = 11
		int index = s1.indexOf('n'); 
		System.out.println("맨 처음 문자 n의 위치 : " + index);
		
		index = s1.indexOf("Sun"); // 문자열을 넣었을 경우 문자열의 시작 위치 알려줌
		System.out.println("문자열 Sun의 시작 위치 : "  + index);
		
		index = s1.lastIndexOf('n'); 
		System.out.println("맨 마지막 문자 n의 위치 : " + index);
		
		char c = s1.charAt(7); // 인덱스 번호로 문자 추출
		System.out.println("지정한 인덱스(7)의 문자 추출: " + c);
		
		index = s1.indexOf('S'); // 대문자 소문자 구분
		String str = s1.substring(index); // 인덱스 위치부터 끝까지 잘라내기 (문자열 추출)
		System.out.println("대문자 S부터 끝까지 잘라내기: " + str);
		
		str = s1.substring(index, index+3); // 구간 지정 후 문자열 추출
		System.out.println("대문자 S부터 +까지: " + str); // 공백까지 추출하는 게 맞지만, 공백은 없음
		
		int length = s1.length();
		System.out.println("문자열의 길이 : " + length);
		
		String[] array = s1.split(" "); // 구분자를 이용해서 문자열 잘라내기
		for (int i=0; i<array.length; i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
		
		// 만약 없는 문자의 인덱스를 묻는다면 -1을 반환
		
		
		
	}
}
