package kr.s21.object.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());
		System.out.println("---------------");
		
		// deprecated 되어 사용하지 않음 (완곡한 금지)
		// System.out.println(now.toLocaleString()); < 우리가 원하는 방식이지만 지금은 안 쓰는 게 나음
		
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today); // 컴퓨터에선 4자리(2024)로 인식하고 있으나 표시만 2자리
		
		System.out.println("-----------------");
		
		df = DateFormat.getDateTimeInstance(); // 초까지 나오고, 4자리로 나옴
		today = df.format(now);
		System.out.println(today);
		
		System.out.println("-----------------");
		
		df = DateFormat.getDateInstance(); // 연월일만 보여줌
		today = df.format(now);
		System.out.println(today);
		
		System.out.println("----------------");
		
		df = DateFormat.getTimeInstance(); // 시간만 보여줌
		today = df.format(now);
		System.out.println(today);

		System.out.println("----------------");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh:mm:ss");
		today = sf.format(now);
		System.out.println(today);
		
	}
}
