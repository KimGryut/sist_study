import java.util.Scanner;

public class SeqSearch {
	// 요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
	// 요솟수 n : 배열의 길이
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		while(true) {
			if(i==n)
				return -1; // 검색 실패(-1 반환)
			if(a[i]==key)
				return i;
			i++;			
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = in.nextInt();
		int[] x = new int[num]; // 요솟수가 num인 배열 생성
		
		for(int i=0; i<num; i++) {  // 배열 초기화
			System.out.print("x[" + i + "]: ");
			x[i] = in.nextInt();
		}
		
		System.out.print("검색할 값: ");  // 키 값 입력
		int key = in.nextInt();
		
		int idx = seqSearch(x, num, key);
		if(idx==-1) {
			System.out.println("검색할 요소가 없습니다.");
		} else {
			System.out.println("x[" + idx +"] 에 있습니다.");
		}
		
		in.close();
	}
}
