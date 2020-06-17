package programmers;
/*
 * [가장 먼 노드]
 * 노드 정보 -> arraylist를 담는 arrlist 생성
 * BFS로 탐색, visited에 1에서 부터 거리를 저장 (실제 거리보다 1이 큼 -> 구분을 위해 visited[1]=1로 두고 노드를 뻗어나갈때마다 증가시켰기 때문) 
 */
import java.util.*;
class p200318_3 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> arrlist = new ArrayList<>();
        for(int i=0; i<=n; i++)
            arrlist.add(new ArrayList<Integer>());
        
        //ArrayList에 그래프 저장
        for(int i=0; i<edge.length; i++){
            arrlist.get(edge[i][0]).add(edge[i][1]);
            arrlist.get(edge[i][1]).add(edge[i][0]);
        }
        // 1부터 거리를 저장할 visited (0이면 방문한 적 없는 노드)
        int[] visited = new int[edge.length+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = 1;	// 방문여부를 구분하기 위해 1로 초기화 -> 실제 visited에 저장된 값 = 1부터 거리 +1 이됨.
        int max = 0;
        while(!que.isEmpty()){
            int tmp = que.poll();
            for(int i=0; i<arrlist.get(tmp).size(); i++){
                if(visited[arrlist.get(tmp).get(i)] == 0 ){
                    visited[arrlist.get(tmp).get(i)] = visited[tmp]+1;	// 1과 이전노드 사이의 거리 +1 = 1에서 현재노드까지의 거리 
                    que.add(arrlist.get(tmp).get(i));
                    if(max < visited[arrlist.get(tmp).get(i)])
                        max = visited[arrlist.get(tmp).get(i)];
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(visited[i] == max)
                answer++;
        }
        return answer;
    }
}