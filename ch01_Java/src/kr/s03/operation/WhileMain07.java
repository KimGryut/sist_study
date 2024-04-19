package kr.s03.operation;

public class WhileMain07 {
	public static void main(String[] args) {
		// 은행 프로그램
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		long balance = 0L; // 잔고
		long b;
		
		while(true) {
			System.out.println("");
			System.out.println("==============");
			System.out.println("1.예금 | 2.출금 | 3.잔고확인 | 4.종료");
			System.out.println("==============");
			System.out.print("수행할 작업의 번호를 입력하시오 : ");
			long a = input.nextLong();
			
			if (a==1) {
				System.out.print("예금할 금액을 입력하시오: ");
				b = input.nextLong();
				balance += b;
			} else if(a==2) {
				System.out.print("출금할 금액을 입력하시오: ");
				b = input.nextLong();
				balance -= b;
			} else if (a==3) {
				System.out.println("잔고 : " + balance);
			} else if (a==4) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("번호를 잘못 입력했습니다.");
			}
		}

		input.close();
		
	}
}
