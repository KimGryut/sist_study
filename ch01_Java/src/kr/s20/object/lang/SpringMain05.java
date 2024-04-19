package kr.s20.object.lang;

/*
 *  [실습]
 *  아래 문자열의 대문자는 소문자로, 소문자는 대문자로 변경
 *  
 */
public class SpringMain05 {
	public static void main(String[] args) {
		/*
		String str = "abcMDye-4W?EWzz";
		String result = ""; // 결과 저장할 곳
		char[] array = str.toCharArray(); // 아스키 코드 변환 위한 char 배열
		String[] array2 = str.split(""); // 대문자, 소문자 변경 위한 String 배열
		
		for (int i=0; i<array.length; i++) {
			int asc = array[i]; // char -> 아스키 코드
			if (asc>=65 && asc<=90) { // 아스키 코드 대문자 해당
				result += array2[i].toLowerCase(); // 소문자로 변경
			} else if (asc>=97&&asc<=122) { // 아스키 코드 소문자 해당
				result += array2[i].toUpperCase(); // 대문자로 변경
			} else {
				result += array2[i]; // 그 외 것은 그대로
			}					
		}
		
		System.out.println(result);
		*/
		
		String str = "abcMDye-4W?EWzz";
		String result = "";
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i); // 인덱스 i의 문자를 char로 변환
			
			if (c>=65 && c<90) {
				result += String.valueOf(c).toLowerCase(); // String.valueOf() char->String
			} else if (c>=97&&c<=122) {
				result += String.valueOf(c).toUpperCase();
			} else {
				result += c;
			}
		}
		
		System.out.println(result);
		
		System.out.println("------------------------------");
		
		// Wrapper 이용
		String result2 = "";
		
		for (char c : str.toCharArray()) { // String이었던 걸 한 글자씩 char 배열로 만들기
			if(Character.isUpperCase(c) ) { // 대문자인 경우 true 반환
				result2 += Character.toLowerCase(c);
			} else if (Character.isLowerCase(c)) {
				result2 += Character.toUpperCase(c);
			} else {
				result2 += c;
			}
		}
		
		System.out.println(result2);
		
		System.out.println("-------------------------");
		
		// 아스키코드 심화
		String result3 = "";
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c>=65 && c<=90) {
				result3 += (char)(c+32); 
			} else if (c>=97 && c<122) {
				result3 += (char)(c-32);
			} else {
				result3 += c;
			}
		}
		
		System.out.println(result3);
				
	}
}
