package programmers;
/*
 * [폰켓못]
 */
import java.util.*;

class p200312_1 {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int x : nums){
            if(hm.containsKey(x))
                hm.put(x,hm.get(x)+1);
            else
                hm.put(x,1);
        }
        answer = Math.min(hm.size(), nums.length/2);
        
        return answer;
    }
}