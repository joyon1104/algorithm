package baekjoon;
import java.util.*;

public class p9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		for(int i=1; i<=N; i++) {
			String str = sc.nextLine();
			String[] arr = str.split("");
			int[] check = new int[2];
			boolean yn = true;
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j].equals("("))
					check[0] += 1;
				else {
					check[1] += 1;
					if(check[1] > check[0]) {
						yn = false;
						break;
					}
				}
			}
			if(check[0] == check[1])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		//스택 이용하기
//		while(n-->0) { 
//			boolean isVPS = true; 
//			String input = br.readLine(); 
//			Stack<Character> stack = new Stack<Character>(); 
//			char temp; 
//			for(i=0; i<input.length(); i++) { 
//				temp = input.charAt(i); 
//				if(temp == '(') { // 여는 괄호는 스택에 push하여 담는다. 
//					stack.push(temp);
//				}
//				else if(temp == ')') { // 닫는 괄호가 나온경우 스택의 맨 위의 값이 여는괄호인지 비교한다. 
//					if(!stack.isEmpty()) { // 스택이 비어있지 않고 맨위값이 여는 괄호라면 스택의 맨 위값을 pop한다. 
//						stack.pop(); 
//					}else { 
//						isVPS = false; 
//						break; 
//					} 
//				} 
//			}
//			if(!stack.isEmpty()) 
//				isVPS = false; 
//			if(isVPS)
//				System.out.println("YES"); 
//			else
//				System.out.println("NO"); 
//		}// end while
	}
}
