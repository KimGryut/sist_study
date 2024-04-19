package kr.s28.iostream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 문자 스트림
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("당신의 이름: ");
			String name = br.readLine();
			System.out.println("당신의 이름은 " + name);
			
			System.out.print("당신의 나이: ");
			// String -> int
			int age = Integer.parseInt(br.readLine());
			System.out.println("당신의 나이는 "+ age);
			
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		} catch(IOException e) {
			System.out.println("입력 시 오류 발생");
		} finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
}
