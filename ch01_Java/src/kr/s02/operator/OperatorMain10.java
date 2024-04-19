package kr.s02.operator;

public class OperatorMain10 {
	public static void main(String[] args) {
		System.out.println("===조건(삼항)연산자===");
		
		int a=5, b=10;
		int max; // 최댓값을 저장할 변수
		int min; // 최솟값을 저장할 변수
		
		// 최댓값 구하기
		max = a > b ? a : b;
		
		// 최솟값 구하기
		min = a < b ? a : b;
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		
	}
}
