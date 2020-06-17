package baekjoon;
import java.util.*;

public class p14890 {
	static int result;
	
	public static void solve(int[] arr, int L) {
		Stack<Integer> s1 = new Stack<>();
		boolean check = true;
		
		for(int i=0; i<arr.length; i++) {
			if(s1.isEmpty()) {
				if(i==0)
					s1.push(arr[i]);
				else {
					if(arr[i-1] < arr[i]) {
						check = false;
						break;
					}
					else if(arr[i-1] == arr[i])
						s1.push(arr[i]);
					else {
						s1.push(arr[i-1]);
						i--;
					}
						
				}
			}
			else {
				if(s1.peek() == arr[i])
					s1.push(arr[i]);
				else if(s1.peek()-arr[i]==-1 && s1.size() >= L) {
					if(s1.size()>=L) {
						s1.clear();
						s1.push(arr[i]);
					}
					else {
						check = false;
						break;
					}
				}
				else if(s1.peek()-arr[i]== 1) {
					s1.clear();
					s1.push(arr[i]);
					for(int j=i+1; j<arr.length; j++) {
						if(s1.size()==L) {
							i = j-1;
							break;
						}
						if(s1.peek()==arr[j])
							s1.push(arr[j]);
						else
							break;
					}
					if(s1.size() < L) {
						check = false;
						break;
					}
					s1.clear();
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
		int N = sc.nextInt();
		int L = sc.nextInt();
		result = 0;
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// Çà Å½»ö
		for(int i=0; i<N; i++) {
			int[] arr = new int[N];
			for(int j=0; j<N; j++) {
				arr[j] = map[i][j];
			}
			solve(arr,L);
		}
		
		// ¿­ Å½»ö
		for(int j=0; j<N; j++) {
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = map[i][j];
			}
			solve(arr,L);
		}
		System.out.println(result);
	}
}
