package baekjoon;
import java.util.*;

public class p1080 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int N = Integer.parseInt(s.split(" ")[0]);
		int M = Integer.parseInt(s.split(" ")[1]);
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		for(int i=0; i<N; i++) {
			s = sc.nextLine();
			for(int j=0; j<M; j++)
				A[i][j] = Integer.parseInt(s.substring(j,j+1));
		}
		for(int i=0; i<N; i++) {
			s = sc.nextLine();
			for(int j=0; j<M; j++)
				B[i][j] = Integer.parseInt(s.substring(j,j+1));
		}
		
		int result = 0;
		if(N>=3 && M>=3) {
			for(int i=0; i<=N-3; i++) {
				for(int j=0; j<=M-3; j++) {
					if(A[i][j] != B[i][j]) {
						for(int p=0; p<3; p++) {
							for(int q=0; q<3; q++) {
								if(A[i+p][j+q]==0) A[i+p][j+q]=1;
								else A[i+p][j+q]= 0;
							}
						}
						result++;
					}
				}
			}
		}
		
		boolean check = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j]) {
					check = false;
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(result);
	}

}
