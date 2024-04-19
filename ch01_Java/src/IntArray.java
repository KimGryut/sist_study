
import java.util.Scanner;



public class IntArray {
	

	// 배열 b의 모든 요소 배열 a에 복사하는 메서드
	static void copy(int[] a, int[] b) {
		for (int i=0; i<b.length; i++) {
			a[i]=b[i];
		}
	}
	
	// 배열 b의 모든 요소를 배열 a에 역순으로 저장 
	static void rcopy(int[] a, int[] b) {
		for (int i=0; i<b.length; i++) {
			a[i]=b[b.length-i-1];
		}
	}

	// 만약 각각 따로 길이 따로 요소 따로인 배열이었다면?
	// 일단, 자바의 배열은 길이 변경이 불가능
	static void copy2(int[] a, int[] b) {
		if (a.length>=b.length) {
			for (int i=0; i<b.length; i++) {
				a[i]=b[i];
			}
		} else {
			System.out.println("배열 a의 길이가 배열 b보다 짧아서 복제가 불가합니다.");
		}
	}
	

	// 배열 요소 합
	static int sumOf(int[] a) {
		int sum=0;
		for(int i=0; i<a.length; i++){
			sum += a[i];
		}		
		return sum;
	}

	// 배열 역순 
	static void change(int[] a, int id1, int id2) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int x = a[id1];
		a[id1]=a[id2];
		a[id2]=x;
		System.out.println("a[" + id1 + "]와 a[" + id2 + "]를 교환합니다.");
		System.out.println();
	}

	// 배열 역순 
	static void reverse(int[] a) {
		for(int i=0; i<=a.length/2; i++) {
			change(a, i, a.length-i-1);
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("요솟수: ");
		
		int num = in.nextInt();
		
		int[] a = new int[num];
		int[] b = new int[num];

		for(int i=0; i<b.length; i++) {
			System.out.print("b[" + i + "]: ");
			b[i] = in.nextInt();
		}

		// reverse(a);

		//System.out.println("합계 : " + sumOf(a));

		rcopy(a, b);
		in.close();
		
		// 향상된 for 루프를 이용한 배열 요소 출력
		System.out.println("a 배열");
		for(int number : a) {
			System.out.print(number + " ");
		}
		System.out.println("\nb 배열");
		for(int number : b) {
			System.out.print(number + " ");
		}
	}

}
