package programmers;
import java.util.*;
/*
 * [스킬트리]
 */

class p200304_1 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length;i++){
            int idx = 0;
            boolean check = true;
            
            String[] skillarr = skill_trees[i].split("");
            
            for(String s : skillarr){
                if(idx == skill.indexOf(s))
                    idx++;
                else if(idx < skill.indexOf(s)){
                    check = false;
                    break;
                }
            }
            if(check)
                answer++;
        }
        return answer;
    }
}