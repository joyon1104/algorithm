package programmers;
/*
 * [단어 변환]
 */
import java.util.*;
class p200318_5 {
    static int answer;
    static int min;
    
    public void solve(LinkedList<String> list, String begin, String target,int cnt){
        if(!list.contains(target)){
            if(min > cnt)   min = cnt;
        }
        else{
            for(int i=0; i<list.size(); i++){
                if(list.get(i).length() == begin.length()){
                    int count = 0;
                    String tmp = list.get(i);
                    for(int j=0; j<begin.length();j++){
                        if(tmp.charAt(j) != begin.charAt(j))
                            count++;
                    }
                    if(count == 1){
                        list.remove(i);
                        solve(list,tmp,target,cnt+1);
                        list.add(tmp);
                    }
                }
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        min = 50;
        LinkedList<String> list = new LinkedList<>();
        for(String s : words)
            list.add(s);
        if(list.contains(target)){
            solve(list,begin,target,0);
            answer = min;
        }
        
        return answer;
    }
}