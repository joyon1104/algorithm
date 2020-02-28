package baekjoon;
import java.util.*;

public class p10816 {
	static int N,M;
	static int[] mycard;
	static int[] ncard;
	
	static int check(int find) {
		int start = 0;
		int end = mycard.length-1;
		int ans = 0;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(mycard[mid] == find) {
				ans++;
				for(int i=mid-1; i>=0; i--) {
					if(mycard[i] != find)
						break;
					else
						ans++;
				}
				for(int i=mid+1; i<N; i++) {
					if(mycard[i] != find)
						break;
					else
						ans++;
				}
				break;
			}
			else if(mycard[mid] < find) {
				start = mid+1;
			}
			else if(mycard[mid] > find) {
				end = mid-1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mycard = new int[N];
		for(int i=0; i<N; i++) {
			mycard[i] = sc.nextInt();
		}
		Arrays.sort(mycard);
		M = sc.nextInt();
		
		ncard = new int[M];
		for(int i=0; i<M; i++) {
			ncard[i] = sc.nextInt();
		}
		for(int i=0; i<M; i++) {
			System.out.print(check(ncard[i])+" ");
		}
	}
}
