package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p5653_x {
	
	static Scanner sc = new Scanner(System.in);
	static int N,M,K,cnt;
	static int[][] map;
	static int[][] status;
	static Queue<Pair> tmp_que;
	
	static class Pair{
		int i;
		int j;
		int timestamp;
		
		public Pair(int i, int j, int timestamp) {
			this.i = i;
			this.j = j;
			this.timestamp = timestamp;
		}
	}
	
	static void compute(Queue<Pair> que, int fi, int fj, int K) {
		tmp_que = new LinkedList<Pair>();
		
		for(int k=1; k<=K; k++) {
			while(!(que.isEmpty())) {
				//System.out.println("que"+(que.peek().i) + " "+ (que.peek().j));
				
				Pair p = que.poll();
				
				if(status[p.i][p.j] == -1 && p.timestamp != map[p.i][p.j]*2)
					p.timestamp = map[p.i][p.j]*2;// ******
				
				if(status[p.i][p.j] == -1) 
					status[p.i][p.j] = 1;
				
				p.timestamp--;
				
				if(p.timestamp == map[p.i][p.j] && status[p.i][p.j] == 1) {
					status[p.i][p.j] = 2;
					//p.timestamp = map[p.i][p.j];
				}
				
				if(status[p.i][p.j] == 2 && p.timestamp == map[p.i][p.j]-1) {
					spread(tmp_que, p.i, p.j);
				}
				
				if(p.timestamp == 0 && status[p.i][p.j] == 2)
					status[p.i][p.j] = 3;
				
				if(status[p.i][p.j] == 1 || status[p.i][p.j] == 2) {
					tmp_que.offer(p);
				}
			}
			
			//System.out.println(k+": " +tmp_que.size());
			
			while(!(tmp_que.isEmpty())) {
				//System.out.println((tmp_que.peek().i) + " "+ (tmp_que.peek().j));
				que.offer(tmp_que.poll());
			}
			//System.out.println("-----------");
		}
		
	}
	
	static void spread(Queue<Pair> tmp, int i, int j) {
		int[] move_i = {-1,0,1,0};
		int[] move_j = {0,1,0,-1};
		
		for(int q=0; q<4; q++){
			int next_i = i + move_i[q];
			int next_j = j + move_j[q];
			
			if(status[next_i][next_j] == 0) {
				map[next_i][next_j] = map[i][j];
				status[next_i][next_j] = 1;
				Pair next_p = new Pair(next_i,next_j,map[i][j]*2);
				tmp.offer(next_p);
			}
			else if(status[next_i][next_j] == -1) {
				if(map[next_i][next_j] < map[i][j])
					map[next_i][next_j] = map[i][j];
			}
		}
	}
	
	static int[][] deepCopy(int[][] map){
		int[][] tmp =  new int[1000][1000];
		for(int i =0; i<1000; i++) {
			for(int j = 0; j<1000; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[1000][1000];
			status = new int[1000][1000];
			cnt = 0;
			
			int fi = (1000-N)/2;
			int fj = (1000-M)/2;
			
			Queue<Pair> que = new LinkedList<Pair>();
			
			for(int i = fi; i< fi+N; i++) {
				for(int j = fj; j< fj+M; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) {
						status[i][j] = 1;
						Pair tmp = new Pair(i,j,map[i][j]*2);
						que.offer(tmp);
					}
				}
			}
			
			compute(que, fi, fj, K);
			
			System.out.println("#"+t+" "+que.size());
		}
		
	}
}
