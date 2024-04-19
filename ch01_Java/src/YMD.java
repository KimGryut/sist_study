import java.util.Scanner;

public class YMD {
	private int year; // 년
	private int month; // 월(1~12)
	private int day; // 일(1~31)

	// 평년과 윤년의 월별 일수
	private static final int[][] MDAYS = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} // 윤년
	};

	// 생성자 : 주어진 날짜로 설정
	public YMD(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// 윤년 판단 => 아래 조건식이 하나라도 충족되면 true를 반환 (윤년)
	// 충족하지 않는다면 false를 반환(평년)
	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	// 올해의 총 일 수 계산 
	// true(윤년): 366
	// false(평년): 365
	private int totalDaysInYear(int year) {
		return isLeapYear(year) ? 366 : 365;
	}

	// 올해의 지난 일 수 계산
	private int daysPassedInYear(int year, int month, int day) {
		int daysPassed = day;
		for (int i = 0; i < month - 1; i++) {
			daysPassed += MDAYS[isLeapYear(year) ? 1 : 0][i]; // ture(윤년):배열 인덱스1 false(평년): 배열 인덱스0
		}
		return daysPassed;
	}

	// n일 뒤의 날짜를 계산하여 반환
	public YMD after(int days) {
		// 올해 총 일 수
		int totalDays = totalDaysInYear(year);
		// 올해 지난 일수
		int daysPassed = daysPassedInYear(year, month, day);
		// 올해 남은 일 수 
		int remainingDays = totalDays - daysPassed;

		if (remainingDays >= days) {
			// 현재 날짜에서 n일을 더함
			int newDay = day + days; // 일
			int newMonth = month; // 월
			int newYear = year; // 년

			// 그 달의 일 수보다 newDay가 큰 경우 다음달로 넘어가야 함
			while (newDay > MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1]) {
				newDay -= MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1]; // 그 일 수만큼 빼고
				newMonth++; // 달을 한 달 올림
			}
			return new YMD(newYear, newMonth, newDay);
		} else {
			// 올해를 넘어가는 경우
			days -= remainingDays; // 남은 일 수만큼 빼주고
			int newYear = year + 1; // 올해 년도를 일 년 올림
			while (days > totalDaysInYear(newYear)) { // 만약 그 해의 일 수보다도 많으면
				days -= totalDaysInYear(newYear); // 그 해 일 수만큼 빼주고
				newYear++; // 일 년씩 계속 올림
			}

			// 일단 처음 세팅은 1월
			int newMonth = 1;
			int newDay = days;
			// 위에서 했던 달 작업 반복
			while (newDay > MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1]) {
				newDay -= MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1];
				newMonth++;
			}

			return new YMD(newYear, newMonth, newDay);
		}
	}

	// n일 전의 날짜를 계산하여 반환
	public YMD before(int days) {
		int daysPassed = daysPassedInYear(year, month, day);

		if (days <= daysPassed) {
			// 현재 날짜에서 n일을 뺌
			int newDay = day - days;
			int newMonth = month;
			int newYear = year;

			// 만약 날짜가 음수라면 저번 달이 되어야 함
			while (newDay <= 0) {
				newMonth--; // 한 달 뺌
				if (newMonth <= 0) { // 그러다가 달이 음수가 된다면 저번 년도가 되어야 함
					newYear--; // 일 년 뺌
					newMonth = 12; // 처음 세팅 12월
				}
				// 음수인 newDay와 현재 달의 일수만큼 빼주면 그 날짜가 나옴
				newDay += MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1];
			}

			return new YMD(newYear, newMonth, newDay);
		} else {
			// 현재 연도를 벗어나는 경우
			days -= daysPassed; // 올해 지난 날짜만큼 빼줌
			int newYear = year - 1; // 작년으로 감
			while (days > totalDaysInYear(newYear)) { // 올해 총 날짜보다도 많으면 
				days -= totalDaysInYear(newYear); 
				newYear--; // 또 작년으로 감
			}

			// 처음 세팅 12월
			int newMonth = 12;
			// 처음 세팅 그 달의 마지막 날
			int newDay = MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1];
			while (days > 0) {
				newDay--; // day만큼의 전날을 구해야 하므로 날짜를 1씩 깎아줌
				if (newDay == 0) { // 날이 0이 된다면
					newMonth--; // 한 달 줄여줌
					if (newMonth == 0) { // 달이 0이 된다면 
						newYear--; // 일 년 줄여줌
						newMonth = 12; // 세팅 12월
					}
					// 세팅 그 달의 마지막일
					newDay = MDAYS[isLeapYear(newYear) ? 1 : 0][newMonth - 1];
				}
				// 오늘 날짜 깎을 때마다 전 날 구하는 일 수 값도 깎음
				days--;
			}

			return new YMD(newYear, newMonth, newDay);
		}
	}

	// 날짜를 지정된 형식에 맞게 문자열로 반환
	private String formatDate(int year, int month, int day) {
		return String.format("%04d-%02d-%02d", year, month, day);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("년도: ");
		int year = scanner.nextInt();

		System.out.print("월: ");
		int month = scanner.nextInt();

		System.out.print("일: ");
		int day = scanner.nextInt();

		YMD today = new YMD(year, month, day);

		System.out.println("현재 날짜: " + today.formatDate(year, month, day));

		System.out.print("며칠 뒤의 날짜가 궁금하세요?: ");
		int afterDays = scanner.nextInt();
		YMD afterDate = today.after(afterDays);
		System.out.println("며칠 뒤의 날짜: " + afterDate.formatDate(afterDate.year, afterDate.month, afterDate.day));

		System.out.print("며칠 전의 날짜가 궁금하세요?: ");
		int beforeDays = scanner.nextInt();
		YMD beforeDate = today.before(beforeDays);
		System.out.println("며칠 전의 날짜: " + beforeDate.formatDate(beforeDate.year, beforeDate.month, beforeDate.day));

		scanner.close();
	}
}