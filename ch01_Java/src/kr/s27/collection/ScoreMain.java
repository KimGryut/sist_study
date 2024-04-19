package kr.s27.collection;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	/*
	 * 실습
	 * 메뉴 : 1.성적입력 2.성적출력 3.종료
	 * 메서드명 : 메뉴(callMenu()), 성적입력(inputScore()), 성적출력(printScore())
	 * 입력 시 조건 체크 : 0부터 100까지만 입력
	 */
	
	ArrayList<Score> list;
	BufferedReader br;
	
	public ScoreMain() {
		list = new ArrayList<Score>();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null) try {br.close();}catch(IOException e) {}
		}
	}
	
	// 메뉴 호출
	public void callMenu() throws IOException{
		while(true) {
			System.out.println("\n1.성적입력  2.성적출력  3.종료");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num==1) {
					inputScore();
				} else if(num==2) {
					printScore();
				} else if (num==3) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("잘못 입력헀습니다.");
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
	// 성적 입력
	public void inputScore() throws IOException{
		Score s = new Score();
		System.out.println("\n이름: ");
		s.setName(br.readLine());
		s.setKorean(inputScoreData("\n국어: "));
		s.setEnglish(inputScoreData("\n영어: "));
		s.setMath(inputScoreData("\n수학: "));		
		
		list.add(s);
		System.out.println("성적 입력이 완료되었습니다.\n");
	}
	
	// 성적 출력
	public void printScore() {
		System.out.println("\n총 학생 수 : " + list.size());
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("-----------------------------------------------------------------");
		for (Score s: list) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s%n", 
					s.getName(), s.getKorean(), s.getEnglish(), s.getMath(), 
					s.makeSum(), s.makeAvg(), s.makeGrade());
		}
	}
	
	public int inputScoreData(String item) throws IOException {
	    while (true) {
	        System.out.println(item);
	        try {
	            int score = Integer.parseInt(br.readLine());
	            if (score < 0 || score > 100) {
	                throw new ScoreValueException("0부터 100까지만 입력 가능");
	            }
	            return score;
	        } catch (NumberFormatException e) {
	            System.out.println("숫자만 입력 가능");
	        } catch (ScoreValueException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
	}
	
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}
