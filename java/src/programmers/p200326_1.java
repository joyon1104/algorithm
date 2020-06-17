package programmers;

/*
 * [가장 긴 팰린드롭]
 */
import java.util.*;
class p200326_1{
    public int solve1(String s, int idx){	// 팰린드롭 길이가 홀수일 떼 -> ex) abcdcba
        int result = 1;
        int i = 1;
        while(true){
            if(idx-i < 0 || idx+i >=s.length())
                break;
            if(s.charAt(idx+i) == s.charAt(idx-i)){
                result += 2;
                i++;
            }
            else
                break;
        }
        return result;
    }
    
    public int solve2(String s, int idx){	// 팰린드롭 길이가 짝수일 떼 -> ex) abccba
        int result = 0;
        int i = 1;
        while(true){
            if(idx-i < 0 || idx >=s.length())
                break;
            if(s.charAt(idx-i) == s.charAt(idx)){
                result += 2;
                i+=2;
                idx++;
            }
            else
                break;
        }
        return result;
    }
    public int solution(String s)
    {
        int answer = 1;	//문자열 길이가 1이거나 반복되는 문자열이 없으면 반복되는 문자열 길이가 1이므로 초기값을 1로 설정!
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i=0; i<s.length(); i++)
            s1.push(s.charAt(i));
        
        int idx = s.length();
        while(!s1.isEmpty()){
            char tmp = s1.pop();
            idx--;
            if(!s1.isEmpty() &&!s2.isEmpty() && s1.peek()==s2.peek()){
                int sum = solve1(s,idx);
                if(answer < sum)
                    answer = sum;
            }
            s2.push(tmp);
            if(!s1.isEmpty() && s1.peek() == s2.peek())
                answer = Math.max(answer, solve2(s,idx));
        }

        return answer;
    }
}