package kr.s27.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// 로또 만들기 

public class HashSetMain02 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while (hs.size()<6) { // 사이즈가 6개가 되면 빠져나와라
						
			Integer ir = (int)(Math.random()*45)+1;
			// 중복값을 허용하지 않음
			hs.add(ir);
		}
		// HashSet -> Set -> Collection => List
		List<Integer> list = new ArrayList<Integer>(hs);
		Collections.sort(list);
		System.out.print("로또 번호 : ");
		for (int n : list) {
			System.out.print(n + "  ");
		}
	}
}
