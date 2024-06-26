package kr.s28.iostream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SerialMain04 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			// 파일생성
			fis = new FileInputStream("UserInfo.ser");
			ois = new ObjectInputStream(fis);
			// 역직렬화
			@SuppressWarnings("unchecked") // Type safety: Unchecked cast from Object to ArrayList<UserInfo> (노란밑줄) 안보이게 하려고
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject();
			System.out.println(list);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois!=null) try {ois.close();} catch(IOException e) {};
			if(fis!=null) try {fis.close();} catch(IOException e) {};
		}
	}
}
