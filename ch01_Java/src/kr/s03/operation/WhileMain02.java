package kr.s03.operation;

public class WhileMain02 {
	public static void main(String[] args) {
		int sum=0, su=1;
			//조건식
		while(su<=100) {
			// 누적
			sum+=su;
			//증감식
 			su++;
		}
		
		System.out.println("합계는 " + sum);
	}
}
