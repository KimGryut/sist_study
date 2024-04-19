package kr.s05.object.field;

public class Student05 {
	String name;
	int korean;
	int english;
	int math;
	int sum;
	double average;
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Student05 student = new Student05();
		student.name = "류현민";
		student.korean = 60;
		student.english = 30;
		student.math = 24;
		student.sum = student.korean + student.english + student.math;
		
		// 평균 구하기
		student.average = student.sum / 3.0;
		
		System.out.printf("이름: %s%n국어: %d%n영어: %d%n수학: %d%n", student.name, student.korean, student.english, student.math);
		System.out.println("평균: " + student.average);
				
				
			
	}
	
}
