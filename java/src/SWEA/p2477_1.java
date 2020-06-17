package SWEA;
import java.util.*;

public class p2477_1 {

	static class Customer{
		int cnum;	//고객번호
		int n1;		//접수번호
		int n2;		//정비번호
		int t;		//시작시간 -> 접수에서 정비로 넘어간 시간
		int a;		//접수 소요시간
		int b;		//정비 소요시간
		
		public Customer(int cnum, int n1, int n2, int t, int a, int b) {
			this.cnum = cnum;
			this.n1 = n1;
			this.n2 = n2;
			this.t = t;
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int result = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int[] ai = new int[N+1];
			for(int i=1; i<=N; i++)
				ai[i] = sc.nextInt();
			int[] bj = new int[M+1];
			for(int i=1; i<=M; i++)
				bj[i] = sc.nextInt();
			
			PriorityQueue<Customer> pq = new PriorityQueue<Customer>(new Comparator<Customer>() {
				public int compare(Customer o1, Customer o2) {
					if(o1.t < o2.t)
						return -1;
					else if(o1.t == o2.t) {
						if(o1.cnum < o2.cnum) return -1;
						else if(o1.cnum > o2.cnum) return 1;
						else return 0;
					}
					else return 1;
				}
			});
			for(int i=1; i<=K; i++) {
				int tk = sc.nextInt();
				pq.offer(new Customer(i,0,0,tk,0,0));
			}
			
			PriorityQueue<Customer> pq2 = new PriorityQueue<Customer>(new Comparator<Customer>() {
				public int compare(Customer o1, Customer o2) {
					if(o1.t < o2.t)
						return -1;
					else if(o1.t == o2.t) {
						if(o1.n1 < o2.n1) return -1;
						else if(o1.n1 > o2.n1) return 1;
						else return 0;
					}
					else return 1;
				}
			});
			
			int time = 0;
			Customer[] A_arr = new Customer[N+1];
			Customer[] B_arr = new Customer[M+1];
			ArrayList<Customer> arrlist = new ArrayList<>();
			
			while(arrlist.size()<K) {
				for(int i=1; i<=N; i++) {
					if(A_arr[i]==null && !pq.isEmpty() && pq.peek().t<=time) {
						A_arr[i] = pq.poll();
						A_arr[i].n1 = i;
					}
					else if(A_arr[i]==null)
						continue;
					else if(A_arr[i] != null && A_arr[i].a == ai[i]) {
						A_arr[i].t = time;
						pq2.offer(A_arr[i]);
						if(!pq.isEmpty() && pq.peek().t<=time) {
							A_arr[i] = pq.poll();
							A_arr[i].n1 = i;
						}
						else A_arr[i] = null;
					}
					if(A_arr[i] != null)
						A_arr[i].a++;
				}
				
				for(int j=1; j<=M; j++) {
					if(B_arr[j]==null && !pq2.isEmpty() && pq2.peek().t<=time) {
						B_arr[j] = pq2.poll();
						B_arr[j].n2 = j;
					}
					else if(B_arr[j]==null)
						continue;
					else if(B_arr[j] != null && B_arr[j].b == bj[j]) {
						arrlist.add(B_arr[j]);
						if(!pq2.isEmpty() && pq2.peek().t<=time) {
							B_arr[j] = pq2.poll();
							B_arr[j].n2 = j;
						}
						else B_arr[j] = null;
					}
					if(B_arr[j] != null)
						B_arr[j].b++;
				}
				time++;
			}//while
			
			for(Customer c : arrlist) {
				if(c.n1 == A && c.n2 == B)
					result+= c.cnum;
			}
			if(result==0)
				result = -1;
			System.out.println("#"+t+" "+result);
		}
	}
}
