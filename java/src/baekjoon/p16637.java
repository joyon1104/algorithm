package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16637 {

	static int N, max;
	static Scanner sc = new Scanner(System.in);
	
	static class Pair{
		int first;
		int second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static public int makeOne(int[] number, String[] compute, boolean[] visited, Queue<Pair> que) {
		int oneline = 0;
		int check = 1; //1: 더하기, 2:빼기, 3: 곱하기
		
		int i=0;
		while(i<N) {
			if(i%2 == 0 && visited[i]== true) {
				
				Pair p = que.poll();
					
				int f = number[p.first];
				int s = number[p.second];
				
				int center = (p.first + p.second)/2;
				int tmp = 0;
				
				if(compute[center].equals("+"))
					tmp = f+s;
				else if(compute[center].equals("-"))
					tmp = f-s;
				else if(compute[center].equals("*"))
					tmp = f*s;
				
				if(check == 1)
					oneline+= tmp;
				else if(check ==2)
					oneline -= tmp;
				else if(check == 3)
					oneline *= tmp;
				
				i = p.second+1;
			}
			else if(i%2 == 1) {
				if(compute[i].equals("+"))
					check = 1;
				else if(compute[i].equals("-"))
					check = 2;
				else if(compute[i].equals("*"))
					check = 3;
				i++;
			}
			
			else {
				if(check == 1)
					oneline+= number[i];
				else if(check == 2)
					oneline -= number[i];
				else if(check == 3)
					oneline *= number[i];
				i++;
			}
		}
		
		System.out.println(oneline);
		return oneline;
		
	}
	/*
	static public int findResult(String line) {
		String[] arr;
		arr = line.split("");
		
		int result = 0;
		int check = 1; //1: 더하기, 2:빼기, 3: 곱하기 , 0: 숫자
		
		for(int i=0; i<arr.length; i++) {
			if(check == 1 && !(arr[i].equals("+")) && !(arr[i].equals("-")) && !(arr[i].equals("*"))) {
				result += Integer.parseInt(arr[i]);
			}
			else if(check == 2 && !(arr[i].equals("+")) && !(arr[i].equals("-")) && !(arr[i].equals("*"))) {
				result += Integer.parseInt(arr[i]);
			}
			else if(check == 3 && !(arr[i].equals("+")) && !(arr[i].equals("-")) && !(arr[i].equals("*"))) {
				result += Integer.parseInt(arr[i]);
			}
		}
	}
	*/
	
	public static void DFS(int[] number, String[] compute, boolean[] visited, Queue<Pair> que, int n) {
		if(n >= N-1) {
			int result = makeOne(number, compute, visited, que);
			System.out.println("------");
			if(result>max)
				max = result;
			return;
		}
		else {
			for(int i=n; i<N-1; i+=2) {
				DFS(number, compute, visited, que, i+2);
				visited[i] = true;
				visited[i+2] = true;
				Pair p = new Pair(i,i+2);
				que.add(p);
				System.out.println(p.first + " " + p.second);
				DFS(number, compute, visited, que, i+4);
				visited[i] = false;
				visited[i+2] = false;
				que.remove(p);
			}
			
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		int[] number = new int[N];
		String[] compute;
		
		String line = sc.next();
		compute = line.split("");
		
		for(int i=0; i<N; i+=2) {
			number[i] = Integer.parseInt(compute[i]);
		}
		
		Queue<Pair> que = new LinkedList<Pair>();
		boolean[] visited = new boolean[N];
		
		DFS(number, compute, visited, que, 0);
		
		System.out.println(max);
	}
}
