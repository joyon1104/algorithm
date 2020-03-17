package programmers;
import java.util.*;

/*
 * [소수 찾기(lev2)]
 */

class o200309_1 {
  static int answer;
  
  static boolean isPrime(int n){
      if(n==1)
          return false;
      else{
          for(int i=2; i<=Math.sqrt(n); i++){
              if(n%i == 0)
                  return false;
          }
      }
      return true;
  }
  
  static void dfs(int[] arr, int n, String result){
      if(n== result.length()){
          System.out.println(result);
          if(isPrime(Integer.parseInt(result)))
              answer++;
      }
      else{
          for(int i=0; i<=9; i++){
              if(arr[i]>0){
                  if(result.equals("") && i==0)
                      continue;
                  arr[i]--;
                  dfs(arr,n, result+i);
                  arr[i]++;
              }
          }
      }
  }
  
  public int solution(String numbers) {
      answer = 0;
      String[] sarr = numbers.split("");
      int[] narr = new int[10];
      for(String s : sarr)
          narr[Integer.parseInt(s)]++;
      
      for(int i= numbers.length(); i>=1; i--){
          int[] visited = new int[10];
          dfs(narr,i,"");
      }
      return answer;
  }
}