package kr.s28.iostream;

import java.io.IOException;
import java.io.FileWriter;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			// 파일 생성 (덮어쓰기)
			// fw = new FileWriter("fileWriter.txt");
			
			// 파일 생성 (이어쓰기)
			fw = new FileWriter("fileWriter.txt",true);
			
			String message = "안녕하세요 FileWriter 테스트";
			fw.write(message); // 버퍼 출력
			fw.flush();
			
			System.out.println("파일을 생성하고 내용 기술 완료");
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(fw != null) try{fw.close();} catch(IOException e) {}
		}
	}
}
