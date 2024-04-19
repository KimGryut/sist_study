package kr.s04.array;

public class ArrayMain07 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String[] course = {"국어", "영어", "수학"};
		int[] score = new int[course.length];
		int sum = 0;
		float avg = 0.0f;
		
		for(int i=0; i<course.length; i++) {
			do {
				System.out.print(course[i] + "의 점수: ");
				score[i] = input.nextInt();
			} while(score[i]<0 || score[i]>100);
			
			sum += score[i];
		}
		
		for(int i=0; i<score.length; i++) {
			System.out.printf("%s = %d%n", course[i], score[i]);
		}
		avg = sum / (float)score.length;

		System.out.printf("총점 = %d%n평균 = %.2f", sum, avg);
		
		input.close();
	}
}
