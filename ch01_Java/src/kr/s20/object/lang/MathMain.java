package kr.s20.object.lang;

public class MathMain {
	public static void main(String[] args) {
		// 절대값 구하기
		int a = Math.abs(-10);
		System.out.println(a);
		
		// 소수 올림 -> 결과 : 더블 유지
		double b = Math.ceil(3.3);  // 괄호엔 더블
		System.out.println(b);
		
		// 내림 -> 결과 : 더블
		double c = Math.floor(3.7); // 괄호엔 더블
		System.out.println(c);
		
		// 반올림 -> 결과 : 인트
		int d = Math.round(3.7f);  // 괄호엔 플룻
		System.out.println(d);
		
		// 최대 최소
		int e = Math.max(3, 5);
		System.out.println("최댓값 : " + e);
		
		int f = Math.min(4, 7);
		System.out.println("최솟값 : " + f);
			
	}
}
