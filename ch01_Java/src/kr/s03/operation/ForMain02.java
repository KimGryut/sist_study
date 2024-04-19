package kr.s03.operation;

public class ForMain02 {
	public static void main(String[] args) {
		// 초기식;조건식;증감식
		
		for (int i=5; i>=1; i--) {
			System.out.print(i + "\t");
		}
		
		System.out.println("\n-----------");
		
		for (int i =0 ; i<=10; i+=2) { // 2씩 증가
			System.out.print(i + "\t");
		}
		
		System.out.println("\n-----------");
		
		for (int i=0; i<=10; i++) {
			if(i%2==0) {
				System.out.print(i + "\t");
			} else {
				System.out.print(i);
			}
		}

		System.out.println("\n-----------");
		
		
	}
}
