package programmers;
import java.util.*;

/*
 * [괄호 변환]
 * 
 * <주의사항>
 * 1. replace 함수 사용 시 ",(,),{,} 등의 특수문자 치환 시 유의해야 한다. (https://mean79.tistory.com/478)
 * 2. java 함수에서 두 개 이상 return값을 받을 수 없다 -> 배열로 리턴하기!
 * 
 */

class p200308_2 {
    
    static boolean isRight(String p){
        String[] sarr = p.split("");
        Stack<String> stack = new Stack<>();
        
        for(String s : sarr){
            if(stack.isEmpty()){
                stack.push(s);
                continue;
            }
            if(stack.peek().equals("(") && s.equals(")"))
                stack.pop();
            else
                stack.push(s);
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    
    static String[] isBalance(String s){
        int i=0;
        int start = 0;
        int end = 0;
        String[] result = new String[2];
        for(;i<s.length(); i++){
            String tmp = s.substring(i,i+1);
            if(tmp.equals("("))
                start++;
            else
                end++;
            if(start == end)
                break;
        }
        result[0] = s.substring(0,i+1);
        result[1] = (i+1>s.length()?"":s.substring(i+1,s.length()));
        return result;
    }
    
    static String change(String s){
        String[] sarr = s.split("");
        String result = "";
        for(String tmp : sarr){
            if(tmp.equals("("))
                result +=")";
            else if(tmp.equals(")"))
                result +="(";
        }
        return result;
    }
    
    static String solve(String w){
        String result = "";
        if(isRight(w))
            return w;
        if(w.equals(""))
            return result;
        
        String u = isBalance(w)[0];
        String v = isBalance(w)[1];
        System.out.println(u + " / " + v);
        if(isRight(u))
            result = u + solve(v);
        else{
            String tmp = "(";
            tmp += solve(v) + ")";
            u = change(u.substring(1,u.length()-1));
            result = tmp + u;
        }
        return result;
    }
    
    public String solution(String p) {
        String answer = solve(p);
        System.out.println(answer);
        return answer;
    }
}
