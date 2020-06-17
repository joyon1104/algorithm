package baekjoon;
import java.util.*;

public class p15865 {
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int[][] moved = {{0,1},{-1,0},{0,-1},{1,0}};
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			map[y][x] = 1;
			
			// arrlist에 방향 저장
			ArrayList<Integer> arrlist = new ArrayList<>();
			arrlist.add(d);
			for(int p=1; p<=g; p++) {
				for(int i=arrlist.size()-1; i>=0; i--) {
					int next_d = (arrlist.get(i)+1)%4;
					arrlist.add(next_d);
				}
			}
			
			// map에 지나간 점 방문 표시
			for(int n : arrlist) {
				if(n==0) {
					map[y][++x] = 1;
				}
				else if(n==1) {
					map[--y][x] = 1;
				}
				else if(n==2) { 
					map[y][--x] = 1;				
								}
				else if(n==3) {
					map[++y][x] = 1;
				}
			}
		}
		
		int result =0;
		//정사각형 개수 구하기
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(i+1<=100 && j+1<=100) {
					if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1] ==1)
						result++;
				}
			}
		}
		System.out.println(result);
	}
}
