package baekjoon;
import java.util.*;

public class p10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			
			if(arr[0].equals("push")){
				stack.push(arr[1]);
			}
			else if(arr[0].equals("pop")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			}
			else if(arr[0].equals("size")) {
				System.out.println(stack.size());
			}
			else if(arr[0].equals("empty")) {
				if(stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(arr[0].equals("top")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}
		sc.close();
	}

}
