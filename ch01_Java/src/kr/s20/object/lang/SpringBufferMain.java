package kr.s20.object.lang;
// 가공을 많이 해야 하는 경우 스트링 버퍼 이용
// 쓰레기 객체를 줄여줌

public class SpringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("여름 덥다...");
		System.out.println("1: " + sb);
		
		// 지정한 위치에 낑겨넣기
		sb.insert(2, '이'); // 인덱스 2번 자리 (여름O덥다... < 여기선 O에 해당. 여기에다가 '이'를 삽입)
		System.out.println("2: " + sb);
		
		// 문자열 끝에다가 문자 붙이기
		sb.append(" 가을은 ");
		System.out.println("3: " + sb);
		
		sb.append("시원하다!");
		System.out.println("4: " + sb);
			
		// 시작 인덱스(포함)부터 끝 인덱스(포함x) 전까지 문자열 대체
		sb.replace(0, 3, "여행가자!!");
		System.out.println("5: " + sb);
		
		// 지정한 인덱스의 문자를 삭제
		sb.deleteCharAt(0);
		System.out.println("6: " + sb);
		
		// 시작 인덱스부터 끝 인덱스 전까지 문자열 삭제
		sb.delete(0, 3);
		System.out.println("7: " + sb);
		
		
		// StringBuffer -> String 변환
		// 부모자식 관계가 아닌 경우 변환하는 건 형변환이 아니라 그냥 변환. (파싱)
		String str = sb.toString();
		System.out.println("str = " + str);
		
	}
}
