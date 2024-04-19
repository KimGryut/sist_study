package kr.s20.object.lang;

/*
 * 문자열 - 명시적으로 객체
 * String s = new String("어쩌구");
 * 
 * 문자열 - 암시적으로 객체
 * String s2 = "바다";
 * String s4 = "바다";
 * -> 내용이 같으면 따로 만들지 않고 같이 만들어서 공유함	
 */
public class SpringMain01 {
	public static void main(String[] args) {
		// 암시적으로 문자열 생성
		// 같은 문자열을 사용할 경우 객체를 공유 -> 같은 객체 취급 당함
		String str1 = "abc";
		String str2 = "abc";
		
		// 객체 비교
		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 객체");
		} else {
			System.out.println("str1과 str2는 다른 객체");
 		}
		
		// 문자열 비교
		if (str1.equals(str2)) {
			System.out.println("str1과 str2의 내용이 같다");
		} else {
			System.out.println("str1과 str2의 내용이 다르다.");
		}
		
		System.out.println("------------------------");
		
		// 명시적으로 문자열 생성
		String str3 = new String("Hello");
		String str4 = new String("Hello");

		// 객체 비교
		if (str3 == str4) {
			System.out.println("str1과 str2는 같은 객체");
		} else {
			System.out.println("str1과 str2는 다른 객체");
		}

		// 문자열 비교
		if (str3.equals(str4)) {
			System.out.println("str1과 str2의 내용이 같다");
		} else {
			System.out.println("str1과 str2의 내용이 다르다.");
		}
		
		System.out.println("------------------------");
		
		String str5 = "bus";
		String str6 = "BUS";
		
		// 대소문자 구분하지 않고 문자열 비교
		if (str5.equalsIgnoreCase(str6)) {
			System.out.println("str5와 str6의 내용이 대소문자 구분없이 같다.");
		} else {
			System.out.println("str5와 str6의 내용이 대소문자 구분없이 다르다.");
		}
		
	}
}
