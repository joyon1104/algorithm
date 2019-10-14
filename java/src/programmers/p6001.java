package programmers;

import java.util.*;

class p6001 {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        int left = 0;
        int right = budgets[budgets.length-1];
        
        while(right>=left){
            int mid = (left+right)/2;
            int result = 0;
            
            for(int i=0; i<budgets.length; i++){
                if(budgets[i] < mid)
                    result += budgets[i];
                else
                    result += mid;
            }
            if(result > M){
                right = mid-1;
            }
            else{
                left = mid+1;
                answer = mid;
            }
        }
        
        return answer;
    }
}