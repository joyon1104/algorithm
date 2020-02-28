package structure;
import java.util.*;


// 위상정렬
public class TopologySort {
	static int N;
	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> arrList;
	
	static void topology() {
		int result[] = new int[10];
		Queue<Integer> que = new LinkedList<Integer>();
		
		// 진입차수가 0인 노드를 큐에 삽입
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) que.offer(i);
		}
		// 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문해야 한다.
		for(int i=1; i<=N; i++) {
			//N개를 방문하기 전에 큐가 비어버리면 사이클이 발생한 것. -> 위상정렬 불가
			if(que.isEmpty()) {
				System.out.println("사이클이 발생했습니다.");
				return;
			}
			int x = que.poll();
			result[i] = x;
			for(int j=0; j<arrList.get(x).size(); j++) {
				int y = arrList.get(x).get(j); // 해당 노드와 연결되어있는 노드
				inDegree[y]--;
				if(inDegree[y] == 0)  // 새롭게 진입차수가 0이 된 정점을 큐에 삽입한다.
					que.offer(y);
			}
		}
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {
		N = 7;
		
		inDegree = new int[10];
		arrList = new ArrayList<ArrayList<Integer>>();
		// 초기화
		for(int i=0; i<N+1; i++) 
            arrList.add(new ArrayList<Integer>());
        
        arrList.get(1).add(2); // 1->2
        inDegree[2]++;  // 2의 진입차수 증가
        arrList.get(1).add(5);
        inDegree[5]++;
        arrList.get(2).add(3);
        inDegree[3]++;
        arrList.get(3).add(4);
        inDegree[4]++;
        arrList.get(4).add(6);
        inDegree[6]++;
        arrList.get(5).add(6);
        inDegree[6]++;
        arrList.get(6).add(7);
        inDegree[7]++;
        topology();
	}
	
}
