package kr.s11.object.constructor;

class Student {
	// 과목
	int korean;
	int english;
	int math;
	int history;
	int science;
	
	// 과목수
	int num;
	
	public Student(int k, int e, int m) {
		korean = k;
		english = e;
		math = m;
		num = 3; // 과목수 지정
	}
	
	public Student(int k, int e, int m, int h, int s) {
		korean = k;
		english = e;
		math = m;
		history = h;
		science = s;
		num = 5; // 과목수 지정
	}
	
	// 생성자 오버로딩
	public int getTotal() {
		int total;
		if(num == 3) {
			total = korean + english + math;
		} else {
			total = korean + english + math + history + science;
		}
		return total;
	}
	
	public int getAvg() {
		return getTotal()/num;
	}
	
}

public class StudentMain {
	public static void main(String[] args) {
		// 3과목 시험 보기
		Student s1 = new Student(90,97,95);
		System.out.println("합계 : " + s1.getTotal());
		System.out.println("평균 : " + s1.getAvg());
		
		// 5과목 시험 보기
		Student s2 = new Student(88, 82, 84, 87, 90);
		System.out.println("합계 : " + s2.getTotal());
		System.out.println("평균 : " + s2.getAvg());
	}

}
