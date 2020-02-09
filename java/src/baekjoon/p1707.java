package baekjoon;
import java.util.*;

/*
 * <이분그래프>
 * : 인접한 정점끼리 서로 다른 색으로 칠해서 모든 정점을 두가지 색으로만 칠할 수 있는 그래프.
 * => 그래프의 모든 정점이 두 그룹으로 나눠지고 같은 그룹에 속한 정점끼리는 서로 인접하지 않도록 하는 그래프
 * - 이중배열로 풀면 메모리 초과 발생
 * [참고] : https://gmlwjd9405.github.io/2018/08/23/algorithm-bipartite-graph.html
 * 
 */

public class p1707 {
	static int K;
	static int V;
	static int E;
	static boolean res;
	static ArrayList<ArrayList<Integer>> arrayLists;
	static int[] colors;
	
	static void DFS(int start, int color) {
		colors[start] = color;
		
		for(int adjv : arrayLists.get(start)) {
			if(colors[adjv]==color) {
				res = false;
				return;
			}
			
			if(colors[adjv]==0) {
				DFS(adjv,-color);
			}
		}
	}
	
	static void BFS(int start, int color) {
		Queue<Integer> que = new LinkedList<Integer>();
		colors[start] = color;
		que.offer(start);
		
		while(!(que.isEmpty())) {
			int temp = que.poll();
			int t_color = colors[temp];
			for(int adjv : arrayLists.get(temp)) {
				if(colors[adjv]==t_color) {
					res = false;
					return;
				}
				if(colors[adjv] == 0) {
					colors[adjv] = -t_color;
					que.offer(adjv);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		for(int k=0; k<K; k++) {
			V = sc.nextInt();
			E = sc.nextInt();
			res = true;
			arrayLists = new ArrayList<>();
			colors = new int[V+1];
			
			for (int i = 0; i < V + 1; i++) {
                arrayLists.add(new ArrayList<Integer>()); // 정점의 수 + 1만큼 초기화
                colors[i] = 0; // 방문하지 않은 정점의 색을 0으로 초기화
            }
			
			for(int i=0; i<E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arrayLists.get(x).add(y);
				arrayLists.get(y).add(x);
			}
			// 이분 그래프: 같은 레벨의 꼭짓점끼리는 무조건 같은 색, 인접한 정점 사이는 다른 색
            // 주의! 연결 그래프와 비연결 그래프(모든 정점을 돌면서 확인) 모두 고려!!
            for (int i = 1; i < V + 1; i++) {
                // 이분 그래프가 아니면 반복문 탈출
                if (!res)
                    break;

                // 방문하지 않은 정점에 대해서 탐색 수행
                if (colors[i] == 0) {
                    DFS(i, 1); /* 깊이 우선 탐색 */
//                    BFS(i, 1); /* 너비 우선 탐색 */
                }
            }
			if(res==true)
				System.out.println("YES");
			else
				System.out.println("NO");
//			
		}
	}
}
