package baekjoon;
import java.util.*;

public class p13460_1 {
	static int N,M;
	static char[][] map;
	static int[] hole;
	static int min;

	public static int[] find(int i, int[] first, int[] second, boolean check) {
		int[] result = new int[4];
		int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
		if(first[0]+moved[i][0] >=0 && first[1]+moved[i][1] >=0 && first[0]+moved[i][0] < N && first[1]+moved[i][1] < M) {
			while(true) {
				first[0] += moved[i][0];
				first[1] += moved[i][1];
				if(map[first[0]][first[1]] == '#') {
					first[0] -= moved[i][0];
					first[1] -= moved[i][1];
					break;
				}
				else if(map[first[0]][first[1]] == 'O') {
					first[0] = -1;
					break;
				}
			}
		}
		if(second[0]+moved[i][0] >=0 && second[1]+moved[i][1] >=0 && second[0]+moved[i][0] < N && second[1]+moved[i][1] < M) {
			while(true) {
				second[0] += moved[i][0];
				second[1] += moved[i][1];
				if(map[second[0]][second[1]] == '#') {
					second[0] -= moved[i][0];
					second[1] -= moved[i][1];
					break;
				}
				else if(map[second[0]][second[1]] == 'O') {
					second[0] = -1;
					break;
				}
				else if(second[0]==first[0] && second[1]==first[1]) {
					second[0] -= moved[i][0];
					second[1] -= moved[i][1];
					break;
				}
			}
		}
		if(check==true) {
			result[0] = first[0]; result[1] = first[1]; result[2] = second[0]; result[3] = second[1];
		}
		else
			result[0] = second[0]; result[1] = second[1]; result[2] = first[0]; result[3] = first[1];
		return result;
	}
	
	public static void dfs(int[] red, int[]blue, int dict, int cnt) {
		if(cnt > 10) {
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				if(i==dict)	continue;
				int[] result;
				if(i==0) {
					if(blue[0] > red[0])
						result = find(i,blue,red,false);
					else 
						result = find(i,red,blue,true);
				}
				else if(i==1) {
					if(blue[1] > red[1])
						result = find(i,blue,red,false);
					else 
						result = find(i,red,blue,true);
				}
				else if(i==2) {
					if(blue[0] < red[0])
						result = find(i,blue,red,false);
					else 
						result = find(i,red,blue,true);
				}
				else {
					if(blue[1] < red[1])
						result = find(i,blue,red,false);
					else 
						result = find(i,red,blue,true);
				}
				int[] next_red = new int[2];
				int[] next_blue = new int[2];
				next_red[0] = result[0]; next_red[1] = result[1];
				next_blue[0] = result[2]; next_blue[1] = result[3];
				if(next_red[0] == -1 && next_blue[0] != -1) 
					min = (cnt < min ? cnt : min);
				else if(next_blue[0] == -1)
					continue;
				else {
					dfs(next_red,next_blue,i,cnt+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);
		map = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];
		hole = new int[2];
		min = 11;
		for(int i=0; i<N; i++) {
			s = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='R') {
					red[0] = i;
					red[1] = j;
				}
				else if(map[i][j]=='B') {
					blue[0] = i;
					blue[1] = j;
				}
				else if(map[i][j]=='O') {
					hole[0] = i;
					hole[1] = j;
				}
			}
		}
		dfs(red,blue,-1,1);
////		if(min >= 11)
//			System.out.println(-1);
//		else
			System.out.println(min);
	}
}
