package kr.s27.collection;

public class Score {
	private String name;
	private int korean;
	private int english;
	private int math;
	// 실습

	public Score(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public Score() {}

	// 총점 구하기(makeSum -> int)
	public int makeSum() {
		return korean + english + math;
	}

	// 평균 구하기 (makeAvg -> double)
	public double makeAvg() {
		return makeSum()/3.0;
	}

	// 등급 구하기 (makeGrade -> String)
	public String makeGrade() {
		String grade;
		double avg = makeAvg();

	    switch ((int) (avg / 10)) {
		case 10:
		case 9: 
			grade = "A"; break;
		case 8:
			grade = "B"; break;
		case 7:
			grade = "C"; break;
		case 6:
			grade = "D"; break;
		default:
			grade = "F"; break;
			
		}
		return grade;
	}
	
	
	// get set 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}


}
