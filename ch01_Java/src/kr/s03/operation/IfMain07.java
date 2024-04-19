package kr.s03.operation;

public class IfMain07 {
	public static void main(String[] args) {
		/*
		 * 실습
		 * 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오
		 * 만나이 = (현재 연도 - 태어난 연도) 
		 * 생일이 지났다면 -1
		 * 생일이 지나지 않았다 -2
		 * 
		 * 출색 연도 입력 : 2000
		 * 월 입력 : 3
		 * 일 입력 : 12
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// 오늘 날짜 지정
		int nowYear = 2024;
		int nowMonth = 2;
		int nowDate = 21;
		
		// 사용자의 생일 입력받기
		System.out.print("출생연도: ");
		int year = input.nextInt();
		
		System.out.print("월: ");
		int month = input.nextInt();
		
		System.out.print("일: ");
		int date = input.nextInt();
		
		
		/*
		int myYear;
		
		if (month>nowMonth) {
			myYear = nowYear-year- 1;
			System.out.print("만 나이: " + myYear);
		}  else if (nowMonth == month && date > nowDate){
			myYear = nowYear-year- 1;
			System.out.print("만 나이: " + myYear);
		} else {
			myYear = nowYear-year- 0;
			System.out.print("만 나이: " + myYear);
		}
		
		*/
		
		int m;
		
		if (month>nowMonth) {
			m = 1;
			
		}  else if (nowMonth == month && date > nowDate){
			m = 1;
		} else {
			m = 0;
		}
		 
		int myYear = nowYear - year - m;
		System.out.print("만 나이: " + myYear);
		
		
		input.close();
	}
}
