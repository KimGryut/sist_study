package kr.s39.jdbc.shop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShopUserMain {
	private BufferedReader br;
	private ShopDAO dao;

	// 생성자
	public ShopUserMain() {
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
			System.out.println("1.회원 가입 하기   2.회원 상세 보기   3.상품 구매하기   4.구매내역 보기   5.프로그램 종료");
			try {
				int no = Integer.parseInt(br.readLine());

				if(no==1) { // 회원가입
					System.out.print("회원 아이디: ");
					String cust_id = br.readLine();
					System.out.print("회원 이름: ");
					String cust_name = br.readLine();
					System.out.print("회원 주소: ");
					String cust_address = br.readLine();
					System.out.print("회원 전화번호: ");
					String cust_tel = br.readLine();
					
					dao.insertCustomer(cust_id, cust_name, cust_address, cust_tel);
					
				} else if(no==2) { // 회원상세
					System.out.print("아이디: ");
					String cust_id = br.readLine(); 
					dao.selectDetailCustomer(cust_id);
				} else if(no==3) {// 상품구매
					dao.selectItems();
					System.out.print("구매할 상품의 번호: ");
					int item_num = Integer.parseInt(br.readLine());
					System.out.print("아이디: ");
					String cust_id = br.readLine();
					dao.insertOrder(item_num, cust_id);
					
				} else if(no==4) { // 구매 내역
					System.out.print("아이디: ");
					String cust_id = br.readLine(); 
					dao.selectOrdersByid(cust_id);
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
		new ShopUserMain();
	}
}

