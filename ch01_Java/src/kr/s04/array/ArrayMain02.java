package kr.s04.array;

public class ArrayMain02 {
	public static void main(String[] args) {
		// 정수형 배열 선언 및 생성
		// 배열은 기본값으로 무언가가 들어가 있음 
		// 정수형 배열의 경우 '0'
		int[] array = new int[5];
		
		// 아무것도 넣지 않았는데 전부 0이 들어가 있음을 확인
		for(int i = 0; i<5; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("-----------------");
		
		
		// 배열 요소 변경
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		// 원래 없던 곳에 요소 추가
		// 컴파일은 되지만 실행 시 오류 발생
		// array[5] = 60;
		
		for(int i = 0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
