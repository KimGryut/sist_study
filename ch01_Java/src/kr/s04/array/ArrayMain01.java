package kr.s04.array;

public class ArrayMain01 {
	public static void main(String[] args) {
		// 배열 선언 // char[] < 배열의 자료형
		char[] ch;
		
		// 배열 생성    배열의 길이
		ch = new char[4];
		
		// 배열 초기화
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';		
		
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		System.out.println(ch[2]);
		System.out.println(ch[3]);
		
		System.out.println("");
		
		// 반복문을 이용한 배열의 요소 출력
		// i<4 <<< 4는 배열의 길이
		for(int i=0; i<4; i++) {
			System.out.println("ch[" + i + "] :" + ch[i]);
		}
		
		// if 배열의 길이를 모른다면? 
		// 배열이름.length < 길이가 나옴
		
		
		// 배열의 선언 및 생성 (동시에)
		int[] it = new int[6];
		System.out.println(it[0]);
		
		// 배열의 선언 및 생성(명시적 배열 생성), 초기화 (동시에)
		// 뒤에다 명시를 할 경우 길이는 적지 않아야 함
		char[] ch2 = new char[] {'J', 'a', 'v', 'a'};
		
		System.out.println(ch2[0]);
		
		// 배열의 선언 및 생성(암시적 배열 생성), 초기화 (동시에)
		// new char 안 씀. 명시적의 축약형
		char[] ch3 = {'자', '바'};
		System.out.println(ch3[0]);
		
		
		
	}
}
