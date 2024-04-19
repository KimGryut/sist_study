package kr.s03.operation;

public class CoffeeMain02 {
	public static void main(String[] args) {
		/*
		 * 실습
		 * 동전을 넣고 커피를 주문하면 커피를 판매하는 자판기 프로그램
		 * 자판기는 동전(1000), 커피(10), 크림(10), 설탕(10) 보유 중이다.
		 * 커피를 주문할 때마다 동전-거스름돈, 커피5, 프림3, 설탕1씩 차감된다.
		 * 0이 되면 판매를 중단한다.
		 * 
		 * 종료 누르거나 0이 되지 않는 이상 계속 주문할 수 있다.
		 * 
		 * 입력 및 출력 예시
		 * 동전을 넣으세요 (커피값 : 400) : 500
		 * 거스름돈 : 100
		 * 맛 좋은 커피가 준비되었습니다.
		 *  
		 * or
		 * 
		 * 동전을 넣으세요 (커피값 : 400) : 300
		 * (고객이 투입한 동전이 커피값보다 작으면)투입한 동전이 부족합니다.
		 * 
		 * or
		 * 
		 * 동전을 넣으세요 (커피값 : 400) : 2000 (-> 1600 거스름돈)
		 * 거스름돈이 부족합니다.
		 * 
		 * 동전을 넣으세요 (커피값 : 400) : 500
		 * (커피가 부족하면) 커피가 부족합니다.
		 * .
		 * .
		 * . 이하 동일
		 * 
		 * ====현재 자판기 정보====
		 * 동전 :
		 * 커피 :
		 * 크림 :
		 * 설탕 :
		 * =================
		 * 
		 *
		 */
		
		// 선생님 답안
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// 커피 가격
		int price = 400;
		
		// 커피 한 잔에 들어갈 양
		int content_coffee = 5;
		int content_cream = 3;
		int content_sugar = 1;
		
		// 커피에 들어갈 재료의 현재 보유량
		int coffee = 10;
		int cream = 10;
		int sugar = 10;
				
		// 투입한 금액 누적
		int amount = 0;
		// 자판기 보유 동전
		int coin = 1000;
		
		
		
		
		while(true) {
			System.out.print("1. 커피 한 잔 주문  | 2. 종료 \n무엇을 하시겠습니까? : ");
			int num = input.nextInt();
			if (num == 1) { // 커피 주문
				System.out.print("동전을 넣으세요.(커피값 " + price + "원)" );
				int payment = input.nextInt();
				// 거스름돈 계산
				int change = payment - price;
				// 커피 주문 가능한지 조건 체크
				
				if (coffee < content_coffee) {
					System.out.println("커피가 부족합니다.");
					continue;
				}
				
				if (cream < content_cream) {
					System.out.println("크림이 부족합니다.");
					continue;
				}
				
				if (sugar < content_sugar) {
					System.out.println("설탕이 부족합니다.");
					continue;
				}
				if (payment < price) {
					System.out.println("투입한 동전 부족!");
					continue;
				}
				
				if (coin < change) {
				    System.out.println("거스름돈 부족");
				    continue;
				}	
				                    
				
				// 커피 구매가 가능하기 때문에 연산
				coffee -= content_coffee; // 커피 차감
				cream -= content_cream; // 크림 차감
				sugar -= content_sugar; // 설탕 차감
				coin -= change; // 거스름돈 차감
				amount += payment; // 투입한 금액 누적 -> 매출 계산시
				
				System.out.printf("거스름돈 : %d원%n", change);
				System.out.println("맛 좋은 커피가 준비되었습니다.");
				
				System.out.println("===현재 자판기 정보===");
				System.out.printf("커피: %d%n", coffee);
				System.out.printf("크림: %d%n", cream);
				System.out.printf("설탕: %d%n", sugar);
				System.out.printf("보유 동전: %d원%n", coin);
				System.out.printf("투입 금액: %d원%n", amount);
				System.out.println("=================");
						
				
			} else if (num == 2) { // 주문 종료
				System.out.println("커피 주문을 종료합니다.");
				break;				
			} else { // 번호 잘못 입력
				System.out.println("번호를 잘못 입력했습니다.\n");
			}
		}
		
		input.close();
	}
}
