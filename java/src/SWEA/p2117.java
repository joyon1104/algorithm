package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 190821
 * 
 * SW Expert Academy
 * [모의 SW 역량테스트] 홈 방범 서비스 
 * 
 * ->성공
 * 
 * < 구현방법 >
 * 1. K는 홀수일 때는 N, 짝수일 때는 N+1이면 모든 city의 집들을 한번에 서비스 할 수 있으므로 K의 범위는 1 <= K <= N+1
 * 2. city 배열의 모든 좌표를 탐색하면서 해당 좌표가 기준점 i,j가 됨.
	 * 3. scope(K)함수를 통해 이동 좌표값을 계산해 arrayList에 넣는다.
	 * 		ex) scope(2)일 경우 arrayList= {(0,0),(1,0),(0,-1),(-1,0),(0,1)}
	 * 4. 기준점(i,j)에서 arrayList의 이동 좌표값 만큼 더해 (next_i, next_j) 좌표를 계산한다.
	 * 5. 해당 좌표가 city배열에 존재하면 즉, (next_i >=0 && next_j >=0 && next_i<N && next_j<N)이면 city[next_i][next_j]를 확인 -> 1이면 cnt++
	 * 6. 회사가 손해를 보지 않으면서 (cost>=0), 서비스 영역에 포함되는 집 개수(cnt)가 가장 많은 경우의 집 개수를 저장한다.
 * 7. 집 개수가 가장 많은 경우를 result에 저장하여, result를 출력한다.
 */ 


public class p2117 {
 
    static Scanner sc = new Scanner(System.in);
    static int N,M,K;
    static int[][] city;
     
    static private class Pair{
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    static ArrayList<Pair> scope(int k){
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        /*
         * K 일 때 영역 이동 범위 계산
         */
        Pair p = new Pair(0,0);
        arrayList.add(p);
        
        //(i,0)을 기준으로 시계방향 
        //	-> 예) k가 2일 경우 북동, 북서, 남서, 남동으로 1칸씩 이동 => (i-1,-1), (i-2,0), (i-1,1), (i,0)-> (i,0)는 이미 넣었으므로 넣지 않는다.
        int[] move_x = {-1,-1,1,1};
        int[] move_y = {-1,1,1,-1};
         
        if (k>1) {
            for(int i=1; i<k; i++) {
                p = new Pair(i,0);
                arrayList.add(p);
                int next_x = i; int next_y = 0;
                for(int j=0; j<4; j++) {
                    for(int ii=i; ii>0; ii--) {
                        next_x = next_x + move_x[j];
                        next_y = next_y + move_y[j];
                        if(next_x == i && next_y==0)
                            break;
                        arrayList.add(new Pair(next_x,next_y));
                    }
                }
            }
        }
        return arrayList;
    }
     
    public static void main(String[] args) {
        int T= sc.nextInt();
         
        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = 1;
             
            city = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    city[i][j] = sc.nextInt();
                }
            }
             
            int result = 0;		//최대 집 개수
            int cnt = 0;		// 집 개수 count 
            
            //1.
            while(K<=N+1) {
                ArrayList<Pair> arr = scope(K);	// 3.
                //2. 모든 city좌표 탐색
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        cnt = 0;	//집 개수 초기화 
                        for(int a=0; a<arr.size(); a++) {	//scope함수에서 구한 이동 범위만큼 이동
                            //4. 탐색할 좌표 계산
                        	int next_i = i + arr.get(a).i;
                            int next_j = j + arr.get(a).j;
                            if(next_i >=0 && next_j >=0 && next_i<N && next_j<N) {	// 5.
                                if(city[next_i][next_j] == 1)
                                    cnt++;
                            }
                        }
                        
                        //보안회사 이익 계산 
                        int cost = M * cnt - (K*K + (K-1)*(K-1));
                        
                        //6. *** '손해보지 않으면서' => cost가 0보다 크거나 같을 때 (같을 때 포함 꼭 해줄 것!!!)
                        if(cost >= 0 && cnt > result) {
                            result = cnt;
                        }
                    }
                }
                K++;
            }
            
            //7.
            System.out.println("#"+t + " " + result);
        }
    }
     
}