package baekjoon;
import java.util.*;

public class p11728 {
	static int N;
	static int M;
	static int[] A;
	static int[] B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		B = new int[M];
		int[] C = new int[N+M];
		
		for(int i=0; i<N; i++)
			A[i] = sc.nextInt();
		for(int i=0; i<M; i++)
			B[i] = sc.nextInt();
		
		int a=0; int b=0;
		int c = 0;
		
		while(a<N&&b<M) {
			if(A[a] < B[b])
				C[c++] = A[a++];
			else
				C[c++] = B[b++];
		}
		while(a<N)
			C[c++] = A[a++];	
		while(b<M)
			C[c++] = B[b++];
		
		for(int i=0; i<N+M; i++)
			System.out.print(C[i]+" ");
	}
}
