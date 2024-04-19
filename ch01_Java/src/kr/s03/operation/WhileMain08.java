package kr.s03.operation;

public class WhileMain08 {
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
		int quantity, payment, total , balance;
		
		while(true) {
			// 주문할 커피 수량
			System.out.print("아메리카노 한 잔은 4000원입니다.\n몇 잔 주문하시겠습니까? : ");
			quantity = input.nextInt();
			
			// 사용자가 지불한 금액
			System.out.print("얼마 지불하셨습니까? : ");
			payment = input.nextInt();

			// 총 지불해야 할 커피값
			total = price * quantity;
			
			// 거스름돈
			balance = payment -total;
			
			if (balance>0) { // 거스름돈이 0 이상이라면 정상 주문. while 빠져나옴
				System.out.println("거스름돈은 " + balance + "원입니다.");
				break;
			} else { // 아니라면 다시 주문
				System.out.println(-1*balance + "원이 부족합니다. \n다시 주문해주세요\n");
			}
		}
		
		input.close();
		
		/*
		//주문을 처음부터 하는 게 아니라, 부족한 금액을 추가로 더 지급하게 하는 프로그램
		// 부족한 금액이 없을 때까지 지불하게 한다.	  
		 
		java.util.Scanner input = new java.util.Scanner(System.in);

		int price = 4000;
		int quantity, payment, total , balance, plus;

		// 주문할 커피 수량
		System.out.print("아메리카노 한 잔은 4000원입니다.\n몇 잔 주문하시겠습니까? : ");
		quantity = input.nextInt();

		// 지불해야 하는 총 커피값
		total = price * quantity;

		// 사용자가 지불한 금액
		System.out.print("얼마 지불하셨습니까? : ");
		payment = input.nextInt();

		// 거스름돈
		balance = payment -total;

		while(balance<0) { // 총 커피값보다 사용자 지불 금액이 적을 시
			System.out.println("\n" + -1*balance + "원이 부족합니다.");

			// 추가로 금액을 지불하게 한다
			System.out.print("얼마를 더 지불하시겠습니까? : ");
			plus = input.nextInt(); 
			balance += plus; // 덜 지불한 금액에다가 추가 금액을 더함 
			// 그럼에도 부족하다면 해당 작업 반복
		}

		System.out.println("거스름돈은 " + balance + "원입니다.");

			input.close();
			*/
		
		
		
	}
}
