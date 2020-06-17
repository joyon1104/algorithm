package baekjoon;
import java.util.*;

public class p16235 {
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int z;
		
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public int compareTo(Tree target) { // 행,열을 비교할 필요 없음! -> 사이즈가 작은순으로 양분을 먹으면 결국 사이즈가 큰 나무는 양분을 못먹게 되는 건 똑같음!
			if(this.z < target.z)
				return -1;
			else if(this.z > target.z)
				return 1;
			else return 0;
		}
	}
	
	static int N,M,K;
	static int[][] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				A[i][j] = sc.nextInt();
		}
		
		PriorityQueue<Tree> spring = new PriorityQueue<>();
		Queue<Tree> dead = new LinkedList<>();
		Queue<Tree> fall = new LinkedList<>();
		int[][] feed = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				feed[i][j] = 5;
		}
		
		for(int m=0; m<M; m++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			spring.add(new Tree(x,y,z));
		}
		
		while(K>0) {
			// 봄 
			while(!spring.isEmpty()) {
				Tree t = spring.poll();
				if(feed[t.x][t.y] >= t.z) {
					feed[t.x][t.y] -= t.z;
					t.z++;
					fall.add(t);
				}
				else {
					dead.add(t);
				}
			}
			
			// 여름
			while(!dead.isEmpty()) {
				Tree t= dead.poll();
				feed[t.x][t.y] += t.z/2;
			}
			
			// 가을
			int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
			while(!fall.isEmpty()) {
				Tree t = fall.poll();
				spring.add(t);
				if(t.z%5==0) {
					for(int p=0; p<8; p++) {
						int next_x = t.x + move[p][0];
						int next_y = t.y + move[p][1];
						if(next_x<=0 || next_y<=0 || next_x>N || next_y>N)
							continue;
						spring.add(new Tree(next_x,next_y,1));
					}
				}
			}
			
			// 겨울
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++)
					feed[r][c] += A[r][c];
			}
			
			K--;
		}
		
		System.out.println(spring.size());
	}

}
