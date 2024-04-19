package kr.s24.object.enumtest;

enum Gender {
	MALE, FEMALE; // 메서드가 없는 경우 세미콜론 생략 가능, 있다면 세미콜론 필수
	
	@Override
	public String toString() {
		switch(this) {
		case MALE :
			return "남자";
		default : 
			return "여자";
		}
	}
}



public class EnumMain03 {
	public static void main(String[] args) {
		System.out.println(Gender.MALE);
		System.out.println(Gender.FEMALE);
		
		System.out.println("---------------");
		
		System.out.println(Gender.MALE.toString());
		System.out.println(Gender.FEMALE.toString());
		
		System.out.println("---------------");
	}

}
