package baekjoon;
import java.util.*;

public class p2606 {
	static int n,m;
	
	static int getParent(int[] parents, int n) {
		if(parents[n] == n)
			return n;
		else
			return getParent(parents, parents[n]);
	}
	
	static void unionParent(int[] parents, int a, int b) {
		a = getParent(parents,a);
		b = getParent(parents,b);
		
		if(a<b)
			parents[b] = a;
		else
			parents[a] = b;
	}
	
	static boolean isSameParent(int[] parents, int a, int b) {
		if(getParent(parents,a) == getParent(parents,b))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int answer = 0;
		int[] parents = new int[n+1];
		
		for(int i=1; i<=n; i++)
			parents[i] = i;
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(parents,a,b);
		}
		
		for(int i=1; i<=n; i++) {
			if(i > 1 && isSameParent(parents,1,i))
				answer++;
		}
		System.out.println(answer);
	}
}
