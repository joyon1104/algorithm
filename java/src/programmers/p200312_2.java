package programmers;

/*
 * [숫자의 표현]
 */
class p200312_2 {
	  public int solution(int n) {
	      int answer = 0;
	      for(int i=n; i>=1;i--){
	          int tmp = 0;
	          for(int j = i; j>=1; j--){
	              tmp += j;
	              if(tmp == n){
	                  answer++;
	                  break;
	              }
	              else if(tmp > n)
	                  break;
	          }
	      }
	      return answer;
	  }
	}