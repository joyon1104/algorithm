package programmers;
import java.util.*;

/*
 * [프린터]
 */

class p200306_3 {
    public int solution(int[] priorities, int location) {
        int[] pnum = new int[10];
        
        for(int x : priorities){
            pnum[x]++;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int i=0; i<priorities.length; i++)
            que.offer(i);
        
        int answer = 0;
        for(int i=9; i>=1; i--){
            while(pnum[i] > 0){
                int x = que.poll();
                if(priorities[x] == i){
                    pnum[i]--;
                    answer++;
                    if(x == location)
                        return answer;
                }
                else
                    que.offer(x);
            }
        }
        
        return answer;
    }
}