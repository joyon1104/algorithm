package baekjoon;
import java.util.*;

public class p11725_1 {
	
	static int N;
	static int [] visited;
	
	static class Node{
		int data;
		int parent;
		ArrayList<Integer> child;
		
		public Node(int data, int parent) {
			this.data = data;
			this.parent = parent;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new int[N+1];
		HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.add(0);
		hashmap.put(1,tmp);
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(!hashmap.containsKey(a) && !hashmap.containsKey(b)) {
				visited[a] = b;
				visited[b] = a;
			}
			else if(hashmap.containsKey(a) && !hashmap.containsKey(b)) {
				hashmap.get(a).add(b);  // a의 자식노드에 추가
				ArrayList<Integer> btmp = new ArrayList<Integer>();
				btmp.add(a);
				for(int j=1; j<=N; j++) {
					if(visited[j] == b) {
						btmp.add(j);
						visited[j] = -1;
						ArrayList<Integer> jtmp = new ArrayList<Integer>();
						jtmp.add(b);
						hashmap.put(j,jtmp);
					}
				}
				hashmap.put(b,btmp);
			}
			else if(!hashmap.containsKey(a) && hashmap.containsKey(b)) {
				hashmap.get(b).add(b);  // a의 자식노드에 추가
				ArrayList<Integer> atmp = new ArrayList<Integer>();
				atmp.add(b);
				for(int j=1; j<=N; j++) {
					if(visited[j] == a) {
						atmp.add(j);
						visited[j] = -1;
						ArrayList<Integer> jtmp = new ArrayList<Integer>();
						jtmp.add(a);
						hashmap.put(j,jtmp);
					}
				}
				hashmap.put(a,atmp);
			}
			
		}
		
		for(int i=2; i<=N; i++) {
			System.out.println(hashmap.get(i).get(0));
		}
	}

}
