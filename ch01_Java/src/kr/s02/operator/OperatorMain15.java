package kr.s02.operator;

public class OperatorMain15 {
	public static void main(String[] args) {
		
	/*
	 *  실습
	 *  3개의 정수를 입력받아서 최댓값과 최솟값 출력하기
	 *  
	 *  첫번째 정수 : 10
	 *  두번째 점수 5
	 *  세번째 정수 7
	 *  
	 *  출력예시 최대: 10
	 *  쇠초 : 5
	 */
		java.util.Scanner input = new java.util.Scanner(System.in);
	
		
		// 비교할 세 가지 정수 입력받기
		System.out.print("첫 번째 정수: ");
		int first = input.nextInt();
		
		System.out.print("두 번째 정수: ");
		int second = input.nextInt();
		
		System.out.print("세 번째 정수: ");
		int third = input.nextInt();
		
		// 최대 최소를 구하기 위해 변수 정의
		int min, max;
		
		// 첫 번째 정수보다 두 번째 정수가 크면 최소=첫번째정수 / 아니라면 최소=두번째정수
		min = first < second ? first : second;
		// 위에서 나온 최소보다 세 번째 정수가 크면 최소=위에서지정한정수 / 아니라면 최소=세번째정수(최종)
		min = min < third ? min : third;
		
		// 첫 번째 정수보다 두 번째 정수가 작다면 최대=첫번째정수 / 아니라면 최대=두번째정수
		max = first > second ? first : second;
		// 위에서 나온 최대보다 세 번째 정수가 작으면 최대=위에서지정한정수 / 아니라면 최대=세번째정수(최종)
		max = max > third ? max : third;
		
		System.out.printf("최솟값: %d%n최댓값 : %d%n", min, max);
		
		input.close();

		
	}
	
}
