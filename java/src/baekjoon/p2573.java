package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2573 {
	
	static int N,M,time;
	
	static Scanner sc = new Scanner(System.in);
	
	static class Pair{
		int i;
		int j;
		int h;
		
		public Pair(int i, int j, int h) {
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}
	
	static class Pair2{
		int i;
		int j;
		
		public Pair2(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] deepcopy(int[][] map) {
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	public static Pair checkFour(int[][]map, Pair p) {
		int i = p.i;
		int j = p.j;
		int h = p.h;
		
		if(i-1>=0 && map[i-1][j] == 0) {
			h--;
		}
		if(j+1<N && map[i][j+1] == 0) {
			h--;
		}
		if(i+1<N && map[i+1][j] == 0) {
			h--;
		}
		if(j-1>=0 && map[i][j-1] == 0) {
			h--;
		}
		
		Pair tp = new Pair(i,j,h);
		return tp;
	}
	
	static int BFS(int[][]map, int[][]visited, Queue<Pair2> que, int cnt) {
		
		while(!(que.isEmpty())) {
			int i = que.peek().i;
			int j = que.peek().j;
			que.poll();
			
			if(i-1>=0 && map[i-1][j] != 0 && visited[i-1][j] == 0) {
				Pair2 p = new Pair2(i-1,j);
				visited[i-1][j] = 1;
				que.add(p);
				cnt++;
			}
			if(j+1<N && map[i][j+1] != 0 && visited[i][j+1] == 0) {
				Pair2 p = new Pair2(i,j+1);
				visited[i][j+1] = 1;
				que.add(p);
				cnt++;
			}
			if(i+1<N && map[i+1][j] != 0 && visited[i+1][j] == 0) {
				Pair2 p = new Pair2(i+1,j);
				visited[i+1][j] = 1;
				que.add(p);
				cnt++;
			}
			if(j-1>=0 && map[i][j-1] != 0 && visited[i][j-1] == 0) {
				Pair2 p = new Pair2(i,j-1);
				visited[i][j-1] = 1;
				que.add(p);
				cnt++;
			}
		}
		return cnt;
		
	}
	
	static boolean divideTwo(int[][]map, int i, int j, int nq) {
		int[][] visited = new int[N][M];
		
		visited[i][j] = 1;
		
		Queue<Pair2> que = new LinkedList<Pair2>();
		Pair2 p = new Pair2(i,j);
		
		que.add(p);

		int cnt = BFS(map,visited,que,1);
		
		if(nq != cnt)
			return true;
		
		else return false;
	}
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		M = sc.nextInt();
		time = 0;
		
		int[][] map = new int[N][M];
		Queue<Pair> que = new LinkedList<Pair>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				int h = map[i][j];
				Pair p = new Pair(i,j,h);
				que.add(p);
			}
		}
		
		while(true) {
			int[][] tmap = new int[N][M];
			Queue<Pair> tque = new LinkedList<Pair>();
			
			while(!(que.isEmpty())) {
				Pair bp = que.poll();
				Pair ap = checkFour(map,bp);// 네방향 검사 후 pair리턴
				if(ap.h > 0) {
					tque.add(ap);
					tmap[ap.i][ap.j] = ap.h;
				}
			}
			
			if(tque.isEmpty()) {
				System.out.println(0);
				break;
			}
			map = deepcopy(tmap);
			que = tque;
			
			time++;
			
			Pair tp = que.peek();
			int i = tp.i;
			int j = tp.j;
			int nq = que.size();
			
			if(divideTwo(map,i,j,nq)){
				System.out.println(time);
				break;
			}
		}
		
	}
}
