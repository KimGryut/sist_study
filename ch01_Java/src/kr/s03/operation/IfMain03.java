package kr.s03.operation;

public class IfMain03 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("정수 한 개 입력: ");
		int a = input.nextInt();
		
		// 다중 if문
		if(a>0) {
			System.out.print("a는 양수");
		} else if (a==0) {
			System.out.print("a는 0");
		} else {
			System.out.print("a는 음수");
		}
		
		input.close();
	}
}
