package baekjoon;
import java.util.*;

public class p2667 {
	static int[][] map;
	static int[][] visited;
	static ArrayList<Integer> arrlist;
	static int N;
	static int sum;
	static int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
	static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		arrlist = new ArrayList<Integer>();
		sum = 0;
		
		for(int i=1; i<=N; i++) {
			String s = sc.nextLine();
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(s.substring(j-1,j));
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if (visited[i][j] == 0 && map[i][j]==1) {
					Queue<Pair> que = new LinkedList<Pair>();
					Pair p = new Pair(i,j);
					que.offer(p);
					visited[i][j] = 1;
					int res = 0;
					while(!(que.isEmpty())) {
						Pair temp = que.poll();
						res++;
						for(int k=0; k<4; k++) {
							int next_x = temp.x + moved[k][0];
							int next_y = temp.y + moved[k][1];
							
							if(next_x>=1 && next_y>=1 && next_x<=N && next_y<=N) {
								if(map[next_x][next_y]== 1 &&visited[next_x][next_y] == 0) {
									visited[next_x][next_y] = 1;
									Pair pp = new Pair(next_x,next_y);
									que.offer(pp);
								}
							}
						}
						map[temp.x][temp.y] = sum+1;
					}
					sum++;
					arrlist.add(res);
				}
			}
		}
		System.out.println(sum);
		Collections.sort(arrlist);
		for(int i=0; i<arrlist.size(); i++) {
			System.out.println(arrlist.get(i));
		}
	}
}
