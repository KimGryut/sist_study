package kr.s17.object.overriding;



public class MinusAccount extends BankAccount {
	/*
	 * [실습]
	 * 1. 한도를 의미하는 minusLimit 멤버변수 정의
	 * 2. BankAccount를 상속 받는다.
	 * 3. 생성자에서 number, password, name, balance, minusLimit를 전달 받아서 멤버변수에 저장
	 * 4. 재정의 withdraw, printAccount 메서드 재정의 
	 * 5. BankMain2에서 호출
	 */
	
	
	/*
	protected long minusLimit;
	
	

	// 생성자
	public MinusAccount(String number, String password, String name, long balance, long minusLimit) {
		// 멤버변수 = 지역변수
		super(number, password, name, balance); // 부모에게서 상속받기
		this.number = number;
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.minusLimit = minusLimit;
		System.out.println(number + " 계좌가 개설되었습니다.");
	}
		
	// 출금하기 (재정의)
	public void withdraw(long amount) {
		if(amount<=0) {
			System.out.println("0 이하의 금액은 입금할 수 없습니다.");
			return;
		}
		if ((-minusLimit)>(balance-amount)) { // 마이너스 한도보다 낮아지면 안 됨
			System.out.println("한도 초과입니다.");
			return;
		}
		balance -= amount;
		System.out.printf("%,d원이 출금되었습니다. %n", amount);
	}

	// 계좌정보 출력하기 (재정의)
	public void printAccount() {
		System.out.println("--------------------");
		System.out.println("(마이너스계좌)계좌번호: " + number);
		System.out.println("비밀번호: " + password);
		System.out.println("예금주: " + name);
		System.out.println("한도: " + minusLimit);
		System.out.printf("계좌잔액: %,d원%n", balance);
		System.out.println("--------------------");
	}
	
	*/
	
	
	private long minusLimit;
	
	public MinusAccount(String number, String password, String name, long balance, long minusLimit) {
		super(number, password, name, balance);
		this.minusLimit = minusLimit;
	}
	
	// 출금하기 (재정의)
	@Override
	public void withdraw (long amount) {
		if(amount<=0) {
			System.out.println("0 이하의 금액은 입금할 수 없습니다.");
			return;
		}
		if(balance + minusLimit < amount) { // 마이너스 한도를 넘기면 안 됨
			System.out.println("한도 초과로 출금되지 않습니다.");
			return;
		}
		balance -= amount;
		System.out.printf("%,d원이 출금되었습니다. %n", amount);
	}
	
	
	// 계좌정보 출력하기 (재정의)
	@Override
	public void printAccount() {
		System.out.println("--------------------");
		System.out.println("(마이너스계좌)계좌번호: " + number); // 마이너스 계좌임을 명시
		System.out.println("비밀번호: " + password);
		System.out.println("예금주: " + name);
		System.out.printf("계좌잔액: %,d원%n", balance);
		System.out.printf("한도: %,d원%n", minusLimit); // 마이너스 한도 표시
		System.out.println("--------------------");
		
	}
	
	
}
