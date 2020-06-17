package programmers;
/*
 * [하노이의 탑]
 */
import java.util.*;
class p200401_4 {
    static ArrayList<int[]> arrlist = new ArrayList<>();
    
    static void hanoi(int n, int from, int mid, int to){
        if(n==1){	// 원판이 하나인 경우
            int[] arr = new int[2];
            arr[0] = from; arr[1] = to;	//첫번째에서 세번째로 원판을 옮김
            arrlist.add(arr);	//arrlist에 결과를 넣음.
        }
        else{	// 원판이 하나가 아닌 경우
            hanoi(n-1,from,to,mid);	//n-1개의 원판을 첫번째에서 중간으로 옮김
            hanoi(1,from,mid,to);	//마지막 원판을 첫번째에서 마지막으로 옮김
            hanoi(n-1,mid,from,to);	// 중간으로 옮겼던 n-1개의 원판을 마지막으로 옮김
        }
    }
  public int[][] solution(int n) {
      hanoi(n,1,2,3);
      int[][] answer = new int[arrlist.size()][2];
      for(int i=0; i<answer.length; i++){
          answer[i][0] = arrlist.get(i)[0];
          answer[i][1] = arrlist.get(i)[1];
      }
      return answer;
  }
}
