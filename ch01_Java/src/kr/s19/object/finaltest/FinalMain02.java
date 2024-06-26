package kr.s19.object.finaltest;

// 
class Me{
	int var = 100;
	// 메서드에 final 지하면 자식 클래스에서 메서드 오버라이딩이 불가
	// final의 의미 : 변경하지 말고 그대로 써라
	public final void setVar(int var) {
		this.var = var;
	}
}

public class FinalMain02 extends Me {
	public static void main(String[] args) {
// 		public void setVar(int var) {} < 불가능
		/*
		 * 부모 클래스의 final 메서드는 재정의 불가
		 */
		
		FinalMain02 fm = new FinalMain02();
		fm.setVar(200);
		System.out.println(fm.var);
		
	}
}
