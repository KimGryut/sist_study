package project.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import kr.s40.jdbc.book.BookDAO;

import java.io.IOException;

public class BankMain {
	private BankDAO dao;
	private BufferedReader br;
	private String user_id; // 로그인한 회원 아이디
	private boolean login; // 로그인 여부-> true:로그인 / false:로그아웃


	// 예외 체크해주기 위한 식 (입금이나 출금은 0원 이상 가능)
	public int inputPrice(String message) throws IOException {
		while (true) { // 올바른 price 값이 반환될 때까지 반복
			System.out.print(message); // 괄호 안에 있는 문구 띄우기
			try {
				int price = Integer.parseInt(br.readLine()); 
				if (price <= 0) { // 새로운 예외 정의
					throw new NoMinusException("입금은 0원 이상 가능합니다.\n");
					
				}
				return price;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.\n"); 
			} catch (NoMinusException e) { // 새로운 예외 발생
				System.out.println(e.getMessage());
			} 
		} 
	}

	// 알맞는 금액을 입력하라는 예외
	class NoMinusException extends Exception{
		public NoMinusException(String str) {
			super(str);
		}
	}


	// 생성자
	public BankMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BankDAO();
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
			System.out.print("1.로그인  2.회원가입  3.사용자모드   4.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // 로그인 
					System.out.print("아이디: ");
					user_id = br.readLine();
					System.out.print("비밀번호: ");
					String user_passwd = br.readLine();
					boolean check = dao.checkLogin(user_id, user_passwd);
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
					String user_id = br.readLine();
					// 아이디 중복 체크
					int check = dao.checkId(user_id);
					if(check>=1) { // 1중복 2오류
						System.out.println("아이디가 중복되었습니다.");
						System.out.println("");
					} else { // 미중복
						System.out.print("이름: ");
						String user_name = br.readLine();
						System.out.print("비밀번호: ");
						String user_passwd = br.readLine();						
						System.out.print("주소: ");
						String user_address = br.readLine();						
						System.out.print("전화번호: ");
						String user_phone = br.readLine();						
						dao.insertUser(user_id, user_name, user_passwd, user_address, user_phone);
						System.out.println("");
					}
				} else if(no==3) { // 관리자 모드


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
			System.out.print("1.입금  2.출금  3.송금  4.잔액조회  5.내역조회  6.계좌개설   7.종료 ");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // 입금
					dao.SelectAccount(user_id);
					System.out.print("계좌번호 입력: ");
					String account_num = br.readLine();
					System.out.print("비밀번호: ");
					int account_password = Integer.parseInt(br.readLine());
					System.out.println("");
					boolean check = dao.checkPasswd(account_num, account_password, user_id);
					if(check==true) {
						int amount = inputPrice("입금할 금액: ");
						System.out.println("");
						dao.deposit(account_num, amount);
						dao.insertDpHistory(account_num, amount); 
						System.out.println(account_num + " 계좌에 " + amount + "원이 입금되었습니다.");
						System.out.println(" ");
					} else {
						System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
						System.out.println("");
					}
				} else if(no==2) { // 출금
					dao.SelectAccount(user_id);
					System.out.print("계좌번호 입력: ");
					String account_num = br.readLine();
					System.out.print("비밀번호: ");
					int account_password = Integer.parseInt(br.readLine());
					System.out.println("");
					boolean check = dao.checkPasswd(account_num, account_password, user_id);
					if(check==true) {
						int amount = inputPrice("출금할 금액: ");
						System.out.println("");
						dao.withdraw(account_num, amount);
						dao.insertWdHistory(account_num, amount);
						System.out.println(account_num + " 계좌에 " + amount + "원이 출금되었습니다.");
					} else {
						System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
						System.out.println("");
					}
				} else if(no==3) { // 송금
					dao.SelectAccount(user_id);
					System.out.print("계좌번호 입력: ");
					String account_num = br.readLine();
					System.out.print("비밀번호: ");
					int account_password = Integer.parseInt(br.readLine());
					System.out.println("");
					boolean check1 = dao.checkPasswd(account_num, account_password, user_id);
					if(check1==true) {
						System.out.print("송금할 계좌번호 입력: ");
						String sd_account_num = br.readLine();
						boolean check2 = dao.checkSdAccount(sd_account_num);
						if(check2==true) {
							int amount = inputPrice("송금할 금액: ");
							System.out.println("");
							dao.withdraw(account_num, amount);
							dao.deposit(sd_account_num, amount);
							dao.insertSdHistory(account_num, sd_account_num, amount);
							System.out.println(sd_account_num + " 계좌에 " + amount + "원이 송금되었습니다.");
						} else {
							System.out.println("상대 계좌가 존재하지 않습니다.");
						}
					} else {
						System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
						System.out.println("");
					}
				} else if(no==4) { // 잔액 조회
					dao.SelectAccount(user_id);
					System.out.print("조회할 계좌번호 입력: ");
					String account_num = br.readLine();
					System.out.print("비밀번호: ");
					int account_password = Integer.parseInt(br.readLine());
					System.out.println("");
					boolean check = dao.checkPasswd(account_num, account_password, user_id);
					if(check==true) {
						dao.SelectDetailAccount(account_num);
					} else {
						System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
						System.out.println("");
					}
				} else if(no==5){ // 내역 조회
					dao.SelectAccount(user_id);
					System.out.print("조회할 계좌번호 입력: ");
					String account_num = br.readLine();
					System.out.print("비밀번호: ");
					int account_password = Integer.parseInt(br.readLine());
					System.out.println("");
					boolean check = dao.checkPasswd(account_num, account_password, user_id);
					if(check==true) {
						dao.SelectDetailHistory(account_num);
					} else {
						System.out.println("계좌번호 또는 비밀번호가 일치하지 않습니다.");
						System.out.println("");
					}
				} else if (no==6){ // 계좌 개설
					int check = 1;
					String account_num;
					do {
						account_num = dao.getAccountNum();
						check = dao.checkAccount(account_num);	
					} while(check==1);

					System.out.print("계좌 비밀번호 설정(4자리숫자): ");
					int account_password = Integer.parseInt(br.readLine());
					dao.insertAccount(account_num, user_id, account_password);
				} else if (no==7) { // 종료
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


	public static void main(String[] args) {
		new BankMain();
	}


}
