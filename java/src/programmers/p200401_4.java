package programmers;
/*
 * [�ϳ����� ž]
 */
import java.util.*;
class p200401_4 {
    static ArrayList<int[]> arrlist = new ArrayList<>();
    
    static void hanoi(int n, int from, int mid, int to){
        if(n==1){	// ������ �ϳ��� ���
            int[] arr = new int[2];
            arr[0] = from; arr[1] = to;	//ù��°���� ����°�� ������ �ű�
            arrlist.add(arr);	//arrlist�� ����� ����.
        }
        else{	// ������ �ϳ��� �ƴ� ���
            hanoi(n-1,from,to,mid);	//n-1���� ������ ù��°���� �߰����� �ű�
            hanoi(1,from,mid,to);	//������ ������ ù��°���� ���������� �ű�
            hanoi(n-1,mid,from,to);	// �߰����� �Ű�� n-1���� ������ ���������� �ű�
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
