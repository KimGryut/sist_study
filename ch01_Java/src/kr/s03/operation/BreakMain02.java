package kr.s03.operation;

public class BreakMain02 {
	public static void main(String[] args) {
		// 다중 반복문에서 break 사용하기
		for(int i=0; i<3;i++) {
			for(int j=0; j<5; j++) {
				if (j==3) break; // 특정 조건일 때 전체 반복문을 빠져나가는 게 아니라 
								 // 브레이크 포함되어 있는 반복문만 빠져나감
				System.out.println(i + "," + j);
			}
		} 

		System.out.println("");

		// 다중 반복문에서 break를 이용하여 전체 반복문 빠져나가기
		exit_for: // break label 지정
			for(int i=0; i<3;i++) {
				for(int j=0; j<5; j++) {
					if (j==3) break exit_for; // exit_for라는 반복문 전체 break
					System.out.println(i + "," + j);
				}
			}
	}
}