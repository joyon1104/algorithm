package programmers;
/*
 * [등굣길]
 */
import java.util.*;
class p200322_4 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++)
            map[puddles[i][1]][puddles[i][0]] = -1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1)
                    map[i][j] = 1;
                else if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                else
                    map[i][j]= (map[i-1][j] + map[i][j-1]) %1000000007;
            }
        }
        int answer = map[n][m];
        return answer;
    }
}