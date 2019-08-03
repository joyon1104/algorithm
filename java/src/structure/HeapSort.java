package structure;

/*
 * Heap Sort란?
 * - 이진 힙 (binary heap)을 사용
 * - 추가 배열이 불필요 (merge sort와 비교했을 때 장점!)
 * - 최악의 경우 시간복잡도가 O(n*logn)
 * 
 * < Heap >
 * - complete binary tree이면서
 * - heap property를 만족해야 함.
 * 	 1. max heap property : 부모는 자식보다 크거나 같다.
 * 	 2. min heap property : 부모는 자식보다 작거나 같다.
 * 
 * - heap 은 1차원 배열로 표현 가능 
 * 	 * 루트노드 A[1]
 * 	 * A[i]의 부모 = A[i/2]
 * 	 * A[i]의 왼쪽 자식 = A[2*i]
 *   * A[i]의 오른쪽 자식 = A[2*i+1]
 * 	 
 * < Heap Sort >
 *  1. 주어진 데이터로 heap을 만든다.
 *  2. heap에서 최대값(루트)를 가장 마지막 값과 바꾼다.
 *  3. heap의 크기가 1 줄어든 것으로 간주한다. 즉, 가장 마지막 값은 heap의 일부가 아닌 것으로 간주한다.
 *  4. 루트노드에 대해서 HEAPIFY(1)한다.
 *  5. 2~4번을 반복한다. 
 */

public class HeapSort {
		
	public static void main(String[] args) {
	    int[] array = {0,4,16,15,8,7,13,14,2,5};
	 
	    heapSort(array);
	 
	    for (int v : array) {
	        System.out.println(v);
	    }
	}
	
	// 유일하게 root node만이 heap property를 만족하지 않을 때 이를 만족하게 바꾸는 것
	static void max_heapify(int array[], int n, int i) {
	    int p = i;
	    int l = i * 2 + 1;
	    int r = i * 2 + 2;
	 
	    if (l < n && array[p] < array[l]) {
	        p = l;
	    }
	 
	    if (r < n && array[p] < array[r]) {
	        p = r;
	    }
	 
	    if (i != p) {
	        swap(array, p, i);
	        max_heapify(array, n, p);
	    }
	}
	 
	public static void heapSort(int[] array) {
	    int n = array.length;
	 
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        max_heapify(array, n, i);
	    }
	 
	    for (int i = n - 1; i > 0; i--) {
	        swap(array, 0, i);
	        max_heapify(array, i, 0);
	    }
	}
	 
	public static void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}

	
}
