import java.util.Scanner;
public class practice04 {
	
	//왼쪽 아래가 직각인 삼각형
	static void triangleLB(int n) {
		for(int i=1; i<=n; i++) {
			// int j=0; j<i; j++ 무방
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//왼쪽 위가 직각인 삼각형
	static void triangleLU(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=n; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 왼쪽 위가 직각인 삼각형2
	static void triangleLU2(int n) {
		for(int i=n; i>=1; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	//오른쪽 위가 직각인 삼각형
	static void triangleRU(int n) {
		for(int i=0; i<n; i++) {
			for(int k=1; k<=i; k++) {
				System.out.print(" ");
			}
			for(int j=n; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	// 오른쪽 위가 직각인 삼각형2
	static void triangleRU2(int n) {
		for(int i=0; i<n; i++) {
			for(int k=0; k<i; k++) {
				System.out.print(" ");
			}
			for(int j=0; j<n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	//오른쪽 아래가 직각인 삼각형
	static void triangleRB(int n) {
		for(int i=1; i<=n; i++) {
			for(int k=n; k>i; k--) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 오른쪽 아래가 직각인 삼각형2
	static void triangleRB2(int n) {
		for(int i=1; i<=n; i++) {
			for(int k=0; k<n-i; k++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	
	
	//n단 피라미드 출력
	static void spira(int n) {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n-k; i++) {
				System.out.print(" ");
			}
			for(int j=1; j<=(k*2-1); j++) {
				System.out.print("*");
			}		
			System.out.println("");
		}		
	}
	
	//숫자 n단 피라미드 출력
	static void npira(int n) {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n-k; i++) {
				System.out.print(" ");
			}
			for(int j=1; j<=(k*2-1); j++) {
				System.out.print(k);
			}		
			System.out.println("");
		}	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("몇 단 삼각형 만들겠습니까?");
		int n = in.nextInt();
		System.out.println("--------------------");
		
		System.out.println("왼쪽 아래가 직각인 삼각형");
		triangleLB(n);	
		
		System.out.println("--------------------");
		System.out.println("왼쪽 위가 직각인 삼각형");
		triangleLU(n);
		System.out.println();
		triangleLU2(n);
		
		System.out.println("--------------------");
		System.out.println("오른쪽 위가 직각인 삼각형");
		triangleRU(n);
		System.out.println();
		triangleRU2(n);
		
		System.out.println("--------------------");
		System.out.println("오른쪽 아래가 직각인 삼각형");
		triangleRB(n);
		System.out.println();
		triangleRB2(n);
		
		System.out.println("--------------------");
		System.out.println("n단 피라미드 출력");
		spira(n);
		System.out.println("--------------------");
		System.out.println("숫자 n단 피라미드 출력");
		npira(n);
		
		in.close();		
	}
}
