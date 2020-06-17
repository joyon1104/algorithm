package baekjoon;
import java.util.*;

public class p16236_1 {
	
	static class Fish implements Comparable<Fish>{
		int dist;
		int i;
		int j;
		int size;
		
		public Fish(int dist, int i, int j, int size) {
			this.dist = dist;
			this.i = i;
			this.j = j;
			this.size = size;
		}
		
		public int compareTo(Fish target) {
			if(this.dist < target.dist)
				return -1;
			else if(this.dist == target.dist) {
				if(this.i<target.i) return -1;
				else if(this.i==target.i) {
					if(this.j<target.j) return -1;
					else if(this.j==target.j) return 0;
					else return 1;
				}
				else return 0;
			}
			else return 1;
		}
	}
	
	public static void printmap(int[][] map){
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				System.out.print(map[i][j] +" ");
			System.out.println();
		}
		System.out.println("-------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Fish shark = new Fish(0,0,0,0);
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		int[][] moved = {{-1,0},{0,-1},{0,1},{1,0}};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					shark = new Fish(0,i,j,2);
					pq.offer(shark);
					visited[i][j] = -1;
				}
			}
		}
		
		int time = 0;
		int cnt = 0;
		PriorityQueue<Fish> tmppq = new PriorityQueue<>();
		while(true) {
		while(!pq.isEmpty()) {
			Fish f = pq.poll();
			if(map[f.i][f.j] != 9 && map[f.i][f.j]>0)
				tmppq.offer(new Fish(f.dist,f.i,f.j,f.size));
			/*
			if(map[f.i][f.j] > 0 && map[f.i][f.j] != 9 && map[f.i][f.j] < shark.size) {
				cnt++;
				time+=f.dist;
				map[shark.i][shark.j] = 0;
				map[f.i][f.j] = 9;
				if(cnt == shark.size) {
					shark = new Fish(0, f.i,f.j,shark.size+1);
					cnt = 0;
				}
				else shark = new Fish(0, f.i, f.j,shark.size);
				visited = new int[N][N];
				visited[shark.i][shark.j] = -1;
				pq.clear();
				pq.offer(shark);
				printmap(map);
				System.out.println("¤¤"+shark.size);
				continue;
			}
			*/
			//else {
			for(int k=0; k<4; k++) {
				int next_i = f.i + moved[k][0];
				int next_j = f.j + moved[k][1];
				if(next_i>=0 && next_j>=0 && next_i<N && next_j<N) {
					if(visited[next_i][next_j]== 0 || (visited[next_i][next_j]>0 && visited[next_i][next_j] > f.dist+1)){
						int d = f.dist+1;	
						visited[next_i][next_j] = d;
						if(map[next_i][next_j] > shark.size)
							continue;
						pq.offer(new Fish(d, next_i,next_j,map[next_i][next_j]));						
					}
				}
			}
		}
		while(!tmppq.isEmpty()) {
			Fish f = tmppq.poll();
			if(map[f.i][f.j] > 0 && map[f.i][f.j] != 9 && map[f.i][f.j] < shark.size) {
				printmap(map);
				cnt++;
				time+=f.dist;
				map[shark.i][shark.j] = 0;
				map[f.i][f.j] = 9;
				if(cnt == shark.size) {
					shark = new Fish(0, f.i,f.j,shark.size+1);
					cnt = 0;
				}
				else shark = new Fish(0, f.i, f.j,shark.size);
				visited = new int[N][N];
				visited[shark.i][shark.j] = -1;
				pq.clear();
				pq.offer(shark);
				
				System.out.println("¤¤"+shark.size);
				break;
			}
		}
		if(pq.isEmpty())
			break;
		}
		System.out.println(time);
	}
}
