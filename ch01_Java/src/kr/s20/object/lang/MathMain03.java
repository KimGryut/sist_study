package kr.s20.object.lang;

/*
 * [실습]
 * 가위바위보 게임 
 * 
 * 
 * [입력 예시]
 * 가위바위보 입력(0. 가위 1. 바위 2. 보) : 1
 * 
 * [출력 예시]
 * 컴퓨터 : 가위
 * 사용자 : 바위
 * 
 * 이겼습니다.
 * 
 */

import java.util.Scanner;
// import java.util.Random;

public class MathMain03 {
	public static void main(String[] args) {
		
		/*
		String[] item = {"가위", "바위", "보"}; // 결과 보여줄 가위바위보
		Scanner input = new Scanner(System.in);
		
		while(true) { // 종료하지 않는 이상 게임 계속 실행
			System.out.println("---------------------");
			System.out.println("메뉴> 1.게임하기  2.종료하기");
			System.out.println("---------------------");
			System.out.print("선택> ");
			int num = input.nextInt();
			
			if (num==1) {
				
				System.out.println("0.가위 1.바위 2.보");
				System.out.print("입력> ");
				int user = input.nextInt(); // 유저의 가위바위보
				
				
				Random ran = new Random(); // 난수 생성
				int com = ran.nextInt(3); // 0부터 2까지의 정수 랜덤
				
				
				// 내가 짠 코드 : 잘못된 조건
				if(user == com) { // 무승부
					System.out.println("유저 " + user+ "." +item[user] + " vs " + "컴퓨터 " + com + "." + item[com] + " 무승부입니다.");
				} else if ((com-user)>=1) { // 가위바위보에서 오른쪽에 있는 게 무조건 이기므로, 숫자를 뺐을 때 양수가 나오면 승리
					System.out.println("유저 " + user+ "." +item[user] + " vs " + "컴퓨터 " + com + "." + item[com] + " 컴퓨터의 승리입니다.");
				} else { // 반대의 경우 빼진 쪽의 승리
					System.out.println("유저 " + user+ "." +item[user] + " vs " + "컴퓨터 " + com + "." + item[com] + " 유저의 승리입니다.");
				}
				
			} else if(num==2) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}	
			
		}
		input.close();	
		
		
		*/
		
		String[] item = {"가위", "바위", "보"}; // 결과 보여줄 가위바위보
		Scanner input = new Scanner(System.in);
		
		while(true) { // 종료하지 않는 이상 게임 계속 실행
			System.out.println("---------------------");
			System.out.println("메뉴> 1.게임하기  2.종료하기");
			System.out.println("---------------------");
			System.out.print("선택> ");
			int num = input.nextInt();
			
			if (num==1) {
				
				System.out.println("0.가위 1.바위 2.보");
				System.out.print("입력> ");
				int user = input.nextInt(); // 유저의 가위바위보
				
				
				if (user<0 || user > 2) {
					System.out.println("잘못 입력했습니다.");
					continue;
				}
				
				int computer = (int)(Math.random()*3); // 0~2 
				
				/*
				 * 컴퓨터-사용자=결과
				 *  0	0	0	무
				 *  0	1	-1	사용자 승
				 *  0	2	-2	컴퓨터 승
				 *  1	0	1	컴퓨터 승
				 *  1	1	0	무
				 *  1	2	-1	사용자 승
				 *  2	0	2 	사용자 승
				 *  2	1	1	컴퓨터 승	
				 *  2	2	0	0
				 *   
				 */
				
				int result = computer - user;
				
				System.out.println(
						"-> 컴퓨터: " + item[computer] +
						"-> 사람: " + item[user]);
				
				System.out.print("결과: ");
				if (result==-1 || result == 2) {
					System.out.println("사용자 승");
				} else if(result==1 || result==-2) {
					System.out.println("컴퓨터 승");
				} else {
					System.out.println("무승부");
				}
				
				
			} else if(num==2) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}	
			
		}
		
		input.close();	
		
	}
}
