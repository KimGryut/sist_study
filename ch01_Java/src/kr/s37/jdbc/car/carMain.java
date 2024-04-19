package kr.s37.jdbc.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class carMain {
	private BufferedReader br;
	private CarDAO dao;

	// 생성자
	public carMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new CarDAO();
			carMenu();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원정리
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}

	// 숫자만 입력하라는 예외
	class NoMinusException extends Exception{
		public NoMinusException(String str) {
			super(str);
		}
	}

	// 예외 체크해주기 위한 식 (숫자를 입력할 때까지 계속 입력받게 만들기)
	public int inputInt(String message) throws IOException {
		while (true) { // 올바른 price 값이 반환될 때까지 반복
			System.out.println(message); // 괄호 안에 있는 문구 띄우기
			try {
				int price = Integer.parseInt(br.readLine()); 
				if (price < 0) {
					throw new NoMinusException("가격은 0이상 가능");
				}
				return price;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능"); 
			} catch (NoMinusException e) {
				System.out.println(e.getMessage());
			} 
		} 
	}

	// 메뉴 
	public void carMenu() throws IOException { 
		while(true) {
			System.out.println("1 자동차 정보 입력   2 목록 보기   3 자동차 상세 정보   4 자동차 정보 수정   5 자동차 정보 삭제   6 종료 > ");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no==1) { // 자동차 정보 입력
					System.out.print("이름: ");
					String name = br.readLine();
					System.out.print("차량번호: ");
					String cnumber = br.readLine();
					System.out.print("색상: ");
					String color = br.readLine();
					System.out.print("제조사: ");
					String maker = br.readLine();
					int price = inputInt("가격: ");

					// NoteDAO의 insetInfo 메서드를 호출해서 입력받은 데이터 전달
					dao.insertCar(name, cnumber, color, maker, price);
				} else if(no==2) { // 목록 보기
					dao.selectCar();
				} else if(no==3) { // 자동차 상세정보 수정
					dao.selectCar();
					System.out.print("열람할 자동차 번호> ");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailCar(num);

				} else if (no==4) { // 자동차 정보 수정
					dao.selectCar();
					System.out.print("수정할 자동차 번호> ");
					int num = Integer.parseInt(br.readLine());
					
					// 입력한 num의 데이터가 없으면 불필요하게 수정 정보 입력하지 않아도 됨
					if(dao.checkCar(num)==true) { 
						System.out.print("이름: ");
						String name = br.readLine();
						System.out.print("차량번호: ");
						String cnumber = br.readLine();
						System.out.print("색상: ");
						String color = br.readLine();
						System.out.print("제조사: ");
						String maker = br.readLine();
						int price = inputInt("가격: ");

						dao.updateCar(num, name, cnumber, color, maker, price);
						
					} else {
						System.out.println("해당 번호가 존재하지 않습니다.");
					}

				} else if (no==5) { // 자동차 정보 삭제
					dao.selectCar();
					System.out.print("삭제할 자동차 번호> ");
					int num = Integer.parseInt(br.readLine());
					dao.deleteCar(num);
				} else if (no==6) { // 시스템 종료
					System.out.println("프로그램을 종료합니다");
					break;
				} else { // 숫자 범위 벗어남
					System.out.println("번호를 잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) { // 숫자가 아닌 것 입력
				System.out.println("숫자만 입력 가능합니다.");
			} 
		}
	}


	// 메인
	public static void main(String[] args) {
		// 객체만 생성하면 끝
		new carMain();
	}

}
