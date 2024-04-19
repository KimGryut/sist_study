package kr.s02.operator;

public class OperatorMain03 {
	public static void main(String[] args) {
		/*
		 * <실습>
		 * 변수 선언 시 자료형은 모두 int로 지정
		 * 변수 korea, english, math로 선언하고 90, 95, 88로 초기화한다
		 * 총점을 구해서 변수 sum에 저장을 하고 평균을 구해서 변수 avg에 저장한다.
		 * 
		 * [출력예시]
		 * 국어 = 90점
		 * 영어 = 95점
		 * 수학 = 88점
		 * 총점 = 어쩌구점
		 * 평균 = 저쩌구점
		 * 
		 */
		
		int korea = 90;
		int english = 95;
		int math = 88;
		int sum = korea + english + math;
		int avg = sum / 3;
		
		System.out.printf("국어 = %d점%n영어 = %d점%n수학 = %d점%n"
				+ "총점 = %d점%n평균 = %d점%n",
				korea, english, math, sum, avg);
		
	}
}
