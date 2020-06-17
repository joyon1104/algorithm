package programmers;
import java.util.*;
/*
 * [최고의 집합]
 */

class p200330_4 {
  public int[] solution(int n, int s) {
      int[] answer = {-1};
      if(s>=n){
          answer = new int[n];
          for(int i=0; i<n; i++)
              answer[i] = s/n;
          int idx = n-1;
          for(int i=s%n; i>0; i--){
              answer[idx--] += 1; 
          }
          //System.out.println(Arrays.toString(answer));
      }
      return answer;
  }
}