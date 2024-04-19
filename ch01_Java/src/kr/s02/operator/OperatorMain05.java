package kr.s02.operator;

public class OperatorMain05 {
	public static void main(String[] args) {

		// 입력 작업 시작
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("국어: ");
		// 입력된 정수를 변수에 대입
		int korean = input.nextInt();
		
		System.out.print("영어: ");
		int english = input.nextInt();
		
		System.out.print("수학: ");
		int math = input.nextInt();
		
		System.out.println("=================");
		
		int sum = korean + english + math;
		double avg = sum / 3.0; // 소숫점 자리가 나오려고 하면 정수끼리 계산이면 안 됨. 따라서 3이 아닌 3.0 사용
		
		
		System.out.printf("국어: %d점%n영어: %d점%n수학: %d점%n", korean, english, math);
		System.out.printf("총점: %d%n평균: %.2f%n", sum, avg);
		
		// 입력 작업 끝
		input.close();
	}
}
