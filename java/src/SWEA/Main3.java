package SWEA;
import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int K = Integer.parseInt(sc.next());
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = (long)(Float.parseFloat(sc.next()) * 1000);
		}
		Arrays.sort(arr);
		long begin = 1;
		long end = arr[N-1];
		
		while(begin<=end) {
			long mid = (begin+end)/2;
			int num = 0;
			for(int i=0; i<N; i++) {
				num += arr[i]/mid;
			}
			if(num >= K)
				begin = mid+1;
			else
				end = mid-1;
		}
		String result = String.format("%.2f", end * 0.001);
		System.out.println(result);
	}
}
