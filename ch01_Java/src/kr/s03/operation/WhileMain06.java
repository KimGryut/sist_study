package kr.s03.operation;

public class WhileMain06 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int a, total = 0;
		
		System.out.println("---0 입력 전까지 입력받은 정수로 합 구하기---");
		
		while(true) { // 무한 루프 형태
			System.out.print("누적할 정수 데이터 입력: ");
			a = input.nextInt();
			if (a==0) {
				break;
			} else {
				total += a;
			}
		} 
		
		System.out.println("누적 : " + total);
		
		
		
		input.close();
	}
}
