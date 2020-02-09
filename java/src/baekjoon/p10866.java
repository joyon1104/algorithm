package baekjoon;
import java.util.*;

// https://skyvvv624.blog.me/220950557929

public class p10866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Deque<Integer> deque = new LinkedList<>();
	
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			String[] ls = s.split(" ");
			
			if(ls[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(ls[1]));
			}
			else if(ls[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(ls[1]));
			}
			else if(ls[0].equals("pop_front")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollFirst());
			}
			else if(ls[0].equals("pop_back")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollLast());
			}
			else if(ls[0].equals("size")) {
				System.out.println(deque.size());
			}
			else if(ls[0].equals("empty")) {
				if(deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(ls[0].equals("front")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekFirst());
			}
			else if(ls[0].equals("back")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekLast());
			}	
		}
	}
}
