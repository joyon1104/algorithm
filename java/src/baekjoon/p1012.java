package baekjoon;

import java.util.List;
import java.util.Scanner;

//유기농 배추

public class p1012 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
	static int[][] ground;
	static int X;
	static int Y;
    
	public static void main(String[] args) {
		int ntest = scanner.nextInt();
		
		for (int t=0; t < ntest; t++) {
			Y = scanner.nextInt();
			X = scanner.nextInt();
			int n = scanner.nextInt();
			int cnt = 0;
			
			ground = new int[Y][X];
			
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					ground[i][j] = 0;
				}
			}
			
			for (int j=0; j < n; j++){
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				System.out.println(x + " " + y);
				ground[x][y] = 1;
			}
			
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (ground[i][j] != 0) {
                        DFS(i, j);
                        //배추 수확
                        cnt++;
                    }
				}
			}
			System.out.println(cnt);
		}//
	}//main
	
	public static void DFS(int X, int Y) {
		 
        for (int i = 0; i < 4; i++) {
            //다음 방문지 nextX,와 nextY
            int nextX = X + dx[i];
            int nextY = Y + dy[i];
 
            //nextX, nextY가 범위를 벗어난다면 그냥 통과한다.
            if (nextX < 0 || nextY < 0 || nextX >= Y || nextY >= X) {
                continue;
            }
            //다음 방문할 값이 0 이라면 그냥 통과한다.
            if (ground[nextX][nextY] == 0) {
                continue;
            }
            //방문한점은 0으로 바꿔준다.
            ground[nextX][nextY] = 0;
            DFS(nextX, nextY);
        }
    }
	
}
