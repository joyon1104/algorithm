package baekjoon;
import java.util.*;

/*
 * 힙 정렬 사용해야 시간초과 안남..
 */

public class p2751 {
	static void heapSort(int[] data) {
		int n = data.length;
		
		/* 첫번째 heapify() 는 단순히 일반 배열을 힙으로 구성하는 역할을 한다.
		 * 그 과정에서 자식 노드로부터 부모 노드를 비교한다.
		 * n / 2 - 1 부터 0까지는 인덱스가 도는 이유는 부모 노드의 인덱스를 기준으로 왼쪽자식노드(i * 2 + 1), 오른쪽자식노드(i * 2 + 2) 이기 때문이다. 
		 */
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(data, n, i);
		}
		/*
		 * 두번째 heapify() 는 요소가 하나 제거된 후 다시 최대 힙을 구성하기 위함이다.
		 * extract 연산과 같은 처리를 하기 위해 루트를 기준으로 진행된다.
		 */
		for (int i = n - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapify(data, i, 0);
		}
	}

	static void heapify(int[] data, int n, int i) {
		int parent = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		if (left < n && data[parent] < data[left]) {
			parent = left;
		}

		if (right < n && data[parent] < data[right]) {
			parent = right;
		}

		if (i != parent) {
			int temp = data[parent];
			data[parent] = data[i];
			data[i] = temp;
			heapify(data, n, parent);
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sortArr = new int[N];
		for (int i = 0; i < N; i++) {
			sortArr[i] = sc.nextInt();
		} // 정렬 전

		heapSort(sortArr);

		for (int i = 0; i < N; i++) {
			System.out.println(sortArr[i]);
		}

	}
}
