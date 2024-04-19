package kr.s07.object.method;

// 부 클래스
class Tv {
	// 멤버 필드(속성)
	boolean power; // 전원상태(on/off) false가 기본
	int channel; // 채널
	
	// 멤버 메서드(동작)
	public void isPower() { // Tv on/off 기능
		power = !power;
	}
	public void channelUp() { // 채널 올리기
		++channel; 
		
	}
	public void channeldown() { // 채널 내리기
		--channel;
	}
}

// 주 클래스
public class TvMain {	
	public static void main(String[] args) {
		Tv t = new Tv();
		t.isPower(); // false -> true
		System.out.println("TV 실행 여부: " + t.power);
		System.out.println("현재 채널: " + t.channel);
		
		System.out.println("------------------");
		
		t.channel = 7; // 채널 바꾸기
		System.out.println("첫 번째 변경된 채널: " + t.channel);
		
		System.out.println("------------------");
		
		t.channeldown(); // 채널 내리기
		System.out.println("두 번째 변경된 채널: " + t.channel);
		
		System.out.println("------------------");
		
		t.channelUp(); // 채널 올리기
		t.channelUp(); // 채널 올리기
		System.out.println("세 번째 변경된 채널: " + t.channel);
		
		System.out.println("------------------");
		
		t.isPower(); // TV 전원 끄기
		System.out.println("TV 실행 여부: " + t.power);
		
		
		
	}
}
