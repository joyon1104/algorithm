package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 190805
 * 
 * 백준 1182번
 * -> 분류 : 브루트 포스 
 * 
 * [ 부분 수열의 합 ]
 * 
 */

public class p1182 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		int S = sc.nextInt();
		int cnt = 0;
		
		int[] num = new int[N];		// 입력받은 수열
		String[] blist = new String[N];	// binary list 

		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		int bn = (int) Math.pow(2, N);
		
		/*
		 * (1 ~ 2^N-1) 까지 루프가 돈다.
		 * 	1. j를 이진수로 만들어 blist에 하나씩 저장 (예) 32 -> 11110 -> [1,1,1,1,0]
		 * 	2. 입력받은 수열을 blist를 통해 부분 수열의 합을 구한다.
		 * 		예) num=[-7,-3,-2,5,8] , blist[1,1,1,1,0] => (-7)*1 + (-3)*1 + (-2)*1 + 5*1 + 8*0 = -7
		 *  3. 2번의 결과 result 가 S와 맞는지 확인 후 맞으면 cnt값을 1 증가시킨다.
		 *  4. 루프를 계속 반복하여 result값에 따른 cnt값을 갱신하여 결과를 return한다.
		 */
		for(int j=1; j<bn; j++) {		
			//1번
			String bs = Integer.toBinaryString(j);
			int bs_length = bs.length();
			
			for(int k=1; k<= N-bs_length; k++) {
				bs = "0" + bs;
			}
			blist = bs.split("");
			
			//2번
			int result = 0;
			for(int k=0; k<N; k++) {
				result = result + num[k] * Integer.parseInt(blist[k]);
			}
			
			//3번
			if(result == S)
				cnt++;
		}
		System.out.println(cnt);
		int[] visited = new int[N];
		bit(num, num.length);
	}
	
	/*
	 * < 부분집합을 구하는 방법 >
	 * 1. 재귀
	 * 	1) 현재 인덱스를 포함하는 경우
	 *	2) 현재 인덱스를 포함하지 않는 경우
	 *	두 가지로 경우에 대해서 모두 확인한 후에 현재 인덱스가 n(집합의 원소 개수) 이 되면 출력.
	 *
	 *	2. 비트연산
	 *	- 예를들어 집합 원소의 개수 n이 3이면 1 << n = 1000  
	 *		첫번째 for문 i는 1 << 3 = 1000 전까지 증가하므로
	 *		i는 000, 001, 010, 011, 100, 101, 110, 111 까지 증가
	 *		
	 */
	
	// 1. 재귀
	static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
	    if(idx == n) {
	        print(arr, visited, n);	//visited배열에 따라 출력 여부를 결정해주는 함수 
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(arr, visited, n, idx + 1);
	}
	
	static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
	
	//2. 비트연산 
	static void bit(int[] arr, int n) {
	    for(int i=0; i < 1<<n; i++) {
	        for(int j=0; j<n; j++) {
	            if((i & 1<<j) != 0) 
	                System.out.print(arr[j] + " ");
	        }
	        System.out.println();
	    }
	}


}


