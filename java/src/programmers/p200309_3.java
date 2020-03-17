package programmers;
import java.util.*;
/*
 * [위장]
 * 
 * 모든 조합을 dfs로 구해서 각각의 경우의 수를 구할 필요가 없음!
 * => 예를들어 머리:3, 얼굴:2, 옷:1 이라면 총 가능한 개수는
		(3+1) * (2+1)*(1+1) -1 = 13
		+1씩을 더한 것은 착용하지 않은 경우가 추가 되기 때문이고 마지막으로 -1을 한 것은 아무것도 입지 않았을 때를 빼주기 위함.
 */

class p200309_3 {
    
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        int n = 0;
        for(int i=0; i<clothes.length; i++){
            if(hashmap.containsKey(clothes[i][1])){
                hashmap.put(clothes[i][1],hashmap.get(clothes[i][1])+1);
                continue;
            }
            hashmap.put(clothes[i][1],1);
        }
        
        int answer = 1;
        for(String k : hashmap.keySet())
            answer*= hashmap.get(k)+1;
        
        return answer-1;
    }
}