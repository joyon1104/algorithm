package programmers;
/*
 * [예산]
 */
import java.util.*;
class p200318_2 {
    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int begin = 0;  // budgets[0] 으로 하면 상한가가 예산의 최저 금액보다 작을 때를 찾지 못함.
        int end = budgets[budgets.length-1];
        int mid = 0;
        while(begin<=end){
            mid = (begin+end)/2;
            int tmp = 0;
            for(int i=0; i<budgets.length; i++){
                if(budgets[i]>mid)
                    tmp += mid;
                else
                    tmp += budgets[i];
            }
            if(tmp < M)
                begin = mid+1;
            else
                end = mid-1;
        }
        return end;
    }
}