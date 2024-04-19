package kr.s27.collection;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProductMain {
	// 모든 생성자, 메서드에서 사용하기 위한 호출
	ArrayList<Product> list;
	BufferedReader br;
	
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(br!=null) try {br.close();}catch(IOException e) {}
		}
	}
	
	// 메뉴호출
	public void callMenu() throws IOException{
		while(true) {
			System.out.println("1.상품입력  2.상품목록 보기  3.종료");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num==1) {
					input();
				} else if (num==2) {
					output();
				} else {
					System.out.println("잘못 입력했습니다.");
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자만 허용!");
			}
		}
	}
	
	// 상품 정보 입력
	public void input() throws IOException{
		Product p = new Product();
		System.out.println("상품명: ");
		p.setName(br.readLine()); // String 반환
		System.out.println("상품번호: ");
		p.setNum(br.readLine());
		System.out.println("가격: ");
		p.setPrice(Integer.parseInt(br.readLine()));
		System.out.println("제조사: ");
		p.setMaker(br.readLine());
		System.out.println("재고: ");
		p.setStock(Integer.parseInt(br.readLine()));
		
		// Product를 ArrayList에 저장
		list.add(p);
		System.out.println("상품 정보 한 건이 추가되었습니다.");
	}
	
	// 상품 정보 출력
	public void output() {
		System.out.println("상품리스트: 총상품수(" +list.size()+ ")");
		System.out.println("상품명\t상품번호\t가격\t제조사\t재고수");
		System.out.println("------------------------------------");
		// 반복문을 이용한 요소의 출력
		/*
		for (int i=0; i<list.size(); i++) {
			Product pt = list.get(i);
			System.out.printf("%s\t", pt.getName());
			System.out.printf("%s\t", pt.getNum());
			System.out.printf("%,d\t", pt.getPrice());
			System.out.printf("%s\t", pt.getMaker());
			System.out.printf("%d\t%n", pt.getStock());
		}
		*/
		// 확장 for문을 이용한 요소의 출력
		// 인덱스 명시하지 않는 경우 절약되고 좋은 코드
		for(Product pt: list) {
			System.out.printf("%s\t%s\t%d\t%s\t%d%n", 
					pt.getName(), pt.getNum(), pt.getPrice(),pt.getMaker(), pt.getStock());
		}
	}
	
	public static void main(String[] args) {
		new ProductMain();
	}
}
