package kr.s20.object.lang;

import java.util.Scanner;

public class SpringMain04 {
	/*
	 * 실습
	 * 입력 받은 문자열을 한 문자씩 읽어서 역순으로 표시
	 * 
	 * 입력 예시
	 * 문자열 : hello
	 * 출력예시
	 * olleh
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// 문자열 입력 받기
		System.out.print("문자열 : ");
		String str = input.nextLine();
		
		// 결과값 반환할 문자열
		String result = "";
		
		// 인덱스 끝부터 출력하도록 하기
		for (int i=(str.length()-1); i>=0; i--) {
			char c = str.charAt(i);
			result += c;
		}
		
		
		
		System.out.println(result);
		input.close();
	}
}
