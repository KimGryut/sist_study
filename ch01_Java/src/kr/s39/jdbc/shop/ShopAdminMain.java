package kr.s39.jdbc.shop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class ShopAdminMain {
	private BufferedReader br;
	private ShopDAO dao;
	
	// 생성자
	public ShopAdminMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new ShopDAO();
			callMenu();			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null) try{br.close();} catch(IOException e) {}
		}
	}
	
	// 메뉴 
	public void callMenu() throws IOException{
		while(true) {
			System.out.println("1.상품 등록   2.상품 목록 보기   3.회원 목록 보기   4.구매 목록 보기   5.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				
				if(no==1) { // 상품 등록
					System.out.print("상품의 이름: ");
					String item_name = br.readLine();
					System.out.print("상품의 가격: ");
					int item_price = Integer.parseInt(br.readLine());
					
					dao.insertItem(item_name, item_price);
					
				} else if(no==2) { // 상품 목록 보기
					dao.selectItems();
				} else if(no==3) { // 회원 목록 보기
					dao.selectCustomers();
				} else if(no==4) { // 구매 목록 보기
					dao.selectOrders();
				} else if(no==5) { // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else { // 번호 잘못 입력
					System.out.println("번호를 잘못 입력했습니다.");
				}				
			} catch(NumberFormatException e) { // 숫자가 아닌 것 입력
				System.out.println("숫자만 입력 가능");
			} 
		}
	}
	
	public static void main(String[] args) {
		new ShopAdminMain();
	}
}
