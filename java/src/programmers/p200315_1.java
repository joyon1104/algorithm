package programmers;
/*
 * [오픈채팅방]
 */
import java.util.*;
class p200315_1 {
    public String[] solution(String[] record) {
        HashMap<String,String> hm = new HashMap<>();
        ArrayList<String> arrlist = new ArrayList<>();
        
        for(String s : record){
            String[] word = s.split(" ");
            if(word[0].equals("Enter")){
                arrlist.add(word[1]+" 님이 들어왔습니다.");
                hm.put(word[1],word[2]);
            }
            else if(word[0].equals("Leave")){
                arrlist.add(word[1]+" 님이 나갔습니다.");
            }
            else if(word[0].equals("Change")){
                hm.put(word[1],word[2]);
            }
        }
        String[] answer = new String[arrlist.size()];
        int i=0;
        for(String s : arrlist){
            String[] arr = s.split(" ");
            answer[i++] = hm.get(arr[0])+arr[1]+" "+arr[2];
        }
        return answer;
    }
}