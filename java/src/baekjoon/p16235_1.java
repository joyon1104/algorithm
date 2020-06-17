package baekjoon;
import java.util.*;

public class p16235_1 {
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int z;
		
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public int compareTo(Tree target) {
			if(this.x<target.x)
				return -1;
			else if(this.x>target.x)
				return 1;
			else {
				if(this.y<target.y)
					return -1;
				else if(this.y>target.y)
					return 1;
				else {
					if(this.z<target.z)
						return -1;
					else if(this.z>target.z)
						return 1;
					else return 0;
				}
			}
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
		
		HashMap<String, PriorityQueue<Integer>> hm = new HashMap<>();
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
			String key = x+"/"+y;
			if(hm.containsKey(key)) {
				hm.get(key).add(z);
			}
			else {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.add(z);
				hm.put(key,pq);
			}
		}
		
		while(K>0) {
			// 봄 
			for(String key : hm.keySet()) {
				int r = Integer.parseInt(key.split("/")[0]);
				int c = Integer.parseInt(key.split("/")[1]);
				if(hm.get(key).size()==1) {
					int age = hm.get(key).poll();
					if(feed[r][c] >= age) {
						feed[r][c] -= age;
						age++;
						fall.add(new Tree(r,c,age));
					}
					else {
						dead.add(new Tree(r,c,age));
					}
				}
				else {
					while(!hm.get(key).isEmpty()) {
						int age = hm.get(key).poll();
						if(feed[r][c] >= age) {
							feed[r][c] -= age;
							age++;
							fall.add(new Tree(r,c,age));
						}
						else {
							dead.add(new Tree(r,c,age));
						}
					}
				}
				
			}
			hm.clear();
			
			/*
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
			*/
			
			// 여름
			while(!dead.isEmpty()) {
				Tree t= dead.poll();
				feed[t.x][t.y] += t.z/2;
			}
			
			// 가을
			int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
			while(!fall.isEmpty()) {
				Tree t = fall.poll();
				String key = t.x +"/"+t.y;
				if(hm.containsKey(key))
					hm.get(key).add(t.z);
				else {
					PriorityQueue<Integer> pq = new PriorityQueue<>();
					pq.add(t.z);
					hm.put(key,pq);
				}
				if(t.z%5==0) {
					for(int p=0; p<8; p++) {
						int next_x = t.x + move[p][0];
						int next_y = t.y + move[p][1];
						if(next_x<=0 || next_y<=0 || next_x>N || next_y>N)
							continue;
//						spring.add(new Tree(next_x,next_y,1));
						String next_key = next_x+"/"+next_y;
						if(hm.containsKey(next_key))
							hm.get(next_key).add(1);
						else {
							PriorityQueue<Integer> pq = new PriorityQueue<>();
							pq.add(1);
							hm.put(next_key,pq);
						}
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
		
		int result = 0;
		for(String key : hm.keySet()) {
			result += hm.get(key).size();
		}
		System.out.println(result);
	}

}
