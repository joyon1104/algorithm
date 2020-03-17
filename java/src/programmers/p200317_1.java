package programmers;
/*
 * [종이접기]	
 */

import java.util.*;
class p200317_1 {
  public int[] solution(int n) {
      ArrayList<Integer> arrlist = new ArrayList<Integer>();
      arrlist.add(0);
      
      ArrayList<Integer> tmplist = new ArrayList<Integer>();
      if(n>1) {
          for(int i=2; i<=n; i++){
            tmplist = new ArrayList<Integer>();
              for(int p=0; p<arrlist.size(); p++)
                  tmplist.add(arrlist.get(p));
              tmplist.add(0);
              for(int p=arrlist.size()-1; p>=0; p--){
                  if(arrlist.get(p) == 0)
                      tmplist.add(1);
                  else
                      tmplist.add(0);
              }
              arrlist.clear();
              for(int p=0; p<tmplist.size(); p++)
                  arrlist.add(tmplist.get(p));
          }
      }
      int[] answer = new int[arrlist.size()];
      for(int i=0; i<arrlist.size(); i++){
          answer[i] = arrlist.get(i);
      }
      return answer;
  }
}