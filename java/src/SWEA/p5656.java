package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/*
 * SW Expert Academy
 * [모의 SW 역량테스트] 벽돌 깨기
 * 
 * ->오답 (밑 코드는 블로그 참조)
 * 
 * DFS 와 BFS를 동시에 사용!
 * 
 */


public class p5656 {
 
    static int T;
    static int N,W,H;
    static Queue<Node> q = new LinkedList<>();
    static int min;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        int t = 1;
        
        while(T-- > 0) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[H][W];
            min = Integer.MAX_VALUE;
            
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            solve(map,0);
            System.out.printf("#%d %d%n",t++,min == Integer.MAX_VALUE ? 0: min);
        }
    }
    
    static void solve(int[][] map, int cnt ) {
        
        if(cnt == N) {
            int sum = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] != 0) sum++;
                }
            }
            min = Math.min(min,sum);
            
            return;
        }
        
        for (int i = 0; i < W; i++) {
            int j = 0;
            
            while(j < H) {
                if(map[j][i] != 0) break;
                j++;
            }
            if(j == H) continue;
            
            int[][] arr = copy(map);
            q.add(new Node(j, i));
            crush(arr);
            solve(arr,cnt+1);
        }
        
    }
    
    static void crush(int[][] map) {
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int range = map[cur.x][cur.y]-1;
            map[cur.x][cur.y] = 0;
            
            for (int i = cur.x-range < 0 ? 0 : cur.x-range ; i <= (cur.x+range >= H ? H-1 : cur.x+range); i++) {
                if(map[i][cur.y] == 0) continue;
                
                if(map[i][cur.y] == 1) {
                    map[i][cur.y] = 0;
                }
                else {
                    q.add(new Node(i, cur.y));
                }
            }
            
            for (int i = cur.y-range < 0 ? 0 : cur.y-range ; i <= (cur.y+range >= W ? W-1 : cur.y+range); i++) {
                if(map[cur.x][i] == 0) continue;
                
                if(map[cur.x][i] == 1) {
                    map[cur.x][i] = 0;
                }
                else {
                    q.add(new Node(cur.x, i));
                }
            }
        }
        
        // arrange
        for (int i = H-2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 0) continue;
                
                int range = map[i][j];
                int temp = i;
                map[i][j] = 0;
                
                while(true) {
                    if(temp+1 >= H || map[temp+1][j] != 0) break;
                    temp++;
                }
                map[temp][j] = range;
            } 
        }
        
    }
    
    static int[][] copy(int[][] map) {
        int[][] temp = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
    
}
 
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 