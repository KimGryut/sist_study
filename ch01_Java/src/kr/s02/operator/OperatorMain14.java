package kr.s02.operator;

public class OperatorMain14 {
	public static void main(String[] args) {
		/*
		 * 실습 
		 * A전자 대리점에서는 그날 물건 판매액의 15%를 할인해주기로 했습니다.
		 * 판매한 상품명과 상품의 단가와 수량을 입력해서 지불 금액을 출력하는 프로그램을 작성하시오.
		 * 단, 출력 시에는 정수 형태로 명시. (소숫점 이하 자리는 절삭. 반올림x 내림o)
		 * 
		 * 입력 및 출력 예시
		 * 상품명 입력 : 냉장고
		 * 단가 : 500000 
		 * 수량 : 3
		 * 냉장고 3대의 가격은 1,275,000원
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("상품명 : ");
		String item = input.nextLine();
		
		System.out.print("단가 : ");
		int cost = input.nextInt();
		
		System.out.print("수량 : ");
		int num = input.nextInt();
		
		int total = (int)(cost*0.85*num);
		
		// 0.85대신 85/100 < 을 써도 정수를 유지함 
		
		System.out.printf("%s %d개의 가격은 %,d원", item, num, total);
		
		
		
		input.close();
		
		
	}
}
