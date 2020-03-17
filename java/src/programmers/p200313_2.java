package programmers;
/*
 * [짝지어 제거하기]
 */
import java.util.*;

class p200313_2
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        if(stack.isEmpty())
            answer = 1;
        return answer;
    }
}