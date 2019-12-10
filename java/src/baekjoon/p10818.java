package baekjoon;
import java.util.Scanner;

public class p10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 1000000;
		int max = -1000000;
		
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			if(tmp>max)
				max = tmp;
			if(tmp<min)
				min = tmp;
		}
		System.out.println(min + " " + max);
	
	/* 배열에 모두 담고 Arrays.sort(array)로 정렬
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.print(arr[0]+" "+arr[N-1]);
		
		sc.close();
	}
	*/
	}
}
