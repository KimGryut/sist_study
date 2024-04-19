package kr.s03.operation;

public class IfMain04 {
	public static void main (String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int score;
		char grade;
		
		System.out.print("성적을 입력하세요: ");
		score = input.nextInt();
		
		if (score<0 || score>100) {
			grade = '?';
		} else if (score>=90) {
			grade = 'A';
		} else if (score>=80) {
			grade = 'B';
		} else if (score>=70) {
			grade = 'C';
		} else if (score>=60) {
			grade = 'D';
		} else{
			grade = 'F';
		} 
		
		System.out.println("성적 : " + score);
		System.out.printf("등급 : %c%n",grade);
		
		input.close();
	}
}
