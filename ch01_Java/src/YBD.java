import java.util.Scanner;

public class YBD {
	int y; // 년
	int m; // 월(1~12)
	int d; // 일(1~31)

	// 생성자 : 주어진 날짜로 설정
	public YBD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

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

	// 평년 365일 윤년 366일
	static int leapDays(int isLeap) {
		if(isLeap==0) {
			return 365;
		} else if(isLeap==1) {
			return 366;
		} else {
			return 0;
		}
	}


	// 올해 기준으로 며칠 지났는지 판단하는 메서드
	static int takeDayOfYear(int y, int m, int d) {
		while(--m!=0) {
			d += mdays[isLeap(y)][m-1];
		}
		return d;
	}

	// 지난 날짜로 해당 날짜 반환 (365, 366 미만)
	static String todayOfYear(int y, int takeDays) {
		int m = 0;
		while(true) {
			takeDays -= mdays[isLeap(y)][m];
			if(takeDays<0) {
				takeDays += mdays[isLeap(y)][m];
				m++;
				break;
			} else {
				m++;
			}
		}

		return String.format("%04d%02d%02d", y, m, takeDays);

	}

	// n일 뒤 날짜를 반환 (객체로 반환)
	public YBD after(int n) {
		// 올해 지난 일수
		int takeDays = takeDayOfYear(this.y, this.m, this.d);
		// 올해 총 일수
		int days = leapDays(isLeap(this.y));
		// 올해 남은 일수
		int leftDays = days-takeDays;

		if(leftDays > n) {
			takeDays += n;
			String today = todayOfYear(this.y, takeDays);
			int year = Integer.parseInt(today.substring(0, 4));
			int month = Integer.parseInt(today.substring(4, 6));
			int date = Integer.parseInt(today.substring(6, 8));
			return new YBD(year, month, date);
		} else {
			while(true) {
				n -= leftDays;
				this.y += 1;
				if(leapDays(isLeap(this.y))>n) {
					String today = todayOfYear(this.y, n);
					int year = Integer.parseInt(today.substring(0, 4));
					int month = Integer.parseInt(today.substring(4, 6));
					int date = Integer.parseInt(today.substring(6, 8));
					return new YBD(year, month, date);
				} else {
					n-=leapDays(isLeap(this.y));
					leftDays=0;
				}
			}
		}    	
	}


	// n일 전 날짜를 반환
	public YBD before(int n) {
		// 올해 지난 일수
		int takeDays = takeDayOfYear(this.y, this.m, this.d);
		// 올해 총 일수
		int days = leapDays(isLeap(this.y));

		if(takeDays > n) {
			takeDays -= n;
			String today = todayOfYear(this.y, takeDays);
			int year = Integer.parseInt(today.substring(0, 4));
			int month = Integer.parseInt(today.substring(4, 6));
			int date = Integer.parseInt(today.substring(6, 8));
			return new YBD(year, month, date);
		} else {
			while(true) {
				n -= takeDays;
				this.y -= 1;
				if(leapDays(isLeap(this.y))>n) {
					n = leapDays(isLeap(this.y))-n;
					String today = todayOfYear(this.y, n);
					int year = Integer.parseInt(today.substring(0, 4));
					int month = Integer.parseInt(today.substring(4, 6));
					int date = Integer.parseInt(today.substring(6, 8));
					return new YBD(year, month, date);
				} else {
					n-=leapDays(isLeap(this.y));
					takeDays=0;
				}
			}
		} 
	}




	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("년도: ");
		int y = in.nextInt();
		System.out.print("\n월: ");
		int m = in.nextInt();
		System.out.print("\n일: ");
		int d = in.nextInt();
		System.out.println();

		YBD today = new YBD(y, m, d);

		int takeDay = takeDayOfYear(today.y, today.m, today.d);

		System.out.println(todayOfYear(today.y, takeDay));

		System.out.print("\n며칠 뒤 날짜가 궁금합니까?: ");
		int ad = in.nextInt();
		YBD afterDay = today.after(ad);
		System.out.println(afterDay.y+", "+afterDay.m+", "+afterDay.d);

		
		System.out.print("\n며칠 전 날짜가 궁금합니까?: ");
		int bd = in.nextInt();
		YBD beforeDay = today.before(bd);
		System.out.println(beforeDay.y+", "+beforeDay.m+", "+beforeDay.d);
		

		in.close();

	}


}



