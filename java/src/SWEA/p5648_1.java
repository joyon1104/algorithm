package SWEA;
import java.util.*;

/*
 * [���� �ùķ��̼�]
 * - ����ȭ�� ������ ����
 * - ����Ǫ�� ���̵� �߿�!
 * - �迭 �ʱ�ȭ�� T�������� ���� �ʾƾ� �ð��ʰ� �ȳ� -> ** �迭 �ʱ�ȭ�� �ð��� ���� ��ƸԴ±���! �����ϱ�! -> �׶��׶� �ʱ�ȭ �� �� ������ �׷��� �ؾ���.
 * - ��, ���� �ٸ´µ� ��Ÿ�ӿ���, �ð��ʰ� ������ �� ��� �迭 �ʱ�ȭ ���� ���� Ȯ���ϴ� ���� ����!
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
				que.offer(new Atom((x*2+2000),(y*2+2000),d,k)); // 2��� ������ �÷���.
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
					if(next_x<0 || next_y<0 || next_x>4000 || next_y>4000) { // -1000 ~1000�� �Ѵ� ���� ���ڰ� �ٸ� ������ �ε��� ���� �����Ƿ� ���� ����
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
