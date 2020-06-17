package SWEA;
import java.util.*;

public class p5644 {
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static class AP implements Comparable<AP>{
		int idx;
		int per;
		public AP(int idx, int per) {
			this.idx = idx;
			this.per = per;
		}
		
		public int compareTo(AP target) {
			if(this.per > target.per)
				return -1;
			else if(this.per < target.per)
				return 1;
			else
				return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int M = sc.nextInt();
			int A = sc.nextInt();
			int[] u1 = new int[M+1];
			int[] u2 = new int[M+1];
			for(int i=1; i<=M; i++)
				u1[i] = sc.nextInt();
			for(int i=1; i<=M; i++)
				u2[i] = sc.nextInt();
			
			int[][] BC = new int[A][4];
			for(int i=0; i<A; i++) {
				BC[i][1] = sc.nextInt();	//Çà ¿­ÀÌ ¹Ù²î¾î¼­ Á¦½ÃµÊ!
				BC[i][0] = sc.nextInt();
				BC[i][2] = sc.nextInt();
				BC[i][3] = sc.nextInt();
			}
			
			int sum1 = 0;
			int sum2 = 0;
			Pair p1 = new Pair(1,1);
			Pair p2 = new Pair(10,10);
			int time = 0;
			int[][] moved = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
			
			while(time <= M) {
				p1.i = p1.i+moved[u1[time]][0];
				p1.j = p1.j+moved[u1[time]][1];
				p2.i = p2.i+moved[u2[time]][0];
				p2.j = p2.j+moved[u2[time]][1];
				
				PriorityQueue<AP> que1 = new PriorityQueue<>();
				PriorityQueue<AP> que2 = new PriorityQueue<>();
				
				for(int k=0; k<A; k++) {
					Pair bc = new Pair(BC[k][0],BC[k][1]);
					int c = BC[k][2];
					int p = BC[k][3];
					
					if(Math.abs(p1.i-bc.i)+Math.abs(p1.j-bc.j) <= c)
						que1.add(new AP(k,p));
					if(Math.abs(p2.i-bc.i)+Math.abs(p2.j-bc.j) <= c)
						que2.add(new AP(k,p));
				}
				if(!que1.isEmpty())
					sum1 += que1.peek().per;
				if(!que2.isEmpty())
					sum2 += que2.peek().per;
				
				if(!que1.isEmpty() && !que2.isEmpty() && que1.peek().idx == que2.peek().idx) {
					int tmp = que1.poll().per;
					que2.poll();
					if(que1.isEmpty() && que2.isEmpty()) {
						sum1 -= tmp;
					}
					else if(que1.isEmpty()) {
						sum2 -= tmp;
						sum2 += que2.peek().per;
					}
					else if(que2.isEmpty()) {
						sum1 -= tmp;
						sum1 += que1.peek().per;
					}
					else if(que1.peek().per < que2.peek().per) {
						sum2 -= tmp;
						sum2 += que2.peek().per;
					}
					else if(que1.peek().per >= que2.peek().per) {
						sum1 -= tmp;
						sum1 += que1.peek().per;
					}
						
				}
				time++;
			}//while
			
			int result = sum1+sum2;
			System.out.println("#"+t+" "+result);
		}
	}
}
