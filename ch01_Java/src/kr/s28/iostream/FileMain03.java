package kr.s28.iostream;

import java.io.File;

public class FileMain03 {
	public static void main(String[] args) {
		// 상대 경로
		String path = "sample.txt"; //원래 파일명
		String new_path = "example.txt"; // 새 파일명
		
		File f1 = new File(path);
		System.out.println("===파일명 변경===");
		File f2 = new File(new_path);
		System.out.println(f1.renameTo(f2));
	} 
	
}
