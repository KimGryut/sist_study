package kr.s03.operation;

public class ForMain05 {
	public static void main(String[] args) {
		// 2~9단까지 출력하기 위해 다중for문 사용
		
		for(int dan=2; dan<=9; dan++) {
			System.out.println("===" + dan +"단===");
			for (int i=1; i<=9;i++) {
				System.out.println(dan + "*" + i + "=" + dan*i);	
			}
		}
	}
}
