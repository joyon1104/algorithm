package structure;

import java.util.*;
/*
 *	Array (배열)
 *	- 크기가 한번 정해지면 변경이 불가능.
 *	- 특정 원소를 삭제하여도 크기가 변하지 않음.
 *	- 배열 초기화 시 메모리에 할당되어 ArrayList보다 속도가 빠르다.
 *	- 기능이 별로 없음.
 */	

public class array {
	
	public static void main(String[] args) {
		
		//배열 정의
		int[] array = new int[3];
		
		//배열 정의 + 저장
		int[] array2 = {1,2,3,4};
		
		//배열 저장
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		
		//배열 출력
		for(int i=0; i<array.length;i++) {
		    System.out.println(array[i]);
		}
		
		//배열을 모두 같은 값으로 초기화 
		Arrays.fill(array, 1);	//array의 모든 값을 1로 초기화 
		
		
		//배열 출력
		for(int i=0; i<array.length;i++) {
		    System.out.println(array[i]);
		}
	}
}
