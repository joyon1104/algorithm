package structure;

import java.util.Arrays;

/*
 * Merge Sort
 * - 데이터가 정장된 배열을 절반으로 나눔
 * - 각각 순환적으로 정렬
 * - 정렬된 두 개의 배열을 합쳐 전체를 정렬
 * 	=> 시간복잡도 : O(nlogn)
 * 
 */

public class MergeSort {

	private static char[] arr = {'A', 'L', 'G', 'O', 'R', 'I', 'T', 'H', 'M', 'S'};
	
	public static void main(String[] args) {
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(char[] arr, int p, int r) {
		if(p < r) {
			int q = (p+r)/2;		// p,r의 중간 지점을 계산 
			mergeSort(arr, p, q);	// 전반부 정렬 
			mergeSort(arr, q+1, r);	// 후반부 정렬
			merge(arr, p, q, r);	// 합병
		}
	}
	
	/* 합병 메소드 
	 * - 정렬되어 있는 두 배열 A[p,..,q]와 A[q+1,..,r]을 합하여 정렬된 하나의 배열 A[p,..,r]을 만든다.
	 */
	static void merge(char[] arr, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int k = p;
		char[] tmp = new char[arr.length];
		
		// 두 배열을 비교하여 tmp 배열에 더 작은 값을 넣음.
		while(i<=q && j <=r) {
			if(arr[i] <= arr[j])
				tmp[k++] = arr[i++];	//tmp에 arr[i]의 값을 넣고, k와 i 인덱스 1씩 증가.
			else
				tmp[k++] = arr[j++];	//tmp에 arr[j]의 값을 넣고, k와 i 인덱스 1씩 증가.
		}
		
		//두 배열 중 한 배열이 이미 배열을 끝냈을 때 다음 두 while문이 돈다.
		while(i<=q) 
			tmp[k++] = arr[i++];
		
		while(j<=r) 
			tmp[k++] = arr[j++];
		
		//tmp배열을 arr배열에 넣음.
		for(i= p; i<=r; i++)
			arr[i] = tmp[i];
	}

}
