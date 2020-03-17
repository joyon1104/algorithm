package programmers;
import java.util.*;

/*
 * [전화번호 목록]
 */

class p200309_2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hashmap = new HashMap<>();
        Arrays.sort(phone_book); // sort를 해야하는 이유 : sort를 안하면 ["119","1192456"]과 ["1992456","199"] 결과가 달라짐. 
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<=phone_book[i].length(); j++){
                if(hashmap.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
            hashmap.put(phone_book[i],1);
        }
        return answer;
    }
}