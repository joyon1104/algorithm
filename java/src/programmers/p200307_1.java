package programmers;
import java.util.*;

/*
 * [문자열 압축]
 * 
 */
class p200307_1 {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){	// 문자열 길이의 반까지만 쪼갠다.
            HashMap<String,Integer> hashmap = new HashMap<>();
            String result = "";		// i단위로 쪼갰을 때 압축결과
            for(int j=0; j<s.length(); j+=i){
                String tmp = "";	// i단위로 쪼갠 블록하나
                if(j+i>s.length())	// 남은 문자열이 i개보다 적은 경우 -> 남은 문자열을 tmp에 담는다.
                    tmp = s.substring(j,s.length());
                else
                    tmp = s.substring(j,j+i);
                
                if(hashmap.containsKey(tmp)){	// 현재 블록이 이전 블록과 같으면
                    hashmap.put(tmp,hashmap.get(tmp)+1);	// 해당 키를  갖는 해시맵의 개수를 증가시킴.
                }
                else{	// 현재 블록이 이전블록과 다른 경우
                    for(String k : hashmap.keySet()){	// 맵에 기존 블록 조사 결과가 담겨있으면 result에 반영
                        if(hashmap.get(k) == 1)		// 개수가 하나면 key만 result에 반영
                            result += k;
                        else						// 개수가 두개 이상이면 숫자와 key값을 모두 result에 반영 (ex. 2ab)
                            result = result + hashmap.get(k) + k;
                    }
                    hashmap.clear();	// 맵을 초기화 (이전에 ab가 나왔더라도 다음블록이 ab가 아니면 이전 ab블록은 의미가 없으므로)
                    hashmap.put(tmp,1);	// 현재 블록을 map에 넣음
                }
            }
            
            //맵에 남은 블록 결과를 result에 반영
            for(String k : hashmap.keySet()){
                if(hashmap.get(k) == 1)
                    result += k;
                else
                    result = result + hashmap.get(k) + k;
            }

            if(answer > result.length())	// 최소값 갱신
                answer = result.length();
        }
        
        return answer;
    }
}