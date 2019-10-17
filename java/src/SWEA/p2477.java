package SWEA;

import java.util.*;

class Customer{
	int i;
	int tk;
	int n;
	int nt;
	int m;
	int mt;
	public Customer(int i,int tk ,int n, int nt, int m, int mt) {
		this.i = i;
		this.tk = tk;
		this.n = n;
		this.nt = nt;
		this.m = m;
		this.mt = mt;
	}
}

public class p2477 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int[] at = new int[N+1];
			int[] bt = new int[M+1];
			int[] tk = new int[K+1];
			int[] nk = new int[K+1];
			
			for(int a=1; a<=N; a++) {
				at[a] = sc.nextInt();
			}
			for(int b=1; b<=M; b++) {
				bt[b] = sc.nextInt();
			}
			for(int k=1; k<=K; k++) {
				tk[k] = sc.nextInt();
				nk[k] = tk[k];
			}
			
			
			ArrayList<Customer> dept = new ArrayList<Customer>();
			ArrayList<Customer> first = new ArrayList<Customer>();
			Queue<Customer> second = new LinkedList<Customer>();
			Queue<Customer> que = new LinkedList<Customer>();
			
			ArrayList<Customer> reception = new ArrayList<Customer>();
			int[] rc = new int[N+1];
			ArrayList<Customer> repair = new ArrayList<Customer>();
			int[] rp = new int[M+1];
			
			Arrays.sort(nk);
			
			for(int k=1; k<=K; k++) {
				int i=0;
				for(i=1; i<=K; i++) {
					if(nk[k] == tk[i])
						break;
				}
				Customer tmp = new Customer(i,nk[k],0,0,0,0);
				dept.add(tmp);
			}
			
			int time = 0;
			
			while(que.size()<K) {
				if(repair.size() != 0) {
					for(int i=0; i<repair.size(); i++) {
						if(repair.get(i).mt==0) {
							que.add(repair.get(i));
							rp[repair.get(i).m] = 0;
							repair.remove(i);
							i--;
						}
						else {
							repair.get(i).mt--;
						}
					}
				}
				
				if(reception.size()!=0) {
					for(int i=0; i<reception.size(); i++) {
						if(reception.get(i).nt==0) {
							second.add(reception.get(i));
							rc[reception.get(i).n] = 0;
							reception.remove(i);
							i--;
						}
						else {
							reception.get(i).nt--;
						}
					}
				}
				
				if(!(second.isEmpty())) {
					for(int i=1; i<=M; i++) {
						if(rp[i] == 0) {
							if(!(second.isEmpty())) {
								Customer cus = second.poll();
								cus.m = i;
								cus.mt = bt[i];
								repair.add(cus);
								rp[i] = 1;
							}
						}
					}
				}
				
				for(int i=0; i<dept.size(); i++) {
					Customer cus = dept.get(i);
					if(time == cus.tk) {
						dept.remove(i);
						first.add(cus);
						i--;
					}
				}
				
				if(!(first.isEmpty())) {
					for(int i=1; i<=N; i++) {
						if(rc[i] == 0) {
							Customer cus = new Customer(0,0,0,0,0,0);
							if(!(first.isEmpty())) {
								int min = 1000;
								for(int f=0; f<first.size(); f++) {
									if(min>first.get(f).i)
										min = first.get(f).i;
								}
								for(int f=0; f<first.size(); f++) {
									if(first.get(f).i == min) {
										cus = first.get(f);
										first.remove(f);
										break;
									}
								}
								cus.n = i;
								cus.nt = at[i];
								reception.add(cus);
								rc[i]=1;
							}
						}
					}
				}
				time++;
			}
			
			int result = 0;
			
			while(!(que.isEmpty())){
				Customer cus = que.poll();
				if(cus.n == A && cus.m == B) {
					result += cus.i;
				}
			}
			
			if(result == 0)
				result = -1;
			
			System.out.println("#" + t + " " + result);
		}
	}

}
