package programmers;

/*
 * [최댓값과 최솟값]
 */
import java.util.*;
class p200312_3 {
  public String solution(String s) {
      String answer = "";
      String[] arr = s.split(" ");
      int[] narr = new int[arr.length];
      int i=0;
      
      for(String x : arr){
          narr[i++] = Integer.parseInt(x);
      }
      Arrays.sort(narr);
      answer = narr[0] +" "+ narr[narr.length-1];
      return answer;
  }
}