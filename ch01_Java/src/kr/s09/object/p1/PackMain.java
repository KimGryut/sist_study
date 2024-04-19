package kr.s09.object.p1;

// 매번 패키지 주소 명시하기엔 코드가 너무 길어짐
// 호출하고자 하는 클래스의 패키지 등록
// import kr.s09.object.p2.PackTwo;

public class PackMain {
	public static void main(String[] args) {
		 
		// 같은 패키지 
		//>> PackOne p1 = new PackOne();
		
		
		// 다른 패키지일 때는 패키지 주소 명시
		// kr.s09.object.p2.PackTwo p2 = new kr.s09.object.p2.PackTwo();
		
		// 패키지 등록 후
		// import문을 이용하여 호출하고자 하는 클래스의 패키지를 등록했기 때문에
		// 클래스명만 기재해도 호출 가능
		
		//>> PackTwo p2 = new PackTwo();
		
		
		
	}
}
