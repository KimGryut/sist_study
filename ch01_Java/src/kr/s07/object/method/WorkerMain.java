package kr.s07.object.method;


/*
 * 실습
 * Worker
 * 1) 멤버 변수 - 직원 이름(name), 급여(money), 계좌 잔고(balance)
 * 2) 멤버 메소드 - work(실행하면 money에 1000원 누적)
 * 			  - deposit(실행하면 money의 돈을 balance에 누적 후 money 0) 	
 * 
 * WorkMain
 * 1) Worker 객체 생성
 * 2) 직원 이름 입력
 * 3) 10번 일하기 -> 번 돈 3000원 일 때마다 계좌에 저축
 * 4) 직원 이름, 현재 계좌 잔고에 입금되지 않고 남아 있는 급여, 계좌 잔고 출력
 */
class Worker{
	// 멤버 변수
	String name;
	int money;
	int balance;
	
	// 급여 누적 메소드
	public void work() {
		money += 1000;
	}
	
	// 급여 입금 메소드
	public void deposit() {
		balance += money;
		money = 0;
	}
}

public class WorkerMain {
	public static void main(String[] args) {
		Worker worker = new Worker(); //객체 생성		
		
		worker.name = "홍길동"; // 이름 
		
		// 10번 일하기
		for (int i=0; i<10; i++) {
			worker.work();
			// 누적된 급여가 3000원일 때 계좌에 입금하기
			if (worker.money>=3000) {
				worker.deposit();
			}
		}
		
		System.out.println("직원 이름: " + worker.name);
		System.out.println("입금되지 않은 급여: " + worker.money);
		System.out.println("현재 잔고: " + worker.balance);
	}
	
			
}
