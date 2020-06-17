package SWEA;
import java.util.*;

public class p4014_1 {
	static int result;
	
	public static void solve(int[] arr, int X) {
		Stack<Integer> stack = new Stack<>();
		boolean check = true;
		for(int i=0; i<arr.length; i++) {
			if(stack.isEmpty())
				stack.push(arr[i]);
			else {
				if(stack.peek()==arr[i])
					stack.push(arr[i]);
				else if(stack.peek()-arr[i] == -1) {
					if(stack.size()>=X) {
						stack.clear();
						stack.push(arr[i]);
					}
					else {
						check = false;
						break;
					}
				}
				else if(stack.peek()-arr[i] == 1) {
					int cnt = 0;
					int j=0;
					for(j=i; j<arr.length; j++) {
						if(arr[j]== arr[i])
							cnt++;
						else
							break;
						if(cnt == X)
							break;
					}
					if(cnt < X) {
						check = false;
						break;
					}
					else {
						if(j+1==arr.length)
							break;
						else {
							if(arr[j+1]==arr[i]) {
								stack.clear();
								stack.push(arr[j+1]);
								i=j+1;
							}
							else if(arr[j+1]>arr[i]) {
								check = false;
								break;
							}
							else if(arr[j+1]<arr[i]) {
								stack.push(arr[i]);
								i=j;
							}
						}
					}
						
				}
				else {
					check = false;
					break;
				}
			}
		}
		if(check == true) {
			result++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = 0;
			int N = sc.nextInt();
			int X = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				int[] arr = new int[N];
				for(int j=0; j<N; j++)
					arr[j] = map[i][j];
				solve(arr,X);
			}
			
			for(int j=0; j<N; j++) {
				int[] arr = new int[N];
				for(int i=0; i<N; i++)
					arr[i] = map[i][j];
				solve(arr, X);
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
