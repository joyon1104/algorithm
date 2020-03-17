package programmers;
import java.util.*;

/*
 * [카카오프렌즈 컬러링북]
 */

class p200306_4 {
	static class Pair{
	    int i;
	    int j;
	    public Pair(int i, int j){
	        this.i = i;
	        this.j = j;
	    }
	}
	
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      int[][] moved = {{0,1},{0,-1},{1,0},{-1,0}};
      int[][] visited = new int[m][n];
      
      for (int i=0; i<m; i++){
          for(int j=0; j<n; j++){
              if(picture[i][j] != 0 && visited[i][j] == 0){
                  numberOfArea++;
                  int sizeOfOneArea = 0;
                  Queue<Pair> que = new LinkedList<Pair>();
                  que.offer(new Pair(i,j));
                  visited[i][j] = 1;
                  
                  while(!que.isEmpty()){
                      Pair p = que.poll();
                      sizeOfOneArea++;
                      for(int k=0; k<4; k++){
                          int next_i = p.i + moved[k][0];
                          int next_j = p.j + moved[k][1];
                          if(next_i>=0 && next_i<m && next_j>=0 && next_j<n){
                              if(picture[next_i][next_j] == picture[p.i][p.j] 
                                 && visited[next_i][next_j] == 0){
                                  visited[next_i][next_j] = 1;
                                  que.offer(new Pair(next_i,next_j));
                              }
                          }
                      }
                  }//while
                  maxSizeOfOneArea = Math.max(maxSizeOfOneArea,sizeOfOneArea);
              }
          }
      }
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
}