package baekjoon;
import java.util.*;

public class p1717 {
	static int n,m;
	static int[] parents;
	
	static int getParent(int n) {
		if(parents[n] == n)
			return n;
		else
			return parents[n] = getParent(parents[n]);
	}
	
	static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a<b)
			parents[b] = a;
		else
			parents[a] = b;
	}
	
	static boolean isSameParent(int a, int b) {
		if(getParent(a)==getParent(b))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++)
			parents[i] = i;
		
		for(int i=0; i<m; i++) {
			int c = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(c == 0) {
				unionParent(a,b);
			}
			else {
				if(isSameParent(a,b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
