package kr.s04.array;

public class ArrayMain05 {
	public static void main(String[] args) {
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];
		int min = score[0];
		
		for(int i=1; i<score.length; i++) {
			// 최솟값 구하기
			if (min>score[i]) {
				min = score[i];
			}
			// 최댓값 구하기
			if (max<score[i]) {
				max = score[i];
			}
		}
		
		System.out.println(min);
		System.out.println(max);
		
	}
}
