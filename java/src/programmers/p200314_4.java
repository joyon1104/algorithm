package programmers;
/*
 * [1차]프렌즈4블록
 */
class p200314_4 {
    static int answer;
    static char[][] rebuild(char[][] map,int[][] check){
        for(int i=0; i<map.length; i++){
          for(int j=0; j<map[0].length; j++)
              if(check[i][j] == 1){
                  map[i][j] = 'd';
                  answer++;
              }
        }
        for(int j=0; j<map[0].length; j++){
            String tmp = "";
            for(int i=0; i<map.length; i++)
                tmp += map[i][j];
            tmp = tmp.replace("d","");
            String x = "";
            for(int i=1; i<=map.length-tmp.length();i++)
                x += "x";
            tmp = x + tmp;
            for(int i=0; i<map.length; i++)
                map[i][j] = tmp.charAt(i);
        }
        return map;
    }
    
  public int solution(int m, int n, String[] board) {
      answer = 0;
      char[][] map = new char[board.length][board[0].length()];
      for(int i=0; i<map.length; i++){
          for(int j=0; j<map[0].length; j++)
              map[i][j] = board[i].charAt(j);
      }
      
      boolean change = true;
      while(change){
          change = false;
          int[][] check = new int[map.length][map[0].length];
          for(int i=0; i<map.length-1; i++){
              for(int j=0; j<map[0].length-1; j++){
                  if(map[i][j]!='x' && map[i][j]==map[i+1][j]
                     && map[i][j]==map[i][j+1] &&map[i][j]==map[i+1][j+1]){
                      check[i][j] = 1; check[i][j+1] = 1; check[i+1][j] = 1; check[i+1][j+1] =1;
                      change = true;
                  }
              }
          }
          map = rebuild(map,check);
      }
      return answer;
  }
  
  //출력을 위한 함수
    static void print(char[][] map){
        for(int i=0; i<map.length; i++){
          for(int j=0; j<map[0].length; j++)
              System.out.print(map[i][j]+" ");
            System.out.println();
      }
        System.out.println("--------------");
    }
}