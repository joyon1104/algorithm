package programmers;

/*
 * [다음 큰 숫자]
 */

class p200310_3 {
    
	public int solve(int n){
	    int result = 0;
	    while(n >0){
	        if(n%2==1)
	            result++;
	        n /=2;
	    }
	    return result;
	}
    
  public int solution(int n) {
      int answer = 0;
      int one = solve(n);
      int tmp = n+1;
      while(true){
          if(solve(tmp) == one)
              break;
          tmp++;
      }
      answer = tmp;
      return answer;
  }
}