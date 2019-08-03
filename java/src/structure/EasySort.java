package structure;

import java.util.Arrays;

/*
 * Bubble Sort
 * Insertion Sort
 * Selection Sort
 * 	=> 시간 복잡도 : O(n^2)
 * : 구현이 간단하지만 느리다.
 */

public class EasySort {

	private static int[] arr = {29, 10, 14, 37, 13};
	
	public static void main(String[] args) {
		
		printArray(selectionSort(arr, arr.length));
		System.out.println(Arrays.toString(arr));
		//printArray(insertionSort(arr, arr.length));
		//printArray(bubbleSort(arr, arr.length));
		
	}
	
	/*
	 * Selection Sort
	 * - 각 루프마다
	 * 		최소 원소를 찾는다
	 * 		최소 원소와 맨 왼쪽 원소를 교환한다
	 * 		맨 왼쪽 원소를 제외한다
	 * - 하나의 원소만 남을 때 까지 위의 루프를 반복
	 */
	 static int[] selectionSort(int[]arr, int n) {
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j= i+1; j<n; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			swap(arr, min, i);
			System.out.println((i+1) + "회전 selection sort result : " + Arrays.toString(arr));
		}
		return arr;
	}
	
	 /* Insertion Sort
	  * - 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입함.
	  * - 배열의 두 번째 데이터 부터 연산을 시작함
	  */
	static int[] insertionSort(int[]arr, int n) {
		int size = arr.length;
        int temp = 0;
        int j = 0;
        for(int i = 1; i < size; i++){
            temp = arr[i];
            for(j=i-1; j>=0 && temp<arr[j]; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
            System.out.println(i + "회전 insertion sort result : " + Arrays.toString(arr));
        }
		return arr;
	}

	/*
	 * Bubble Sort
	 * - 자기자신 뒤에 오는 요소와 끊임없이 비교하면서, 오름차순일 경우 가장 큰 수가 뒤에서부터 정렬
	 */
	static int[] bubbleSort(int[]arr, int n) {
		for(int i=n-1; i>0; i--) {
			for(int j= 0; j<i; j++) {
				if(arr[j] > arr[j+1])
					swap(arr, j, j+1);
			}
			System.out.println((n-i) + "회전 bubble sort result : " + Arrays.toString(arr));
		}
		return arr;
	}

	static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	static void printArray(int[]arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	
}
