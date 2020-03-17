package programmers;
/*
 * [1차]캐시
 */
import java.util.*;
class p200314_2 {
    static int check(LinkedList<String> list, String s, int cacheSize){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(s)){	// list.contains(s);
                list.remove(i);
                list.add(s);
                return 1;
            }
        }
        if(list.size()<cacheSize)
            list.add(s);
        else{
            list.remove(0);
            list.add(s);
        }
        return 5;
    }
  public int solution(int cacheSize, String[] cities) {
      int answer = 0;
      LinkedList<String> list = new LinkedList<>();
      if (cacheSize==0)
          answer = cities.length * 5;
      else{
          for(String s : cities){
              s = s.toLowerCase();
              answer += check(list,s,cacheSize);
          }
      }
      return answer;
  }
}