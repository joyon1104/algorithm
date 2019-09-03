package baekjoon;

import java.util.Scanner;

/*
 * 190829
 * 
 * 백준 삼성 A형 기출 문제
 * 
 * 17070번 
 * [파이프 옮기기 1]
 * 
 * -> 성공
 * 
 * 문제 분류 : DFS
 * 
 */

public class p17070 {

	static int N;
	static int result;
	
	static Scanner sc = new Scanner(System.in);
	
	static class Pair{
		int i;
		int j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void compute(int[][]map, Pair head, Pair tail, int move) {
		if(head.i == N && head.j == N) {
			result++;
			return;
		}
		
		if(move == 1) {
			if((head.j+1)<= N && map[head.i][head.j+1] == 0) {
				Pair hhead = new Pair(head.i, head.j+1);
				Pair ttail = head;
				compute(map, hhead, ttail, 1);
			}
			if(head.i+1<=N && head.j+1 <=N && map[head.i+1][head.j] == 0 && map[head.i][head.j+1] == 0 && map[head.i+1][head.j+1] == 0) {
				Pair hhead = new Pair(head.i+1, head.j+1);
				Pair ttail = head;
				compute(map, hhead, ttail, 3);
			}
			else return;
		}
		
		else if (move ==2) {
			if((head.i+1)<= N && map[head.i+1][head.j] == 0) {
				Pair hhead = new Pair(head.i+1, head.j);
				Pair ttail = head;
				compute(map, hhead, ttail, 2);
			}
			if(head.i+1<=N && head.j+1 <=N && map[head.i+1][head.j] == 0 && map[head.i][head.j+1] == 0 && map[head.i+1][head.j+1] == 0) {
				Pair hhead = new Pair(head.i+1, head.j+1);
				Pair ttail = head;
				compute(map, hhead, ttail, 3);
			}
			else return;
		}
		
		else {
			if((head.j+1)<= N && map[head.i][head.j+1] == 0) {
				Pair hhead = new Pair(head.i, head.j+1);
				Pair ttail = head;
				compute(map, hhead, ttail, 1);
			}
			if((head.i+1)<= N && map[head.i+1][head.j] == 0) {
				Pair hhead = new Pair(head.i+1, head.j);
				Pair ttail = head;
				compute(map, hhead, ttail, 2);
			}
			if(head.i+1<=N && head.j+1 <=N && map[head.i+1][head.j] == 0 && map[head.i][head.j+1] == 0 && map[head.i+1][head.j+1] == 0) {
				Pair hhead = new Pair(head.i+1, head.j+1);
				Pair ttail = head;
				compute(map, hhead, ttail, 3);
			}
			else return;
		}
		return;
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Pair head = new Pair(1,2);
		Pair tail = new Pair(1,1);	//tail은 굳이 필요 없음**
		int move = 1;
		compute(map, head, tail, move);
		
		System.out.println(result);
		
	}
}
