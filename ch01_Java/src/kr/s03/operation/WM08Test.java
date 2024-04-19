package kr.s03.operation;

public class WM08Test {
	public static void main(String[] args) {
		/*
		 *  실습
		 *  
		 *  커피전문점에서 아메리카노가 4000원입니다.
		 *  마실 커피 수량을 정하고 돈을 지불하세요.
		 *  지불한 돈에서 발생한 거스름돈을 출력하고, 
		 *  커피의 총 비용보다 지불한 금액이 적어서 커피를 구매할 수 없는 경우
		 *  금액이 부족하다 알리시고 다시 지불할 수 있는 프로그램 작성
		 *  
		 *  구매 : 1
		 *  지불 금액 : 5000
		 *  거스름돈 1000원입니다 -> 반복문 끝
		 *  
		 *  지불 금액 : 3000
		 *  1000원이 부족합니다 -> 계속 반복
		 */
		
		
	  
		 
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int price = 4000;
		int quantity, payment, total , balance, plus;
		
		System.out.print("아메리카노 한 잔은 4000원입니다.\n몇 잔 주문하시겠습니까? : ");
		quantity = input.nextInt();

		total = price * quantity;
		
		System.out.print("얼마 지불하셨습니까? : ");
		payment = input.nextInt();
		
		balance = payment -total;
		
		while(balance<0) {
			System.out.println("\n" + -1*balance + "원이 부족합니다.");
			System.out.print("얼마를 더 지불하시겠습니까? : ");
			plus = input.nextInt();
			balance += plus;
		}
		
		System.out.println("거스름돈은 " + balance + "원입니다.");
		
			input.close();
		
			
			
		
	}
}
