package baekjoon;
import java.util.*;

public class p10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sent = sc.next();
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		
		for(int i=0; i<sent.length(); i++) {
			if(sent.substring(i,i+1).contentEquals("("))
				stack.push(i);
			else {
				if(stack.peek()==i-1) {
					stack.pop();
					res += stack.size();
				}
				else {
					stack.pop();
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
