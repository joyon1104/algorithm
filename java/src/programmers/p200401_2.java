package programmers;
/*
 * [숫자 게임]
 */
import java.util.*;
class p200401_2 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int i=0; int j=0;
        while(j<B.length){
            if(A[i] < B[j]){
                answer++;
                i++;
                j++;
            }
            else
                j++;
        }
        
        return answer;
    }
}