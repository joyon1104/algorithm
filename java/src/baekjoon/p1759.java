package baekjoon;
import java.util.*;

public class p1759 {
	static int L,C;
	
	static void dfs(String[] arr, int[] visited, String pwd, int n) {
		if(n == L) {
			String[] password = pwd.split("");
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<pwd.length(); i++) {
				if(password[i].equals("a") || password[i].equals("e") || password[i].equals("i") || password[i].equals("o") || password[i].equals("u"))
					n1++;
				else n2++;
			}
			if(n1>=1 && n2>=2)
				System.out.println(pwd);
		}
		
		else {
			for(int i=0; i<visited.length; i++) {
				if(n==0) {
					visited[i] = 1;
					dfs(arr,visited, pwd+arr[i], n+1);
					visited[i] = 0;
				}
				else if(visited[i] == 0 && arr[i].compareTo(pwd.substring(pwd.length()-1))>0 ) {
					visited[i]=1;
					dfs(arr, visited, pwd+arr[i], n+1);
					visited[i] = 0;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		String[] arr = new String[C];
		
		for(int i=0; i<C; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		int[] visited = new int[C];
		String pwd = "";
		
		dfs(arr,visited,pwd,0);
	}
}
