package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 190814
 * 
 * 백준 7562번
 * -> 분류 : BFS
 * 
 * [ 나이트의 이동 ]
 * 
 * => 성공
 * 
 */

public class p7562 {
	
	static class Pair{
		int p;
		int q;
		
		public Pair(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	static int I;
	static int[][] board;
	static int[][] visited;
	static int result;
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		int[] result = new int[T];
		
		for(int t=0; t<T; t++) {
			I = sc.nextInt();
			
			board = new int[I][I];	// 시작 점 부터 해당 좌표까지 이동한 횟수가 입력됨.
			visited = new int[I][I];	// 방문 여부 표시 
			
			int p = sc.nextInt();
			int q= sc.nextInt();
			
			
			Pair current = new Pair(p,q);
			
			p = sc.nextInt();
			q = sc.nextInt();
			
			Pair aim = new Pair(p,q);
			
			Queue<Pair> que = new LinkedList<Pair>();
			visited[current.p][current.q] = 1;	// 현재 위치 방문 표시 
			que.offer(current);	// 큐에 삽입 
			
			int res = 0;
			board[current.p][current.q] = res;
			
			// 말을 놓을 수 있는 좌표값
			int[] move_x = { -2, -1, 1, 2, 2, 1, -1, -2 };
	        int[] move_y = { -1, -2, -2, -1, 1, 2, 2, 1 };

	        //BFS
			while(!(que.isEmpty())) {
				Pair tmp = que.poll();
				
				if(tmp.p == aim.p && tmp.q== aim.q) {	// 현재 좌표 값이 목표한 좌표값이면 board의 현재 좌표값(이동횟수)을 저장한 후, break;
					result[t] = board[tmp.p][tmp.q];
					break;
				}
				
				for(int i=0; i<8; i++) {
					int next_x = tmp.p + move_x[i];
					int next_y = tmp.q + move_y[i];
					
					if(next_x<I && next_y<I && next_x>=0 && next_y>=0) {
						if(visited[next_x][next_y] == 0) {
							visited[next_x][next_y] = 1;
							board[next_x][next_y] = board[tmp.p][tmp.q] + 1;
							Pair in = new Pair(next_x, next_y);
							que.offer(in);
						}
					}
				}// for 문 종료 
			}//while
		}
		// 결과 값 출력
		for(int t=0; t<T; t++)
			System.out.println(result[t]);
	}
}
