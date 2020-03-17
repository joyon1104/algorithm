package programmers;

class p200304_3 {
	  public String solution(int n) {
	      String answer = "";
	      int reminder = 0;
	      
	      while(n>0){
	          reminder = n%3;
	          n = n/3;
	          
	          if(reminder == 0){    // 나머지가 0이 나올 경우 0이 아닌 4를 넣는다.
	              n -= 1;           // 나머지가 0일 경우, 몫을 1 감소시켜야 한다.
	              reminder = 4;
	          }
	          
	          answer = reminder + answer;
	      }
	      return answer;
	  }
	}