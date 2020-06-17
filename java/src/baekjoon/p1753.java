package baekjoon;
import java.util.*;

public class p1753 {
	static int v,e,k;
	static int[][] adj;
	static int[] path;
	static int INF = Integer.MAX_VALUE;
	
	static class Pair implements Comparable<Pair>{
		int idx;
		int dist;
		
		public Pair(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pair target) {
			if(this.dist < target.dist)
				return -1;
			else if(this.dist > target.dist)
				return 1;
			else return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		k = sc.nextInt();
		
		path = new int[v+1];	// path배열 :시작점으로부터 해당 노드까지의 최소 비용을 담는 배열
		Arrays.fill(path, INF);	// 1. 초기값 INF로 설정
		
		// 2. 간선 정보를 담을 arrlist 생성
		ArrayList<ArrayList<Pair>> arrlist = new ArrayList<>();
		for(int i=0; i<=v; i++)	//초기화
			arrlist.add(new ArrayList<Pair>());
		
		// 3. 간선 정보를 입력받아 arrlist에 저장
		for(int i=0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			arrlist.get(a).add(new Pair(b,w));
		}
		
		// 4. 우선순위큐 -> 비용이 작은 순서대로 저장됨. (Pair)
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		// 5. 시작점 k에 대해 path[k]를 0으로 설정 -> 우선순위 큐에 삽입
		path[k] = 0;
		pq.offer(new Pair(k,path[k]));
		
		// 6. 우선순위 큐가 빌 때까지 탐색 
		while(!pq.isEmpty()) {
			Pair current = pq.poll();	// 1) 우선순위 큐이므로 비용이 제일 작은 값부터 나온다.
            if(current.dist > path[current.idx]){	// 2) 기존 저장된 비용이 더 작은 경우 계산하지 않는다.
                continue;
            }
            
            //3) 기존 비용보다 현재 비용이 더 큰 경우
            for(Pair p : arrlist.get(current.idx)) {	// 4) current와 연결된 노드 탐색
            	if(path[p.idx] > path[current.idx] + p.dist) {	// 5) 기존 p노드에 저장된 최소비용이 계산된 최소비용보다 큰 경우
            		path[p.idx] = path[current.idx] + p.dist;
            		pq.offer(new Pair(p.idx,path[p.idx]));		// 6) 최소비용을 재설정하고 다시 우선순위 큐에 넣는다
            	}
            }
		}
		
		// 7. 시작점으로 부터 모든 노드까지의 최소비용 출력
		for(int i=1; i<=v; i++) {
			if(path[i] < INF)
				System.out.println(path[i]);
			else
				System.out.println("INF");
		}
	}
}
