package SWEA;
import java.util.*;

/*
 * [차량정비소]
 * - 성공
 */
public class p2477_2 {
	
	static void print(int[][] map) {
			for(int i=1; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("==============");
	}

	static class Customer implements Comparable<Customer>{
		int idx;
		int na;
		int nb;
		int wait;
		
		public Customer(int idx, int na, int nb, int wait) {
			this.idx = idx; 
			this.na = na;
			this.nb = nb;
			this.wait = wait;
		}
		
		public int compareTo(Customer target) {
			if(this.wait<target.wait)
				return -1;
			else if(this.wait > target.wait)
				return 1;
			else {
				if(this.na < target.na)
					return -1;
				else if(this.na > target.na)
					return 1;
				else {
					 return 0;
				}
			}
		}
	}
	
	static int N,M,K,A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			int[][] customers = new int[K+1][2];
			
			int[][] arrA = new int[N+1][3];
			for(int a=1; a<=N; a++)
				arrA[a][0] = sc.nextInt();
			int[][] arrB = new int[M+1][3];
			for(int b=1; b<=M; b++)
				arrB[b][0] = sc.nextInt();
			int[] arrT = new int[K+1];
			for(int k=1; k<=K; k++) {
				arrT[k] = sc.nextInt();
			}
			
			PriorityQueue<Customer> pq1 = new PriorityQueue<>();
			for(int k=1; k<=K; k++) {
				pq1.add(new Customer(k,0,0,arrT[k]));
			}
			
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			PriorityQueue<Customer> pq3 = new PriorityQueue<>();
			int end = 0;
			int time = 0;
			while(end < K) {
//				System.out.println(time);
				while(!pq1.isEmpty()) {
					if(pq1.peek().wait > time)
						break;
					else {
						Customer c = pq1.poll();
						pq2.add(c.idx);
					}
				}
				
				// 접수 창구
				for(int a=1; a<=N; a++) {
					if(arrA[a][1] == 0 && !pq2.isEmpty()) {
						arrA[a][1] = arrA[a][0];
						arrA[a][2] = pq2.poll();
						customers[arrA[a][2]][0] = a;
					}
					else if(arrA[a][1] > 0) {
						arrA[a][1] -= 1;
						if(arrA[a][1] == 0) {
							pq3.add(new Customer(arrA[a][2],a,0,time));
							if(!pq2.isEmpty()) { // 창구가 빌 때마다 바로바로 넣어주는 것이 중요!
								arrA[a][1] = arrA[a][0];
								arrA[a][2] = pq2.poll();
								customers[arrA[a][2]][0] = a;
							}
							else { //큐가 비어있을 경우는 초기화
								arrA[a][1] = 0;
								arrA[a][2] = 0;
							}
						}
					}
				}
//				System.out.println("A");
//				print(arrA);
				
				// 정비창구
				for(int b=1; b<=M; b++) {
					if(arrB[b][1] == 0 && !pq3.isEmpty()) {
						arrB[b][1] = arrB[b][0];
						arrB[b][2] = pq3.poll().idx;
						customers[arrB[b][2]][1] = b;
					}
					else if(arrB[b][1] > 0) {
						arrB[b][1] -= 1;
						if(arrB[b][1] == 0) {
							end++;
							if(!pq3.isEmpty()) { // 창구가 빌 때마다 바로바로 넣어주는 것이 중요!
								arrB[b][1] = arrB[b][0];
								arrB[b][2] = pq3.poll().idx;
								customers[arrB[b][2]][1] = b;
							}
							else {  //큐가 비었을 경우 초기화
								arrB[b][1] = 0;
								arrB[b][2] = 0;
							}
						}
					}
				}
//				System.out.println("B");
//				print(arrB);
				
				time++;
			}
			
			int result = 0;
			for(int k=1; k<=K; k++) {
				if(customers[k][0]==A && customers[k][1]==B)
					result+=k;
			}
			if(result==0)
                result = -1;
			
			System.out.println("#"+t+" "+result);
			
		}
	}
}
