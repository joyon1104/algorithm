package SWEA;
import java.util.*;

/*
 * [원자 시뮬레이션]
 * - 최적화가 생명인 문제
 * - 문제푸는 아이디어도 중요!
 * - 배열 초기화를 T돌때마다 하지 않아야 시간초과 안남 -> ** 배열 초기화가 시간을 많이 잡아먹는구나! 유의하기! -> 그때그때 초기화 할 수 있으면 그렇게 해야함.
 * - 즉, 답은 다맞는데 런타임에러, 시간초과 에러가 날 경우 배열 초기화 여부 등을 확인하는 것이 좋다!
 */

public class p5648_1 {

	static class Atom{
		int x;
		int y;
		int d;
		int k;
		
		public Atom(int x, int y, int d, int k) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
	}
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] visited = new int[4001][4001];
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			Queue<Atom> que = new LinkedList<>();
			for(int n=0; n<N; n++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int d = sc.nextInt();
				int k = sc.nextInt();
				que.offer(new Atom((x*2+2000),(y*2+2000),d,k)); // 2배로 공간을 늘려줌.
			}
			int cnt = N;
			int result = 0;
			int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
			while(true) {
				if(cnt==0)
					break;
				Queue<Atom> tmp = new LinkedList<>();
				while(!que.isEmpty()) {
					Atom a = que.poll();
					int next_x = a.x + move[a.d][0];
					int next_y = a.y + move[a.d][1];
					if(next_x<0 || next_y<0 || next_x>4000 || next_y>4000) { // -1000 ~1000을 넘는 경우는 원자가 다른 원지를 부딪힐 일이 없으므로 원자 삭제
						cnt--;
						continue;
					}
					visited[next_x][next_y] += 1;
					if(visited[next_x][next_y]>1) {
						result += a.k;
						cnt--;
					}
					else
						tmp.offer(new Atom(next_x,next_y,a.d,a.k));
				}
				
				while(!tmp.isEmpty()) {
					Atom a = tmp.poll();
					if(visited[a.x][a.y] == 1) {
						que.offer(a);
					}
					else {
						result += a.k;
						cnt--;
					}
					visited[a.x][a.y] = 0;
				}
			}// while
			
			System.out.println("#"+t+" "+result);
		}
	}
}
