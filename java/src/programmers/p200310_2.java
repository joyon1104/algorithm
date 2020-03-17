package programmers;
import java.util.*;

/*
 * [올바른 괄호]
 */
public class p200310_2 {
	// 정답
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        char[] arrayS = s.toCharArray();
	        int result = 0 ;
	        for ( char parenthesis : arrayS ) {
	        	if ( parenthesis == '(' ) {
	        		result++;
	        	}else if ( parenthesis == ')' ) {
	        		result--;
	        	}
	        	if ( result < 0 ) return false;
	        }
	        if ( result > 0 ) return false;
	        return answer;
	    }
	}
	
	// 내 답 : 하나 시간초과 남.
	class Solution2 {
	    boolean solution(String s) {
	        boolean answer = true;
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length(); i++){
	            if(!stack.isEmpty() && stack.peek()=='(' && s.charAt(i) == ')'){
	                stack.pop();
	                continue;
	            }
	            stack.push(s.charAt(i));
	        }
	        
	        if(!stack.isEmpty())
	            answer = false;

	        return answer;
	    }
	}
}
