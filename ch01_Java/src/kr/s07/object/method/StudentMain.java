package kr.s07.object.method;

public class StudentMain {
	// 멤버 필드 (속성)
	String name;
	int korean;
	int english;
	int math;
	
	// 멤버 메서드(동작)
	public int makeSum() {
		return korean+english+math;
	}
	
	public int makeAvg() {
		return makeSum()/3;
	}
	
	// 등급 구하기 메서드
	public String makeGrade() {
		String grade;
		switch(makeAvg()/10) {
		case 10:
		case 9:
			grade = "A"; 
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		return grade;
	}

	// 결과 출력 메서드
	public void printScore() {
		System.out.println("이름: "+ name);
		System.out.println("국어: " + korean);
		System.out.println("영어: " + english);
		System.out.println("수학: " + math);
		System.out.println("총점: " + makeSum());
		System.out.println("평균: " + makeAvg());
		System.out.println("등급: " + makeGrade());
	}
	public static void main(String[] args) {
		// 객체 생성
		StudentMain student = new StudentMain();
		
		student.name = "류연민";
		student.korean = 76;
		student.english = 60;
		student.math = 40;

		System.out.println("이름: "+ student.name);
		System.out.println("국어: " + student.korean);
		System.out.println("영어: " + student.english);
		System.out.println("수학: " + student.math);
		System.out.println("총점: " + student.makeSum());
		System.out.println("평균: " + student.makeAvg());
		System.out.println("등급: " + student.makeGrade());
		System.out.println("====================");
		
		StudentMain student2 = new StudentMain();
		
		student2.name = "류정민";
		student2.korean = 100;
		student2.english = 99;
		student2.math = 95;
		
		System.out.println("이름: "+ student2.name);
		System.out.println("국어: " + student2.korean);
		System.out.println("영어: " + student2.english);
		System.out.println("수학: " + student2.math);
		System.out.println("총점: " + student2.makeSum());
		System.out.println("평균: " + student2.makeAvg());
		System.out.println("등급: " + student2.makeGrade());
		System.out.println("====================");
		
		
		// 메서드를 통한 편한 출력
		student.printScore();
		System.out.println("====================");
		student2.printScore();
	}
}
