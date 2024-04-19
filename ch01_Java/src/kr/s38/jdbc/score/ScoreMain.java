package kr.s38.jdbc.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;


	// 생성자
	public ScoreMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new ScoreDAO();
			callMenu();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}

	// 숫자만 입력하라는 예외
	class ScoreException extends Exception{
		public ScoreException(String str) {
			super(str);
		}
	}

	// 예외 체크해주기 위한 식 (범위 내 숫자를 입력할 때까지 계속 입력받게 만들기)
	public int inputScore(String message) throws IOException {
		while (true) { // 올바른 score 값이 반환될 때까지 반복
			System.out.print(message); // 괄호 안에 있는 문구 띄우기
			try {
				int score = Integer.parseInt(br.readLine()); 
				if (score < 0 || score > 100) {
					throw new ScoreException("성적 범위 이탈");
				}
				return score;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능"); 
			} catch (ScoreException e) {
				System.out.println(e.getMessage());
			} 
		} 
	}



	// 메뉴 호출
	public void callMenu() throws IOException{
		while(true) {
			System.out.println("1.성적입력  2.성적목록  3.상세성적  4.성적수정  5.성적삭제  6.종료");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) { // 성적 입력

					System.out.print("이름: ");
					String name = br.readLine();
					int korean = inputScore("국어: ");
					int english = inputScore("영어: ");
					int math = inputScore("수학: ");
					int sum = dao.getSum(korean, english, math);
					int avg = dao.getAvg(sum);
					String grade = dao.getGrade(avg);

					dao.insertScore(name, korean, english, math, sum, avg, grade);

				} else if(no==2) { // 성적 목록 보기
					dao.selectScore();

				} else if (no==3) { // 상세 성적 보기
					dao.selectScore();
					System.out.println("성적을 조회할 학생 번호> ");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailScore(num);

				} else if (no==4) { // 성적 수정하기
					dao.selectScore();
					System.out.println("성적을 수정할 학생 번호> ");
					int num = Integer.parseInt(br.readLine());
					if(dao.checkNum(num)==true) {
						System.out.print("이름: ");
						String name = br.readLine();
						int korean = inputScore("국어: ");
						int english = inputScore("영어: ");
						int math = inputScore("수학: ");

						int sum = dao.getSum(korean, english, math);
						int avg = dao.getAvg(sum);
						String grade = dao.getGrade(avg);

						dao.updateScore(num, name, korean, english, math, sum, avg, grade);
					} else {
						System.out.println("해당 번호의 학생이 존재하지 않습니다.");
					}

				} else if (no==5) { // 성적 삭제하기
					dao.selectScore();
					System.out.println("성적을 삭제할 학생 번호> ");
					int num = Integer.parseInt(br.readLine());
					dao.deleteScore(num);
					
				} else if (no==6) { // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else { // 숫자 범위 오류
					System.out.println("숫자 범위가 잘못되었습니다.");
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			} 
		}
	}



	// 메인
	public static void main(String[] args) {
		new ScoreMain();
	}


}
