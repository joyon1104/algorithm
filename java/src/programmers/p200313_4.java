package programmers;
/*
 * [영어 끝말잇기]
 */
import java.util.*;
class p200313_4 {
	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String,Integer> hm = new HashMap<>();

        char last = words[0].charAt(0);
        int i = 0;
        for(; i<words.length; i++){
            if(hm.containsKey(words[i]) || words[i].charAt(0) != last)
                break;
            else{
                last = words[i].charAt(words[i].length()-1);
                hm.put(words[i],1);
            }
        }
        if(i == words.length){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = i%n+1;
            answer[1] = i/n+1;
        }
            
        return answer;
    }
}