package programmers;

import java.util.*;

/*
 * [조이스틱]
 * 참고 : https://jayrightthere.tistory.com/172
 * => 다시 풀고 이해할 것..
 */

class p200306_5 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int tmp = 0;
        int turn  = n-1;    // 오른쪽, 왼쪽 방향 중 어느 방향으로 가는 게 빠른지
        char[] narr = name.toCharArray();
        
        for(int i=0; i<n; i++){
            int startto = narr[i] - 'A';
            int endto = 'Z' - narr[i] + 1;
            
            // 위와 아래 중 어느 방향으로 가는게 더 빠른지
            if(startto > endto)
                tmp += endto;
            else
                tmp += startto;
            
            int next = i+1;
            while(next<n && narr[next] == 'A')
                next++;
            turn = Math.min(turn, i+n-next + Math.min(i,n-next));
        }
        tmp += turn;
        answer = tmp;
        return answer;
    }
}
