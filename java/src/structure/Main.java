package structure;

import java.io.*;
import java.util.*;

class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N =0;
	
	public static int dequeue(int[] arr, ArrayList<Integer> list) {
		int max = arr[0];

		for (int i=0; i<arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int out = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(arr[list.get(i)] == max) {
				arr[list.get(i)] = arr[list.get(i)]-1;
				out = list.get(i);
				list.remove(i);
				break;
			}
		}
		return out;
	}
	
	public static void main(String[] args) throws Exception {
		N = sc.nextInt();
		
		int[] arr = new int[100+1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<=N; i++) {
			String str = sc.nextLine();
			String[] sarr = str.split(" ");
			
			if(sarr[0].equals("enqueue")) {
				int n = Integer.parseInt(sarr[1]);
				arr[n] = arr[n]+1;
				list.add(n);
			}
			
			else if(sarr[0].equals("dequeue")) {
				if(list.size() != 0)
					System.out.print(dequeue(arr, list));
				else
					System.out.print(-1);
				
				if(i<N)	System.out.print(" ");
			}	
		}
	}
}

