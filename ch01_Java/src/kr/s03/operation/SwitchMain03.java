package kr.s03.operation;

public class SwitchMain03 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.print("성적 입력: ");
		score = input.nextInt();
		
		if (score<0 || score>100) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			System.exit(0);
		} 
		
		switch(score/10) { // 케이스를 줄이기 위해 연산
	/*	case 10 || 9 : 
			grade = 'A';
			break; 어차피 실행 안 하고 9로 넘어오자마자 브레이크 될 거기 때문에 없애도 됨*/
		case 9 :
			grade = 'A';
			break;
		case 8 :
			grade = 'B';
			break;
		case 7 :
			grade = 'C';
			break;
		case 6 :
			grade = 'D';
			break;
		default :
			grade = 'F';
			break;
		}
		
		System.out.println(" ");
		System.out.println("점수 : " + score);
		System.out.println("성적 : " + grade);
		
		input.close();
	}
}
