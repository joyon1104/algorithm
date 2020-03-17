package programmers;
/*
 * [N개의 최소공배수]
 */
import java.util.*;

class p200313_1 {
  public int solution(int[] arr) {
      int answer = 0;
      Arrays.sort(arr);
      int i=1;
      while(true){
          boolean check = true;
          for(int j=0; j<arr.length-1; j++){
              if(arr[arr.length-1]*i%arr[j] != 0){
                  check = false;
                  break;
              }
          }
          if(check == true)
              break;
          i++;   
      }
      answer = arr[arr.length-1]*i;
      return answer;
  }
}