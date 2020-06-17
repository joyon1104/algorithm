package programmers;
/*
 * [순위]
 * - 플로이드와샬 알고리즘
 * - 플로이드와샬 알고리즘을 사용해 모든 노드에서 모든 노드로 가는 비용을 계산한 이차원 배열을 구한다.
 * - 1~n까지의 노드가 순위를 알 수 있는지 판별한다.
 * 	=> ex) 2번노드의 순위 판단 여부를 알고 싶으면, 1~n까지의 노드 i가 arr[i][2] 나 arr[2][i]가 INF이면 안됨.
 * 			=> 즉, arr[i][2] == INF && arr[2][i] == INF 이면 2번 노드는 i번 노드와의 우열을 가릴 수 없게되므로 순위를 알 수 없다.
 */

class p200325_1 {
    static int INF = 9999;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)
                    arr[i][j] = 0;
                else
                    arr[i][j] = INF;
            }
        }
        
        // 0. 이차원 배열 초기화 -> 각각의 간선의 비용은 1로 설정.
        for(int i=0; i<results.length; i++){
            arr[results[i][0]][results[i][1]] = 1;
        }
       
        // 1. 플로이드 와샬 알고리즘
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        
        // 2. 각 선수가 다른 모든 선수와의 승패를 알 수 있는지 판별
        for(int k=1; k<=n; k++){
            boolean check = true;
            for(int i=1; i<=n; i++){
                if(arr[k][i] == INF && arr[i][k] == INF){	// k와 i 선수 간의 승패를 알 수 없는 경우 => 선수 k의 순위를 결정할 수 없음.
                    check = false;
                    break;
                }
            }
            if(check == true)	// 모든 선수와의 승패를 알 수 있는 선수일 때만 answer+1 
                answer++;
        }
        return answer;
    }
}