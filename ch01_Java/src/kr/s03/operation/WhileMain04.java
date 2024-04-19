package kr.s03.operation;

public class WhileMain04 {
	public static void main(String[] args) {
		/*
		 *  실습
		 *  
		 *  입력 받은 정수값부터 0까지 출력하는 프로그램
		 *  while  사용
		 *  0보다 작은 수를 입력하면 0보다 큰 수 입력하라고 나옴
		 *  
		 *  출력
		 *  정수 입력 : 3
		 *  3
		 *  2
		 *  1
		 * 
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = input.nextInt();
		
		if (num<=0) {
			System.out.println("0보다 큰 수를 입력하세요.");
			System.exit(0);
		}
		
		
		while(num>=0) {
			System.out.println(num);
			num--;
		}
		
		
		/* 이렇게 해도 무방
		if(num>0) {
			while(num>=0) {
				System.out.println(num);
				num--;
			}
		} else {
			System.out.println("0보다 큰 수를 입력하세요.");
		}
		*/
		
		input.close();
		
	}
}
