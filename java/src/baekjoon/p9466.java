package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 190809
 * 
 * 백준 9466번
 * -> 분류 : DFS
 * 
 * [ 텀 프로젝트 ]
 * 
 * => 시간초과 
 */


public class p9466 {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> list= new ArrayList<Integer>();
	static int[] arr;
	
	public static void main(String[] args) {
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			int[] check = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=1; i<=n; i++) {
				Queue<Integer> que = new LinkedList<Integer>();
				if(check[i] == 1)
					continue; 
				
				que.add(i);
				check[i] =1;
				int tmp = arr[i];
				while(que.size()<=n) {
					if(que.peek() == tmp) {
						break;
					}
					else if(que.contains(tmp) == true)
						break;
					else {
						que.add(tmp);
						check[tmp] = 1;
						tmp = arr[tmp];
					}
				}
			}
			
			int a = 0;
			for(int i=1; i<=n; i++) {
				if(check[i] == 1)
					a++;
			}
			System.out.println(n-a);
		}
		
	}
	
}
