package kr.s26.exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ExceptionMain06 {

	// 메서드에 throws 이하 명시하면 예외 처리 하지 않아도 .readLine()에서 오류 발생하지 않음
	// 메서드 내에 throws 예외 클래스를 명시하면 메서드 내에 try~catch 블럭을 생략하고
	// 예외가 발생하면 예외를 입시 보관하고 메서드를 호출하는 곳에
	// try~catch 블럭이 있을 경우 그곳으로 예외를 양도함
	public void printData() throws IOException, NumberFormatException {
		// IOException 은 readLine() 같은 걸 사용하기 위해 필수적으로 명시해야 함
		// NumberFormatException은 런타임 예외라서 여기서 명시하진 않아도 괜찮음
		// 입력 받을 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("단 입력> ");
		// BufferedReader로 입력 받으면 무조건 String으로 반환 -> Integer.parsrInt()로 int변환
		int dan = Integer.parseInt(br.readLine()); // 한 라인에 입력한 데이터를 반환
		System.out.println(dan + "단");
		System.out.println("----------");
		for (int i=1; i<=9; i++) {
			System.out.println(i + "*" + dan + "=" + (i*dan));
		}


	}

	public static void main(String[] args) {
		ExceptionMain06 em = new ExceptionMain06();
		try {
			em.printData();
		} catch (IOException e) {
			System.out.println("입력 시 오류 발생");
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}
	}
}
