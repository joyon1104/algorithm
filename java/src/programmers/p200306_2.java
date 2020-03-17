package programmers;
import java.util.*;

/*
 * [쇠막대기]
 * 
 */

class p200306_2 {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<String> stack = new Stack<String>();
        Stack<String> tmpstack = new Stack<String>();
        String[] arr = arrangement.split("");
        
        for(String s : arr){
            if(stack.isEmpty())
                stack.push(s);
            else{
                if(s.equals("("))
                    stack.push(s);
                else{
                    stack.pop();
                    if(tmpstack.peek().equals("("))
                        answer += stack.size();
                    else if(tmpstack.peek().equals(")"))
                        answer += 1;
                }
            }
            tmpstack.push(s);
        }
        
        return answer;
    }
}