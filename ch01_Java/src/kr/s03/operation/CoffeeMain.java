package kr.s03.operation;

public class CoffeeMain {
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
		
		// 거스름돈
		int balance;
		
		// 추가 금액
		int plus;
		
		
		while(true) {
			System.out.print("1. 커피 한 잔 주문  | 2. 종료 \n무엇을 하시겠습니까? : ");
			int num = input.nextInt();
			if (num == 1) { // 커피 주문
				System.out.print("\n커피는 400원입니다. \n동전을 투입하시오. ");
				amount = input.nextInt();
				balance = amount - price; // 거스름돈 계산 
				
				while(balance<0) { // 총 커피값보다 사용자 지불 금액이 적을 시
					System.out.println("\n" + -1*balance + "원이 부족합니다.");
					
					// 추가로 금액을 지불하게 한다
					System.out.print("\n얼마를 더 지불하시겠습니까? : ");
					plus = input.nextInt(); 
					balance += plus; // 덜 지불한 금액에다가 추가 금액을 더함 
					// 그럼에도 부족하다면 해당 작업 반복
				}
					
					if (coin>=balance && coffee>= content_coffee && 
							cream >=content_cream && sugar >=content_sugar) { 
						System.out.println("\n맛 좋은 커피가 준비되었습니다! \n");
						System.out.println("거스름돈 : " + balance);
						coin -= balance;
						coffee -= content_coffee;
						cream -= content_cream;
						sugar -= content_sugar;
						System.out.println("\n=====자판기 재고 정보=====\n"
								+ "동전 : " + coin
								+ "\n커피 : " + coffee + "\n크림 : " + cream
								+"\n설탕 : " + sugar + "\n");
					} else if (coin<balance) {
						System.out.println("거스름돈이 부족합니다. 죄송합니다.");
						break;
					} else if (coffee < content_coffee) {
						System.out.println("커피가 부족합니다. 죄송합니다.");
						break;
					} else if (cream <content_cream) {
						System.out.println("크림이 부족합니다. 죄송합니다.");
						break;
					} else if (sugar <content_sugar) {
						System.out.println("설탕이 부족합니다. 죄송합니다.");
						break;
					}
				
				
			} else if (num == 2) { // 주문 종료
				System.out.println("커피 주문을 종료합니다.");
				break;				
			} else { // 번호 잘못 입력
				System.out.println("번호를 잘못 입력했습니다.\n");
			}
		}
		
		input.close();
		
		
		
		
		
		
		
		
		// 의문 : 커피와 거스름돈이 동시에 부족하다면 에러 메시지가 하나만 뜨는 것
		// 해결 
		/* 주문 거스름돈 아래 if문 전체 변경
		 * String error = ""; 오류 메시지 보여줄 문자열 변수 추가
		 * if (coin>=balance && coffee>= content_coffee && 
				cream >=content_cream && sugar >=content_sugar) { 
			System.out.println("\n맛 좋은 커피가 준비되었습니다! \n");
			System.out.println("거스름돈 : " + balance);
			coin -= balance;
			coffee -= content_coffee;
			cream -= content_cream;
			sugar -= content_sugar;
			System.out.println("\n=====자판기 재고 정보=====\n"
					+ "동전 : " + coin
					+ "\n커피 : " + coffee + "\n크림 : " + cream
					+"\n설탕 : " + sugar + "\n");
		} else {
			if (coin<balance) {
				error += "거스름돈이 부족합니다. 죄송합니다. \n";
			}
			
			if (coffee < content_coffee) {
				error += "커피가 부족합니다. 죄송합니다. \n";
			}
			
			if (cream <content_cream) {
				error += "크림이 부족합니다. 죄송합니다.";
			}
			if (sugar <content_sugar) {
				error += "설탕이 부족합니다. 죄송합니다.";
			}
			System.out.println(error);
			break;
		}
		
		*/
		
	}
}
