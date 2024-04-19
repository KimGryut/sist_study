package kr.s03.operation;

public class SwitchMain02 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("계절 입력: ");
		// next() : 봄 여름 -> 봄만 사용
		// nextLine() : 봄 여름 -> 봄 여름 한 라인의 데이터 사용
		String season = input.nextLine();
		
		switch(season) {
		case "봄" :
			System.out.println("꽃이 피는 계절");
			break;
			
		case "여름" :
			System.out.println("더워 죽는 계절");
			break;
			
		case "가을" :
			System.out.println("시원한 계절");
			break;
			
		case "겨울" :
			System.out.println("눈사람 만드는 계절");
			break;
			
		default :
			System.out.println("계절을 잘못 입력");
			break;
		}
		
		
		input.close();
	}
}
