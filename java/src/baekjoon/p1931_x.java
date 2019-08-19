package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 190819
 * 
 * 백준 1931번
 * -> 분류 : 탐욕법
 * 
 * [ 회의실 배정 ]
 * 
 * => 메모리 초과 
 * 
 */

public class p1931_x {

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static int x;
	static int y;
	static int result = 0;
	
	static int find(int[][] map, int x_length, int y_length, int q, int max) {
		if(q < x_length) {
			for(int i=q; i<y_length; i++) {
				if(map[q][i] == 1) {
					find(map,x_length, y_length,i,++max);
				}
			}
		}
		
		if(result < max)
			result = max;
		
		return result;
	}
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		
		for(int n=0; n<N; n++) {
			X.add(sc.nextInt());
			Y.add(sc.nextInt());
		}
		
		x = Collections.max(X);
		y = Collections.max(Y);
		
		int[][] map = new int[x+1][y+1];
		
		for(int n=0; n<N; n++) {
			int xx = X.get(n);
			int yy = Y.get(n);
			map[xx][yy] = 1;
		}
		
		
		for(int n=0; n<N; n++) {
			int xx = X.get(n);
			int yy = Y.get(n);
			find(map, x+1, y+1, yy, 1);
		}
		
		System.out.println(result);	
			
	}
	
}
