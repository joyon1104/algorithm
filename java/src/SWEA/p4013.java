package SWEA;
import java.util.*;

public class p4013 {

	// �ڼ� �̵� Ȯ���� ���� ����Լ�
	public static void printMg(int[][] magnet) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(magnet[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
	// �ڼ� �̵� �Լ�
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
		visited[n] = 1;		// �̹� ȸ�����θ� �Ǵ��� �ڼ��� �ٽ� �Ǵ��� �ʿ䰡 �����Ƿ� �̸� �����ϱ� ���� visited�迭�� ����� �湮���θ� üũ!
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
		turn(magnet,n,d);	// ȸ���� �������� �ؾ��� -> ȸ�� ���� �ڼ���ġ�� ���� ȸ���� �ڼ��� �����ϹǷ�.. -> ��ͻ��!
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
				solve(magnet,visited,n-1,d);	// ȸ���� �ڼ��� ���� ȸ���� �״�� �ݿ��ϹǷ� ���ο� �ڼ���ü�� ���� �ʿ� ����!
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
