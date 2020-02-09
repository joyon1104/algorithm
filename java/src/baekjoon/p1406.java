package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * stack으로 풀어야 시간초과가 나지 않는다.
 * Scanner보다 BufferedReader로 풀어야 훨씬 빠름.
 */

public class p1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		
		for (int i=0; i<s.length(); i++) {
			stack1.push(Character.toString(s.charAt(i)));
		}
		
		for(int i=0; i<n; i++) {
			String ss = br.readLine();
			String[] ls = ss.split(" ");
			
			switch(ls[0]) {
				case "P":
					stack1.push(ls[1]);
					break;
				case "L":
					if(!(stack1.isEmpty())) {
						stack2.push(stack1.pop());
					}
					break;
				case "D":
					if(!(stack2.isEmpty())) {
						stack1.push(stack2.pop());
					}
					break;
				case "B":
					if (!(stack1.isEmpty())){
						stack1.pop();
					}
					break;
			}
		}

		while(!(stack1.isEmpty())) {
			stack2.push(stack1.pop());
		}
		while(!(stack2.isEmpty())) {
			System.out.print(stack2.pop());
		}		
	}
}
