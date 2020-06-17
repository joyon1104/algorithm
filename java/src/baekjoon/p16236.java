package baekjoon;
import java.util.*;

public class p16236 {
	
	static class Fish implements Comparable<Fish>{
		int i;
		int j;
		int size;
		int dist;
		
		public Fish(int i, int j, int size, int dist) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.dist = dist;
		}
		
		public int compareTo(Fish target) {
			if(this.dist<target.dist)
				return -1;
			else if(this.dist == target.dist) {
				if(this.i < target.i) return -1;
				else if(this.i == target.i) {
					if(this.j < target.j) return -1;
					else if(this.j == target.j) return 0;
					else return 1;
				}
				else return 1;
			}
			else
				return 1;
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
		int[][] map = new int[N][N];
		int[][] moved = {{-1,0},{0,-1},{0,1},{1,0}};
		Fish shark = new Fish(0,0,0,0);
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9)
					shark = new Fish(i,j,2,0); 
			}
		}
		pq.offer(shark);
		int[][] visited = new int[N][N];
		visited[shark.i][shark.j] = 1;
		int time = 0;
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Fish f = pq.poll();
			if(map[f.i][f.j] > 0 && map[f.i][f.j] < shark.size && map[f.i][f.j] != 9) {	//큐에서 꺼낼 때 판단 (그래야 우선순위 큐에 의해 가능한 물고기 중 최적의 물고기 선택이 가능함)
				cnt++;
				time += f.dist;
				map[shark.i][shark.j] = 0;
				map[f.i][f.j] = 9;
				if(cnt == shark.size) {
					cnt=0;
					shark.size++;
				}
				shark = new Fish(f.i,f.j,shark.size,0);
				pq.clear();
				pq.offer(new Fish(f.i,f.j,shark.size,0));
				visited = new int[N][N];
				visited[shark.i][shark.j] = 1;
				printmap(map);
				continue;
			}
			for(int k=0; k<4; k++) {
				int next_i = f.i + moved[k][0];
				int next_j = f.j + moved[k][1];
				if(next_i>=0 && next_j>=0 && next_i<N && next_j<N && visited[next_i][next_j] == 0) {
					visited[next_i][next_j] = 1;
					if(map[next_i][next_j] > shark.size) continue;
					else // 상어 크기보다 작거나 같은 물고기를 모두 큐에 넣음 -> 잡아먹을 물고기 판단은 큐에서 poll할 때 해야함 -> 가능한 물고기를 모두 우선순위 큐에 넣어 정렬해야함!!!
						pq.offer(new Fish(next_i,next_j,map[next_i][next_j],f.dist+1));
				}
			}
		}
		System.out.println(time);
	}
}
