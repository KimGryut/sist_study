package kr.s24.object.enumtest;

enum Item {
	ADD, DEL, SEARCH, CANCEL
	
	
	
}

public class EnumMain04 {
	public static void main(String[] args) {
		// values() 메서드는 열거 타입의 모든 열거 객체들을 배열로 만들어 반환
		Item[] items = Item.values();
		for (Item n : items) {
			System.out.println(n);
		}
		
		
	}
}
