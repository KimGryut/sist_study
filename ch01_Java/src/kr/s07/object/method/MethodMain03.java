package kr.s07.object.method;

public class MethodMain03 {
	/*
	 * 실습
	 * 배열의 요소 수를 입력 받아서 배열 x를 생성
	 * 입력 받은 정수를 배열 x에 저장하고
	 * 배열 x가 가진 모든 요소의 합을 구하는 sumOf(int[] a) 메서드 정의
	 * 
	 * 입력 예시 
	 * 요소 수 : 3
	 * x[0] : 1
	 * x[1] : 2
	 * x[2] : 3 
	 * 
	 * 출력 예시
	 * sumOf - > 6
	 * 
	 */
	
	// 메서드 생성
	public int sumOf(int[] a) {
		int sum = 0 ;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// 요소 수 정하기
		System.out.print("요소 수 : ");
		int len = input.nextInt();
		
		// 배열 생성
		int[] array = new int[len];
		
		// 배열 데이터 입력 받기
		for (int i=0; i<len; i++) {
			System.out.print("array[" + i + "]: ");
			array[i] = input.nextInt();
		}
		
		// 객체 생성
		MethodMain03 practice = new MethodMain03();
		
		// 메서드 실행
		int result = practice.sumOf(array);
		
		System.out.println("배열 요소의 합: " + result);
		
		
		input.close();
		
		
		
	}
}
