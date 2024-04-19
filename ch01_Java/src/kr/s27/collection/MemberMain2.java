package kr.s27.collection;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 *  [실습]
 *  메뉴 : 1.회원정보입력 2.회원정보출력 3.종료
 *  메서드명 : 메뉴(callMenu), 회원정보입력(register), 회원정보출력(printUserInfo)
 *  입력 시 조건 체크 : 나이는 한 살 이상 입력 가능 
 */
public class MemberMain2 {
	ArrayList<Member> list;
	BufferedReader br;
	
	// 나이 관련 예외 만들기
	class YearException extends Exception {
		public YearException(String str) {
			super(str);
		}
	}
	
	public MemberMain2() {
		list = new ArrayList<Member>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!=null) try{br.close();} catch(IOException e) {}
		}
	}
	
	// 메뉴 호출
	public void callMenu() throws IOException {
		while (true) {
			System.out.println("1.회원정보입력  2.회원정보출력  3.종료");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num==1) {
					register();
				} else if(num==2) {
					printUserInfo();
				} else if(num==3) {
					System.out.println("종료");
					System.exit(0);
				} else {
					System.out.println("잘못 입력했습니다.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 허용");
			}
		}
	}
	
	
	// 회원정보입력
	public void register() throws IOException {
		Member m = new Member();
		System.out.println("\n이름: ");
		m.setName(br.readLine());

		try {
			System.out.println("\n나이: ");
			int age = Integer.parseInt(br.readLine());
			if(age>= 1) {
				m.setAge(age);
			}else {
				throw new YearException("나이는 한 살 이상부터 입력 가능합니다.\n");
			}
		} catch (YearException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("\n직업: ");
		m.setJob(br.readLine());
		System.out.println("\n주소: ");
		m.setAddress(br.readLine());
		System.out.println("\n전화번호: ");
		m.setPhone(br.readLine());
		
		list.add(m);
		System.out.println("\n회원가입이 완료되었습니다.\n");
	}
	
	// 회원정보 출력
	public void printUserInfo() {
		System.out.println("회원 수 : " + list.size() + "\n");
		System.out.println("이름\t나이\t직업\t주소\t전화번호");
		System.out.println("---------------------------------");
		for(Member m : list) {
			System.out.printf("%s\t%d\t%s\t%s\t%s%n",
					m.getName(), m.getAge(), m.getJob(), m.getAddress(), m.getPhone());
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new MemberMain2();
	}
}
