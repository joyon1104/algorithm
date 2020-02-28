package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Node {
	int node, dist;
	public Node(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}
public class p1167 {
	static List<Node>[] list;
	static boolean[] visit;
	static Node maxNode;
	static int max = 0, n;
	
	private static Node dfs(Node v, int dist) {
		visit[v.node] = true;
		
		for(Node tmp : list[v.node]) {
			if(!visit[tmp.node]) dfs(tmp, dist + tmp.dist);
		}
		
		if(max < dist) {
			maxNode = v; max = dist;
		}
		return maxNode;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node maxx; n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1]; 
		visit = new boolean[n+1];
		for(int i = 0; i <= n; i++) 
			list[i] = new ArrayList<>();
		
		list[0].add(new Node(1, 0));
		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("\\s");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			
			list[a].add(new Node(b, c)); list[b].add(new Node(a, c));
			for(int j = 3; j < tmp.length; j += 2) {
				if(tmp[j].equals("-1")) break;
				b = Integer.parseInt(tmp[j]); c = Integer.parseInt(tmp[j+1]);
				list[a].add(new Node(b, c)); list[b].add(new Node(a, c));
			}
		}
		
		maxx = dfs(list[0].get(0), 0); visit = new boolean[n+1]; maxNode = null; max = 0;
		dfs(maxx, 0);
		System.out.print(max);
	}
}