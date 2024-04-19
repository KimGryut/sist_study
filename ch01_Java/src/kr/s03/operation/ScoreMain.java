package kr.s03.operation;

public class ScoreMain {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int korean, english, math, sum;
		char grade;
		float avg;

		// 입력한 점수가 정상 범주가 아닌 경우 계속 입력하게 하기
		do {
			System.out.print("국어 : ");
			korean = input.nextInt();			
		} while(korean < 0 || korean > 100);
		
		do {
			System.out.print("영어 : ");
			english = input.nextInt();			
		} while(english< 0 || english > 100);
		
		do {
			System.out.print("수학 : ");
			math = input.nextInt();			
		} while(math < 0 || math > 100);
		
		
		// 총점 구하기
		sum = korean + english + math;
		// 평균 구하기
		avg = sum / 3.0f;
		
		// 등급 구하기
			// 캐스트 연산자
		switch((int)(avg/10)) {
					// 연산 결과
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		case 6:
			grade = 'D'; break;
		default:
			grade = 'F'; break;
		}
		
		System.out.print("\n"); // 단순 줄바꿈
		System.out.printf("국어: %d%n영어: %d%n수학: %d%n", korean, english, math);
		System.out.printf("총점: %d%n평균: %.2f%n", sum, avg);
		System.out.printf("등급: %c학점", grade);
		
		
		input.close();
	}
}
