package SWEA;
import java.util.*;

public class p2115_1 {
	static int max;
	static int tmp;
	
	public static void dfs (int[]arr, int[]check, int C, int cnt) {
		if(cnt>=arr.length) {
			int n = 0;
			int sum = 0;
			for(int i=0; i<check.length; i++) {
				n += arr[i]*check[i];
				sum += Math.pow(arr[i]*check[i], 2);
			}
			
			if(n <= C && sum > tmp)
				tmp = sum;
		}
		else {
			check[cnt] = 1;
			dfs(arr,check,C,cnt+1);
			check[cnt] = 0;
			dfs(arr,check,C,cnt+1);
		}
	}
	
	// 최대 이익 계산 함수
	public static void compute(int[][] map, int M, int C, int x, int y, int p, int q) {
		int[] A = new int[M];
		int[] B = new int[M];
		//최대 이익
		int sum1 = 0;	
		int sum2 = 0;
		
		// 채취한 꿀이 C를 넘기는 지 확인을 위한 변수
		int n1 = 0;
		int n2 = 0;
		
		for(int j=0; j<M; j++) {
			A[j] = map[x][y+j];
			B[j] = map[p][q+j];
			sum1 += A[j]*A[j];	n1 += A[j];
			sum2 += B[j]*B[j];	n2 += B[j];
		}
		
		int[] arr = new int[M];
		if(n1>C) {
			tmp = 0;
			dfs(A,arr,C,0);
			sum1 = tmp;
		}
		
		if(n2>C) {
			tmp = 0;
			dfs(B,arr,C,0);
			sum2 = tmp;
		}
		
		if(sum1+sum2 > max)
			max = sum1+sum2;
	}
	
	public static void solve(int[][]map, int M, int C, int i, int j) {
		// 두 일꾼이 같은 행일 때
		for(int q=j+M; q<map[0].length; q++) {
			if(q+M > map[0].length)
				break;
			else {
				compute(map,M,C,i,j,i,q);
			}
		}
		
		// 두 일꾼이 다른행일 때
		for(int p=i+1; p<map.length; p++) {
			for(int q=0; q<=map[0].length-M; q++) {
				compute(map,M,C,i,j,p,q);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int C = sc.nextInt();
			max = 0;
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					solve(map,M,C,i,j);
				}
			}
			
			int result = max;
			System.out.println("#"+t+" "+result);
		}
	}
}
