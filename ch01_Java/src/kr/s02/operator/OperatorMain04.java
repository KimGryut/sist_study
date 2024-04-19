package kr.s02.operator;

public class OperatorMain04 {
	public static void main(String[] args) {
		/*
		 * 실습
		 * 
		 * 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어줄 때 학생당 몇 개를 
		 * 가질 수 있고 최종적으로 몇 개가 남는지를 구하시오
		 * 
		 *  출력예시
		 *  학생 1명이 가지는 연필 수 : 17
		 *  남은 연필 수 : 24
		 */
		
		// 숙제 : pinos17@daum.net 보내주세요
		
		int pencils = 534;
		int students = 30;
		
		int quantity = pencils/students;
		int rest = pencils%students;
		System.out.printf("학생 한 명이 가지는 연필 수 : %d%n남은 연필 수 : %d%n",
				quantity, rest);
	}
}
