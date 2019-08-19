package SWEA;

import java.util.Scanner;
import java.util.Stack;
 
/*
 * 190814
 * 
 * SW Expert Academy
 * [모의 SW 역량테스트] 디저트 카페 
 * 
 * ->성공
 * 
 * DFS와 백트래킹 
 * 
 */

public class p2105 {
 
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int p;
    static int q;
    static int tmp;
    static int ans;
	private static Scanner sc;
     
     
    //f_i & f_j : 시작 좌표, i&j : 현재 위치, cnt : 방향(0~3), result: 디저트카페 방문 수
    static void tour(Stack<Integer> stack, int f_i, int f_j, int i, int j, int cnt, int result) {	//DFS 
         
        int[] move_i = {1, 1, -1, -1};	
        int[] move_j = {1, -1, -1, 1};	// 남동, 남서, 북서, 북동 방향 
         
        int next_i = i + move_i[cnt];
        int next_j = j + move_j[cnt];	// 다음 이동할 카페 좌표 
         
         
        if(next_i >= 0 && next_j >= 0 && next_i< N && next_j< N) {
             
            if(next_i == f_i && next_j == f_j) {	// 한바퀴 돈 후 시작 위치로 돌아왔을 경우 -> 최대값 갱신 후 종료 
                if(ans < result)
                    ans = result;
                //System.out.println(stack);
                return;
            }
            if(stack.contains(map[next_i][next_j])) {	// 이미 기존 디저트카페 경로에 같은 디저트카페가 있었을 경우 -> 종료 
                return;
            }
             
            if(visited[next_i][next_j] == false) {		// 방문하지 않은 경우 (DFS)
                visited[next_i][next_j] = true;			// 방문 표시 
                stack.push(map[next_i][next_j]);		// stack에 추가 
                 
                if(cnt == 0) {	//남동 
                    tour(stack,f_i, f_j,next_i,next_j, 0, result+1);	// 같은 방향으로 갈 경우 
                    tour(stack,f_i, f_j,next_i,next_j, 1, result+1);	// 시계방향으로 방향 전환을 할 경우 
                }
                else if(cnt == 1) {	//남서 
                    tour(stack,f_i, f_j,next_i,next_j, 1, result+1);	// 같은 방향으로 갈 경우 
                    tour(stack,f_i, f_j,next_i,next_j, 2, result+1);	// 시계방향으로 방향 전환을 할 경우 
                }
                else if(cnt == 2) {	//북서 
                    tour(stack,f_i, f_j,next_i,next_j, 2, result+1);	// 같은 방향으로 갈 경우 
                    tour(stack,f_i, f_j,next_i,next_j, 3, result+1);	// 시계방향으로 방향 전환을 할 경우 
                }
                else if(cnt == 3) {	//북동 
                    tour(stack,f_i, f_j,next_i,next_j, 3, result+1);	// 같은 방향으로 갈 경우 (이 경우 밖에 없음 ->처음 위치로 갈 때까지 반복 )
                }
                 
            }
            visited[next_i][next_j] = false;	// 방문 여부 false로 전환 
            stack.pop();						// stack pop 			=> 초기화 (맨날 이거 안해서 틀림!)
        }	
    }
     
     
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
            map  = new int[N][N];
            result = 0;
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            visited = new boolean[N][N];
            ans = -1;
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    Stack<Integer> stack = new Stack<Integer>();	// stack : 중복된 디저트 카페가 있는지 확인하기 위함.
                    visited[i][j] = true;							// 방문 여부 표시 -> DFS
                    stack.push(map[i][j]);
                    tour(stack, i, j, i, j, 0, 1);
                    visited[i][j] = false;
                }
            }
            System.out.println("#" + t + " " + ans);	// 출력형식 꼭 맞출 것!!
        }
         
    }
}