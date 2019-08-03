package structure;

import java.util.Arrays;

/*
 * Quick Sort
 * - 정해진 배열이 주어짐. 마지막 수를 pivot으로 삼는다.
 * - pivot보다 작은 수는 pivot의 왼쪽에 나머지는 pivot의 오른쪽에 오도록 재배치한다.
 * - pivot의 왼쪽과 오른쪽을 각각 순환적으로 정렬한다. 
 * 
 * < 시간복잡도 >
 * 	- 최악의 경우 : O(n^2)	  <- 항상 한쪽은 0, 다른쪽은 n-1개로 분할되는 경우, 이미 정렬된 입력데이터 
 * 	- 최선의 경우 : O(nlogn) <- 항상 절반으로 분할되는 경우 
 */

public class QuickSort {

	private static char[] arr = {'A', 'L', 'G', 'O', 'R', 'I', 'T', 'H', 'M', 'S'};
	
	public static void main(String[] args) {
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//A[p,..r]을 정렬
	static void quickSort(char[] arr, int p, int r) {
		if(p<r) {
			int q = partition(arr, p, r);	// 분할 
			quickSort(arr, p, q-1);			// 왼쪽 부분배열 정렬 (pivot기준 왼쪽)
			quickSort(arr, q+1, r);			// 오른쪽 부분배열 정렬 (pivot기준 오른쪽)
		}
	}
	
	//배열 A[p,..r]의 원소들을 A[r]을 기준으로 양쪽으로 재배치하고 A[r]이 자리한 위치를 return (pivot return)
	static int partition(char[] arr, int p, int r) {
		char x = arr[r];	//마지막 데이터를 pivot으로 선택
		int i = p-1;
		
		for(int j=p; j<=r-1; j++) {
			if(arr[j] <= x) {	//피벗보다 작을 때 (피벗보다 크면 아무것도 하지 않고 j만 1증가) 
				i = i+1;	// i : 피벗보다 작은값 중 가장 마지막 값의 인덱스 
				char tmp = arr[i];	//arr[i]와 arr[j]를 바꿈 
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		//작은값들 중 가장 마지막 인덱스 i에서 1을 더하면 큰 값들 중 첫번째 값이 됨. 
		char tmp = arr[i+1];	
		arr[i+1] = x;
		arr[r] = tmp;	// arr[i+1] 과 피벗의 위치를 바꿔줌. 
		
		return i+1;		// 바뀐 피벗의 인덱스 값을 return
	}
}
