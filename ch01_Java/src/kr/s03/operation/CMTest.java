package kr.s03.operation;

public class CMTest {
	public static void main(String[] args) {

		
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
		
		String error = "";
		
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
				
				// 정상 주문
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
				} else { // 비정상 주문
					if (coin<balance) { // 동전 부족시 동전 부족하단 문장 추가
						error += "거스름돈이 부족합니다. 죄송합니다. \n";
					}
					
					if (coffee < content_coffee) { // 커피 부족시 커피 부족하단 문장 추가
						error += "커피가 부족합니다. 죄송합니다. \n";
					}
					
					if (cream <content_cream) { // 크림 부족시 크림 부족하단 문장 추가
						error += "크림이 부족합니다. 죄송합니다.";
					}
					if (sugar <content_sugar) { // 설탕 부족시 설탕 부족하단 문장 추가
						error += "설탕이 부족합니다. 죄송합니다.";
					}
					
					// 전체 부족한 것 송출
					System.out.println("\n=====자판기 재고 정보=====\n"
							+ "동전 : " + coin
							+ "\n커피 : " + coffee + "\n크림 : " + cream
							+"\n설탕 : " + sugar + "\n");
					System.out.println(error);
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
		
	}
}