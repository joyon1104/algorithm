package programmers;
import java.util.*;
/*
 * [H-Index]
 */

class p200308_3 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int h=citations.length; h>=0; h--){
            int cnt = 0;
            for(int j=0; j<citations.length;j++){
                if(citations[j] >= h){
                    cnt = citations.length - j;
                    break;
                }
            }
            if(cnt >= h && citations.length - cnt <=h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}