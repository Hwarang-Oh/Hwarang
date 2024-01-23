package com.ssafy.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortBasicTest {
	
	static class NameComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) { // + 0 - 
			// TODO Auto-generated method stub
			return -o1.compareTo(o2); // or Compareto 반대로 !
		}
		
	}

	public static void main(String[] args) {
		int [] arr = new int[] {4,3,7,9,10,7};
		System.out.println("정렬 전 : " + Arrays.toString(arr));
//		Arrays.sort(arr, Comparator.reverseOrder()); 어떻게 해야하나?
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
		
		String [] names = {"소수빈","김재환","박보검"};
		System.out.println("정렬 전 : " + Arrays.toString(names));
//		Arrays.sort(names);
		// 내림차순 정렬
//		Arrays.sort(names, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) { // + 0 - 
//				// TODO Auto-generated method stub
//				return -o1.compareTo(o2);} // or Compareto 반대로 !
//			});
		
//		Arrays.sort(names,(o1, o2) -> -o1.compareTo(o2));
		Arrays.sort(names, Comparator.reverseOrder()); // 원소들이 Comparable한 경우에만 가능함. 
		System.out.println("정렬 후 : " + Arrays.toString(names));
		
		int [] arr2[] = {
				{1,10}, {3,50}, {2,88}, {4,10},{1,100}
		};// 1차원: 배열(0) : 번호, 배열(1) : 점수
		// 위의 배열로 정렬하자 ( 번호 기준 오름차순, 점수기준 내림차순 )
		System.out.println("정렬 전 : " + Arrays.deepToString(arr2));
//		Arrays.sort(arr2, new Comparator<int[]>()  {
//
//			@Override
//			public int compare(int[] o1, int[] o2) { // o1[0] - o2[0] OverFlow, UnderFlow 방지  => 두 부호가 같다면 ㄱㅊ 
////				int diff = o1[0] - o2[0];
//				int diff = Integer.compare(o1[0], o2[0]); // 오름차순 
//				return diff !=0? diff: Integer.compare(o2[1], o1[1]); // 내림차순
//			}
//		});
		
		Arrays.sort(arr2, // lambda -> 추상메서드가 한 개인 functional Interface -> 추상메서드 1개
			(o1, o2) -> { // o1[0] - o2[0] OverFlow, UnderFlow 방지  => 두 부호가 같다면 ㄱㅊ 
//				int diff = o1[0] - o2[0];
				int diff = Integer.compare(o1[0], o2[0]); // 오름차순 
				return diff !=0? diff: Integer.compare(o2[1], o1[1]); // 내림차순
			}
		);
		
		System.out.println("정렬 후 : " + Arrays.deepToString(arr2));
		Student students[] = {
				new Student(1,10), new Student(3,50), new Student(2,88), new Student(4,10), new Student(1,100)
		};
		System.out.println(Arrays.toString(students));
		Arrays.sort(students);
		System.out.println(Arrays.toString(students)); // Stable 정렬의 의미 (1번 10점 1번 100점 순서 )
	}
	// 

}
