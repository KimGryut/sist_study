import java.util.Scanner;

public class Main {
	// 첫 번째[] : 0 -> 평년 / 1 -> 윤년
	// 두 번째[] : 0 -> 1월(31일) / 1 -> 2월(28일, 29일)  ....  
	static int [][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} // 윤년	
	};

	// 윤년 : 4의 배수이면서 100의 배수가 아니라면 윤년
	// 예외 : 400의 배수이면 윤년
	static int isLeap(int year) {
		return(year%4==0 && year%100 !=0 || year%400==0) ? 1:0;
	}	

	static int dayOfYear(int y, int m, int d) {
		while(--m!=0) { // 시작하자마자 -1 한 값을 m에 넣음
			d += mdays[isLeap(y)][m-1]; // 인덱스 번호는 늘 -1
		}
		return d;
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		d = mdays[isLeap(y)][m-1]-d;
		while(++m!=13) {
			d += mdays[isLeap(y)][m-1];
		}
		return d;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int retry;

		System.out.println("그 해 경과 일수를 구합니다.");
		do {
			System.out.print("년: ");
			int year = in.nextInt();

			System.out.print("월: ");
			int month = in.nextInt();

			System.out.print("일: ");
			int day = in.nextInt();

			System.out.printf("그 해 %d일째입니다.%n", dayOfYear(year, month, day));
			
			if(isLeap(year)==0) {
					System.out.printf("\n남은 일수는 %d일입니다.%n", (365-dayOfYear(year, month, day)));	
			} else {
				System.out.printf("\n남은 일수는 %d일입니다.%n", (366-dayOfYear(year, month, day)));
			}
			System.out.println("종료를 원하시면 1을 눌러주세요");
			retry = in.nextInt();
		} while(retry!=1);
		in.close();
			
	}
}