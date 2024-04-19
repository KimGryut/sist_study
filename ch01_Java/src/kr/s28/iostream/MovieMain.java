package kr.s28.iostream;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메뉴 : 1.영화정보입력 2.영화정보출력 3.파일생성 4.파일읽기 5.종료
 * 메서드명 : 메뉴 callMenu() 영화정보입력 inputMovie() 영화정보출력 printMovie()
 * 		   파일생성 createFile() 파일읽기 readFile() 
 * 입력시 조건 체크 : 상영시간 -> 0보다 크게 입력
 */

public class MovieMain {

	// 일단 먼저 다 생성
	ArrayList<Movie> list;
	BufferedReader br;
	FileWriter fw = null;
	FileReader fr = null;
	int readChar;

	// 상영 시간 0 이상 체크해주기 위한 임의의 예외
	class TimeException extends Exception{
		public TimeException(String str) {
			super(str);
		}
	}

	// 예외 체크해주기 위한 식
	public int inputTimeData(String item) throws IOException {
		while (true) {
			System.out.println(item);
			try {
				int time = Integer.parseInt(br.readLine());
				if (time < 0) {
					throw new TimeException("0이상 가능");
				}
				return time;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능"); 
			} catch (TimeException e) {
				System.out.println(e.getMessage());
			}
		} 
	}

	// 메인
	public MovieMain() {
		list = new ArrayList<Movie>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();	 // 메뉴 불러오기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!=null) try {br.close();} catch(IOException e) {}
		}		
	}

	// 메뉴
	public void callMenu() throws IOException {
		while(true) {
			System.out.println("\n1.영화정보입력  2.영화정보출력  3.파일생성  4.파일읽기  5.종료");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num==1) {
					inputMovie();
				} else if (num==2) {
					printMovie();
				} else if (num==3) {
					createFile();
				} else if (num==4) {
					readFile();
				} else if (num==5) {
					System.out.println("종료");
					System.exit(0);
				} else {
					System.out.println("잘못 입력했습니다.");
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자만 허용");
			}
		}
	}

	// 영화 정보 입력
	public void inputMovie() throws IOException {
		Movie m = new Movie();
		System.out.println("\n제목: ");
		m.setName(br.readLine());
		System.out.println("\n제작연도: ");
		m.setCreate_year(br.readLine());
		System.out.println("\n감독: ");
		m.setDirector(br.readLine());
		System.out.println("\n배우: ");
		m.setActor(br.readLine());
		m.setTime(inputTimeData("\n상영시간: "));

		list.add(m);
		System.out.println("영화정보입력이 완료되었습니다.");
	}

	// 영화 정보 출력
	public void printMovie() {
		if(list.size()>0) {
			System.out.println("\n등록 영화 수: " + list.size());
			System.out.println("제목\t제작연도\t감독\t배우\t상영시간");
			System.out.println("----------------------------------------------------------------------");
			for (Movie m: list) {
				/*System.out.printf("%s\t%s\t%s\t%s\t%d%n", 
						m.getName(), m.getCreate_year(), m.getDirector(), m.getActor(), m.getTime());*/
				System.out.println(m.toString());
			} 
		} else {
			System.out.println("출력할 영화 정보가 없습니다.");
		}

	}

	// 파일 생성하기
	public void createFile() {
		try {
			fw = new FileWriter("movieInfo.txt"); // 덮어쓰기
			
			fw.write("제목\t제작연도\t감독\t배우\t상영시간\n");
			fw.write("-----------------------------\n");			
			
			for (Movie m: list) {
				fw.write(m.toString());
			}
			fw.flush();
			System.out.println("파일 생성 완료");
		} catch(IOException e) {
			System.out.println("파일에 영화 정보 저장 오류");
		} finally {
			if(fw!=null) try {fw.close();} catch(IOException e) {} 
		}
	} 

	// 파일 읽기 (한글자씩)
	public void readFile() {
		try {
			fr = new FileReader("movieInfo.txt");
			while ((readChar = fr.read()) != -1) {
				System.out.print((char)readChar);
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch(IOException e) {
			System.out.println("파일 읽기 오류입니다.");
		} finally {
			if(fr!=null) try {fr.close();} catch(IOException e) {}
		}
	}




	public static void main(String[] args) {
		new MovieMain(); // 실행
	}
}
