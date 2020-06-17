package programmers;

/*
 * [보행자 천국]
 * - 오른쪽, 아래로 이동해서 도착점까지 이동하는 모든 경우의 수를 구해야 함.
 */
class p200325_2 {
	  int MOD = 20170805;
	  public int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      int[][] right = new int[m+1][n+1];	//i,j위치에서 오른쪽으로 갈 수 있는 경우의 수 
	      int[][] down = new int[m+1][n+1];		//i,j위치에서 아래쪽으로 갈 수 있는 경우의 수 
	      
	      //첫 위치에서는 아래쪽이나 오른쪽으로 갈 수 있는 경우는 한가지!
	      right[1][1] = 1;
	      down[1][1] = 1;
	      
	      for(int i=1; i<=m; i++){
	          for(int j=1; j<=n; j++){
	        	  // 1) cityMap[i][j]==0인 경우 -> 왼쪽이나 위쪽에서 오는 경우를 모두 더하면 됨
	              if(cityMap[i-1][j-1] == 0){	
	                  right[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
	                  down[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
	              }
	              // 2) cityMap[i][j]== 1인 경우 -> 해당 좌표에서는 오른쪽이나 아래로 갈 수 없으므로 0
	              else if(cityMap[i-1][j-1] == 1){
	                  right[i][j] = 0;
	                  down[i][j] = 0;
	              }
	              // 3) cityMap[i][j]== 2인 경우 -> 오른쪽으로 가는 경우는 왼쪽에서 오는 경우만, 아래쪽으로 가는 경우는 위쪽에서 오는 경우만 더함.
	              else if(cityMap[i-1][j-1] == 2){
	                  right[i][j] += right[i][j-1] % MOD;
	                  down[i][j] += down[i-1][j] % MOD;
	              }
	          }
	      }
	      
	      // 목적지까지 가는 경우는 목적지 좌표를 기준으로 왼쪽과 위쪽에서 오는 경우를 모두 더해야 한다. (**주의 : right[m][n]과 down[m][n]은 목적지에서 오른쪽 혹은 아래쪽으로 가는 경우임!!)
	      answer = (right[m][n-1]+down[m-1][n]) % MOD;
	      return answer;
	  }
	}
