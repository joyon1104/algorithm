package SWEA;
import java.util.*;

public class p4013 {

	// 자석 이동 확인을 위한 출력함수
	public static void printMg(int[][] magnet) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(magnet[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
	// 자석 이동 함수
	public static void turn(int[][] magnet, int n, int d){
		int[] tmp = new int[8];
		for(int i=0; i<8; i++) {
			if(i+d < 0)
				tmp[i+d+8] = magnet[n][i];
			else if(i+d>=8)
				tmp[i+d-8] = magnet[n][i];
			else
				tmp[i+d] = magnet[n][i];
		}
		for(int i=0; i<8; i++)
			magnet[n][i] = tmp[i];
	}
	
	public static void solve(int[][] magnet,int[] visited, int n, int d) {
		//turn(magnet,n,d);
		visited[n] = 1;		// 이미 회전여부를 판단한 자석은 다시 판단할 필요가 없으므로 이를 구분하기 위해 visited배열을 만들어 방문여부를 체크!
		if(n==0 && magnet[0][2] != magnet[1][6] && visited[1] == 0) {
			solve(magnet,visited,1,d*-1);
		}
		else if(n==1) {
			if(magnet[0][2] != magnet[1][6] && visited[0] == 0)
				solve(magnet,visited,0,d*-1);
			if(magnet[2][6] != magnet[1][2] && visited[2] == 0)
				solve(magnet,visited,2,d*-1);
		}
		else if(n==2) {
			if(magnet[1][2] != magnet[2][6] && visited[1] == 0)
				solve(magnet,visited,1,d*-1);
			if(magnet[3][6] != magnet[2][2] && visited[3] == 0)
				solve(magnet,visited,3,d*-1);
		}
		else if(n==3 && magnet[3][6] != magnet[2][2] && visited[2] == 0) {
			solve(magnet,visited,2,d*-1);
		}
		turn(magnet,n,d);	// 회전은 마지막에 해야함 -> 회전 전의 자석위치로 다음 회전할 자석을 선택하므로.. -> 재귀사용!
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int K = sc.nextInt();
			int[][] magnet = new int[4][8];
			for(int i=0; i<4; i++) {
				for(int j=0; j<8; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}
			
			for(int k=0; k<K; k++) {
				int n = sc.nextInt();
				int d = sc.nextInt();
				int[] visited = new int[4];
				solve(magnet,visited,n-1,d);	// 회전한 자석을 다음 회전에 그대로 반영하므로 새로운 자석객체를 만들 필요 없음!
//				printMg(magnet);
			}
			
			int result = 0;
			for(int i=0; i<4; i++) {
				if(magnet[i][0]==1)
					result+=Math.pow(2, i);
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
