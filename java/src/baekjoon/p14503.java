package baekjoon;
import java.util.*;

public class p14503 {
	static int[][] moved = {{-1,0},{0,1},{1,0},{0,-1}};	// 북 동 남 서 => 문제 잘 읽고 방향 잘 생각할 것!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] robot = new int[3];
		robot[0] = sc.nextInt();
		robot[1] = sc.nextInt();
		robot[2] = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int result = 0;
		while(true) {
			if(map[robot[0]][robot[1]]==0)
				result++;
			map[robot[0]][robot[1]] = 2;
			
			boolean check = false;
			int next_i = 0;
			int next_j = 0;
			for(int i=0; i<4; i++) {
				int d = (robot[2]-1+4)%4;
				next_i = robot[0] + moved[d][0];
				next_j = robot[1] + moved[d][1];
				robot[2] = d;
				if(map[next_i][next_j] == 0) {
					check = true;
					break;
				}
			}
			if(check == true) {
				robot[0] = next_i;
				robot[1] = next_j;
			}
			else {
				int back_i = robot[0] + moved[(robot[2]+2)%4][0];
				int back_j = robot[1] + moved[(robot[2]+2)%4][1];;
				if(map[back_i][back_j] == 1)
					break;
				else {
					robot[0] = back_i;
					robot[1] = back_j;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
