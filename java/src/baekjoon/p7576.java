package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 190812
 * 
 * 백준 7576번
 * -> 분류 : BFS
 * 
 * [ 토마토 ]
 * 
 * => 성공
 * 
 */


public class p7576 {

	// (x,y)값을 저장하는 객체 Pair
	static class Pair{
		int x;
		int y;
		
		public Pair(int i, int j) {
			this.x = i;
			this.y = j;
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	static int M,N;
	static int[][] map;
	static int[][] visited;
	
	public static void main(String[] args) {
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		
		int cnt = 0;	// 처음 토마토 개수
		int tomato = 0;	// 최소 날짜 후 익은 토마토 개수
		int day = 0;
		
		Queue<Pair> que = new LinkedList<Pair>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 초기 익은 토마토의 좌표값을 큐에 저장
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					cnt++;
					Pair p = new Pair(i,j);
					que.offer(p);
					visited[i][j] = 1;
				}
				else if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		// 임시 큐 
		Queue<Pair> tmp = new LinkedList<Pair>();
		
		while(!(que.isEmpty())) {
			Pair p = que.poll();
			int i = p.x;
			int j = p.y;
			
			tomato++;	// 좌표 (i,j)가 큐에서 나올 때 -> 토마토 익음 -> tomato++ 
			
			// 상하좌우 탐색 -> 0이면 (토마토가 익지 않았으면) 해당 좌표를 우선 임시 큐에 넣음.
			if(i-1>=0 && map[i-1][j] == 0  && visited[i-1][j] == 0) {
				Pair pa = new Pair(i-1,j);
				map[pa.x][pa.y] = 1;			// *** 큐에 넣기 직전에 해당 좌표의 토마토를 1로 바꿔주고 방문 여부를 표시 (큐에서 출력할 때 하면 안됨)-> 이걸로 헤맴...
				visited[pa.x][pa.y] = 1;
				tmp.offer(pa);
			}
			if(i+1<N && map[i+1][j] == 0 && visited[i+1][j] == 0) {
				Pair pa = new Pair(i+1, j);
				map[pa.x][pa.y] = 1;
				visited[pa.x][pa.y] = 1;
				tmp.offer(pa);
			}
			if(j-1>=0 && map[i][j-1] == 0 && visited[i][j-1] == 0) {
				Pair pa = new Pair(i,j-1);
				map[pa.x][pa.y] = 1;
				visited[pa.x][pa.y] = 1;
				tmp.offer(pa);
			}
			if(j+1<M && map[i][j+1] == 0 && visited[i][j+1] == 0) {
				Pair pa = new Pair(i,j+1);
				map[pa.x][pa.y] = 1;
				visited[pa.x][pa.y] = 1;
				tmp.offer(pa);
			}
			
			if(que.isEmpty()) {
				day++;	// day를 1 증가시킨 후 
				while(!(tmp.isEmpty())) {	// 임시 큐에 저장된 좌표값을 큐에 넣음 (단계 수를 계산하기 위해)
					que.offer(tmp.poll());
				}
			}
			
		}
		
		// 모든 토마토가 익었을 때 day 출력
		if(cnt == tomato)
			System.out.println(day-1);
		else
			System.out.println(-1);
		
	}
	
}
