package baekjoon;
import java.util.*;

public class p10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinkedList<Integer> que = new LinkedList<Integer>();

		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			String[] ls = s.split(" ");
			
			if(ls[0].equals("push")) {
				que.offer(Integer.parseInt(ls[1]));
			}
			else if(ls[0].equals("pop")) {
				if (que.isEmpty())
					System.out.println(-1);
				else
					System.out.println(que.poll());
			}
			else if(ls[0].equals("size")) {
				System.out.println(que.size());	
			}
			else if(ls[0].equals("empty")) {
				if(que.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(ls[0].equals("front")) {
				if(que.isEmpty())
					System.out.println(-1);
				else
					System.out.println(que.peek());
			}
			else if(ls[0].equals("back")) {
				if(que.isEmpty())
					System.out.println(-1);
				else
					System.out.println(que.get(que.size()-1));
			}
		}
	}
}
