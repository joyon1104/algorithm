package baekjoon;
import java.util.*;

public class p17144 {
	
	static void printmap(int[][]map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	
	static public int[][] solve(int[][] map, int[][] robot){
		//copy
		int[][] result = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				result[i][j] = map[i][j];
			}
		}
		
		result[robot[0][0]][1] = 0;
		result[robot[1][0]][1] = 0;
		for(int j=1; j<map[0].length-1; j++) {
			result[robot[0][0]][j+1] = map[robot[0][0]][j];
			result[robot[1][0]][j+1] = map[robot[1][0]][j];
		}
		
		for(int i=robot[0][0]; i>0; i--)
			result[i-1][map[0].length-1] = map[i][map[0].length-1];
		for(int i=robot[1][0]; i<map.length-1; i++)
			result[i+1][map[0].length-1] = map[i][map[0].length-1];
		
		for(int j=map[0].length-1; j>=1; j--) {
			result[0][j-1] = map[0][j];
			result[map.length-1][j-1] = map[map.length-1][j];
		}
		
		for(int i=0; i<robot[0][0]-1; i++)
			result[i+1][0] = map[i][0];
		
		for(int i=map.length-1; i>robot[1][0]+1; i--)
			result[i-1][0] = map[i][0];
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		int[][] map = new int[R][C];
		int[][] robot = new int[2][2];
		
		int idx = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					robot[idx][0] = i;
					robot[idx++][1] = j;
				}
			}
		}
		
		int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
		while(T>0) {
			//È®»ê
			int[][] tmp = new int[R][C];
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]>0) {
						int cnt = 0;
						for(int k=0; k<4; k++) {
							int next_i = i+moved[k][0];
							int next_j = j+moved[k][1];
							if(next_i>=0 && next_j>=0 && next_i<R && next_j<C && map[next_i][next_j] >=0) {
								cnt++;
								tmp[next_i][next_j] += map[i][j]/5;
								
							}
						}
						map[i][j] -= (map[i][j]/5)*cnt;
					}
				}
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] += tmp[i][j];
				}
			}
			
			map = solve(map,robot);
			T--;
		}
		
		int result=0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j]>0)
					result += map[i][j];
			}
		}
		
		System.out.println(result);
	}

}
