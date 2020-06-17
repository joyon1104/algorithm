package programmers;
/*
 * [저울]
 */
import java.util.*;
class p200322_3 {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        
        for(int x : weight){
            if(answer < x)
                break;
            answer += x;
        }
        return answer;
    }
}