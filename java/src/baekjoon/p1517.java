package baekjoon;
import java.util.*;

/*
 * 시간초과
 * -> 버블소트로 풀면 시간초과남..
 */

public class p1517 {
	static int N,cnt;
	static int[] arr;
	
	static void mergeSort(int[] arr, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(arr,p,q);
			mergeSort(arr,q+1,r);
			merge(arr,p,q,r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int i=p;
		int j=q+1;
		int k=p;
		int[] tmp = new int[N];
		
		while(i<=q && j<=r) {
			if(arr[i]<=arr[j])
				tmp[k++] = arr[i++];
			else {
				cnt += (q-i+1); // 왼쪽 배열에 남아있는 숫자만큼 계속 swap이 발생하므로..
				tmp[k++] = arr[j++];
			}
		}
		
		while(i<=q)
			tmp[k++] = arr[i++];
		while(j<=r) 
			tmp[k++] = arr[j++];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr,0,N-1);
		System.out.println(cnt);
		
	}

}
