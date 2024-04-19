package kr.s07.object.method;

public class MethodMain04 {
	/*
	 * 실습
	 * 배열 요소 수 (사람 수)를 입력 받아서 배열 weight 생성
	 * 입력 받은 정수를 배열 weight에 저장하고 배열이 가진
	 * 모든 요소의 수 중 최솟값을 구하는 minOf 메서드를 작성하시오
	 */
	
		// 메서드 생성
		public int minOf(int[] a) {
			int min=0;
			for(int i=0; i<a.length-1; i++) { // +1해서 볼 거니까 길이는 -1만큼
				if(a[i]<a[i+1]) {
					min = a[i];
				} else {
					min = a[i+1];
				}
			}
			return min;
		}
		
		// 메서드 반환은 오로지 하나의 값만 가능
	
		public static void main(String[] args) {
			java.util.Scanner input = new java.util.Scanner(System.in);
			
			// 사람 수 입력
			System.out.print("사람 수 : ");
			int num = input.nextInt();
			
			// 몸무게 배열 생성
			int[] weight = new int[num];
			
			// 배열 데이터 입력
			for (int i=0; i<num; i++) {
				System.out.println((i+1) + "번의 몸무게 : ");
				weight[i] = input.nextInt();
			}
			
			// 객체 생성
			MethodMain04 people = new MethodMain04();
			
			// 메서드 실행
			int result = people.minOf(weight);
			
			System.out.println("몸무게 가장 적은 사람: " + result);
			
			input.close();
		}
}
