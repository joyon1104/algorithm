package baekjoon;
import java.util.*;

public class p11725 {
	
	static int N;
	static int [] parent;
	static int [] visited;
	static LinkedList<LinkedList<Integer>> tree;
	
	static void bfs(int root) {
		Queue<Integer> que = new LinkedList<>();
		que.add(root);
		visited[1] = 1;
		while(!que.isEmpty()) {
			int p = que.poll();
			for(int i=0; i<tree.get(p).size(); i++) {
				if(visited[tree.get(p).get(i)] != 1) {
					parent[tree.get(p).get(i)] = p;
					visited[tree.get(p).get(i)] = 1;
					que.offer(tree.get(p).get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parent = new int[N+1];
		visited = new int[N+1];
		tree = new LinkedList<LinkedList<Integer>>();
		
		for(int i=0; i<=N; i++)
			tree.add(new LinkedList<Integer>());

		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		bfs(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
	}

}
