package programmers;
/*
 * [1차]뉴스 클러스터링
 */
import java.util.*;

class p200314_1 {
    static boolean check(String s){
        boolean result  = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)<'A' || s.charAt(i)>'Z'){
                result = false;
                break;
            }
        }
        return result;
    }
    
  public int solution(String str1, String str2) {
      int answer = 0;
      str1 = str1.toUpperCase();
      str2 = str2.toUpperCase();
      
      HashMap<String, Integer> hm = new HashMap<>();
      HashMap<String, Integer> hm1 = new HashMap<>();
      HashMap<String, Integer> hm2 = new HashMap<>();

      for(int i=0; i<str1.length()-1; i++){
          if(check(str1.substring(i,i+2))){
              if(!hm.containsKey(str1.substring(i,i+2))){
                  hm.put(str1.substring(i,i+2),1);
                  hm1.put(str1.substring(i,i+2),1);
              }
              else
                  hm1.put(str1.substring(i,i+2),hm1.get(str1.substring(i,i+2))+1);
          }
      }
      
      for(int i=0; i<str2.length()-1; i++){
          if(check(str2.substring(i,i+2))){
              if(!hm.containsKey(str2.substring(i,i+2))){
                  hm.put(str2.substring(i,i+2),1);
                  hm2.put(str2.substring(i,i+2),1);
              }
              else if(!hm2.containsKey(str2.substring(i,i+2)))
                  hm2.put(str2.substring(i,i+2),1);
              else
                  hm2.put(str2.substring(i,i+2),hm2.get(str2.substring(i,i+2))+1);
          }
      }
      int a = 0;    //교집합
      int b = 0;    //합집합
      
      for(String s : hm.keySet()){
          if(hm1.containsKey(s) && hm2.containsKey(s)){
              a += Math.min(hm1.get(s),hm2.get(s));
              b += Math.max(hm1.get(s),hm2.get(s));
          }
          else if(hm1.containsKey(s)){
              b += hm1.get(s);
          }
          else if(hm2.containsKey(s)){
              b += hm2.get(s);
          }
      }
      if(b == 0)
          answer = 1*65536;
      else
        answer = (int)((float)a/(float)b * 65536);
      
      return answer;
  }
}