package baekjoon;
import java.util.*;

public class p1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int term = sc.nextInt();
		
		LinkedList<Integer> ls = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			ls.add(i);
		}
		
		LinkedList<Integer> res = new LinkedList<>();
		int now = 0;
		while(ls.size()!=0) {
			int idx = (now+term-1) % ls.size();
			res.add(ls.get(idx));
			ls.remove(idx);
			now = idx;
		}
		String result = String.valueOf(res);
		System.out.println(result.replace("[", "<").replace("]", ">"));
	}
}
