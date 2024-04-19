package kr.s40.jdbc.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BookUserMain {

	private BufferedReader br;
	private BookDAO dao;
	private String me_id; // 로그인한 회원 아이디
	private boolean login; // 로그인 여부-> true:로그인 / false:로그아웃

	// 생성자
	public BookUserMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BookDAO();
			// 메뉴 호출
			callMenu();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null) try{br.close();} catch(IOException e) {}
		}
	}

	// 메뉴
	public void callMenu() throws IOException {
		// 로그인 체크
		while(true) { 
			System.out.print("1.로그인  2.회원가입  3.아이디/비밀번호 찾기   4.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // 로그인 
					System.out.print("아이디: ");
					me_id = br.readLine();
					System.out.print("비밀번호: ");
					String me_passwd = br.readLine();
					boolean check = dao.checkLogin(me_id, me_passwd);
					if(check==true) {
						System.out.println("로그인 성공!");
						System.out.println("");
						login = true;
						break;
					} else {
						System.out.println("로그인 실패");
						System.out.println("");
					}
				} else if(no==2) { // 회원가입
					System.out.print("아이디: ");
					String me_id = br.readLine();
					// 아이디 중복 체크
					int check = dao.checkId(me_id);
					if(check>=1) { // 1중복 2오류
						System.out.println("아이디가 중복되었습니다.");
						System.out.println("");
					} else { // 미중복
						System.out.print("비밀번호: ");
						String me_passwd = br.readLine();
						System.out.print("이름: ");
						String me_name = br.readLine();
						System.out.print("전화번호: ");
						String me_phone = br.readLine();
						dao.insertMember(me_id, me_passwd, me_name, me_phone);
						System.out.println("");
					}
				} else if(no==3) {
					System.out.println("1.아이디 찾기   2.비밀번호 찾기   3.뒤로가기 > ");
					int num = Integer.parseInt(br.readLine());
					if(num==1) {
						System.out.print("이름을 입력하세요: ");
						String me_name = br.readLine();
						System.out.print("핸드폰 번호를 입력하세요: ");
						String me_phone = br.readLine();
						dao.findId(me_name, me_phone);
						/* => 불필요한 작업임을 확인
						int check = dao.checkIdInfo(me_name, me_phone);
						if(check==1) {
							dao.findId(me_name, me_phone);
						} else {
							System.out.println("일치하는 회원 정보가 없습니다.");
							System.out.println("");
						}*/
					} else if (num==2) {
						System.out.print("아이디를 입력하세요: ");
						String me_idcheck = br.readLine();
						System.out.print("이름을 입력하세요: ");
						String me_name = br.readLine();
						System.out.print("핸드폰 번호를 입력하세요: ");
						String me_phone = br.readLine();
						dao.findPasswd(me_idcheck, me_name, me_phone);
						/* => 불필요한 작업임을 확인
						int check = dao.checkPasswdInfo(me_idcheck, me_name, me_phone);
						System.out.println("");
						if(check==1) {
							dao.findPasswd(me_idcheck, me_name, me_phone);
						} else {
							System.out.println("일치하는 회원 정보가 없습니다.");
						}*/
					} else if (num==3) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						System.out.println("");
					} else {
						System.out.println("잘못 입력했습니다.");
						System.out.println("");
					}
				} else if(no==4) { // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("숫자를 잘못 입력했습니다.");
					System.out.println("");
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				System.out.println("");
			}


		}

		// 로그인 체크 후 메뉴 
		while(login) {
			System.out.print("1.도서대출   2.MY대출내역   3.대출도서반납   4.도서검색   \n"
					+ "5.회원정보수정   6.도서신청   7.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // 도서대출
					dao.SelectBooks();
					System.out.print("대출할 도서 번호: ");
					int bk_num = Integer.parseInt(br.readLine());
					int check = dao.getStatusReservation(bk_num);
					if (check==0) {
						dao.insertReservation(bk_num, me_id);						
					} else if(check==1) {
						System.out.println("대출 중인 도서입니다.");
						System.out.println("");
					} else {
						System.out.println("책 번호를 잘못 입력했습니다.");
					}

				} else if(no==2) { // MY 대출목록
					dao.selectDetailReservation(me_id);
				} else if(no==3) { // 대출도서반납
					dao.selectOnlyReservation(me_id);
					System.out.print("반납할 대출 번호: ");
					int re_num = Integer.parseInt(br.readLine());
					int check = dao.getStatusBack(me_id, re_num);
					if (check==1) {
						dao.updateReservation(re_num);
					} else {
						System.out.println("반납하지 못하는 도서입니다.");
						System.out.println("");
					}
				} else if(no==4) {
					System.out.print("검색할 도서의 이름: ");
					String bk_name = br.readLine();
					dao.findBook(bk_name);
					System.out.println("");
				} else if(no==5){
					System.out.println("개인 정보 수정을 진행합니다. (기존 정보 사용 원할 시 공백)");
					System.out.print("이름: ");
					String me_name = br.readLine();
					System.out.print("비밀번호: ");
					String me_passwd = br.readLine();
					System.out.print("핸드폰 번호: ");
					String me_phone = br.readLine();
					dao.updateMemberInfo(me_id, me_name, me_passwd, me_phone);					
				} else if(no==6) {
					System.out.println("도서 신청을 진행합니다.");
					System.out.print("도서 이름: ");
					String ap_bk_name = br.readLine();
					System.out.print("도서 분류: ");
					String ap_bk_category = br.readLine();
					System.out.print("메모: ");
					String ap_memo = br.readLine();
					dao.applyNewBook(ap_bk_name, ap_bk_category, ap_memo, me_id);
					
				} else if(no==7) { // 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("숫자를 잘못 입력했습니다.");
					System.out.println("");
				}

			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				System.out.println("");
			}
		}
	}

	// 메인
	public static void main(String[] args) {
		new BookUserMain();
	}

}
