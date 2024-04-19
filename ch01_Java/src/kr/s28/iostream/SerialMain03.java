package kr.s28.iostream;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


class UserInfo implements Serializable {
	private String name;
	private int age;
	private String address;
	
	public UserInfo(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 주소: " + address + "";
	}
	
	
}

public class SerialMain03 {
	public static void main(String[] args) {
		// 직렬화할 객체 생성
		UserInfo ui = new UserInfo("John", 23, "서울시");
		UserInfo ui2 = new UserInfo("Sunny", 18, "부산시");
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		
		list.add(ui);
		list.add(ui2);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			// 파일생성
			fos = new FileOutputStream("UserInfo.ser");
			oos = new ObjectOutputStream(fos);
			// 객체 직렬화 하기
			oos.writeObject(list);
			System.out.println("직렬화가 완료되었습니다");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (oos!=null) try {oos.close();} catch(IOException e) {}
			if (fos!=null) try {fos.close();} catch(IOException e) {}
		}
		
	}
}
