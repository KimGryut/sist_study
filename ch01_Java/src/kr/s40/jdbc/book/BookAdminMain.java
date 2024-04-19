package kr.s40.jdbc.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.io.IOException;

public class BookAdminMain {
	private BufferedReader br;
	private BookDAO dao;

	// 생성자
	public BookAdminMain() {
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BookDAO();
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
			System.out.println("1.도서 등록   2.도서 목록 보기   3.회원 목록 보기   4.대출 목록 보기   "
					+ "\n5.도서 검색하기   6.도서 신청 확인하기   7.신청된 도서 신청하기   8.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());

				if(no==1) { // 도서 등록
					System.out.print("도서의 이름: ");
					String bk_name = br.readLine();
					System.out.print("도서의 분류: ");
					String bk_category = br.readLine();
					
					dao.InsertBook(bk_name, bk_category);
				} else if(no==2) { // 도서 목록 보기
					dao.SelectBooks();
				} else if(no==3) { // 회원 목록 보기
					dao.selectMembers();
				} else if(no==4) { // 대출 목록 보기
					dao.selectListReservations();
				} else if(no==5) {
					System.out.print("검색할 도서의 이름: ");
					String bk_name = br.readLine();
					dao.findBook(bk_name);
				} else if(no==6) {
					dao.showApplyNewBook();
				} else if(no==7) {
					dao.showApplyNewBook();
					System.out.print("등록할 도서의 신청 번호: ");
					int apnum = Integer.parseInt(br.readLine());
					int check = dao.getStatusApply(apnum);
					if(check== 1) { // 신청 가능
						dao.InsertBook(dao.getApplyBookName(apnum), dao.getApplyBookCategory(apnum));
						dao.updateApply(apnum);
						System.out.println("");
					} else {
						System.out.println("신청할 수 없습니다.");
						System.out.println("");
					}
				} else if(no==8) { // 프로그램 종료
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
		new BookAdminMain();
	}
}



