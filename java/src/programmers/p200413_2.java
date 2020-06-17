package programmers;
/*
 * [JadenCase 문자열 만들기]
 */
class p200413_2 {
	  public String solution(String s) {
	      String answer = "";
	      String[] str = s.split(" ");
	      for(String st : str){
	          if(st.length()!=0){	// 공백문자가 여러번 올 수 있음. -> 공백문자가 여러개있을 경우 st에 아무것도 존재하지 않기 때문에 continue해줘야 함.
	              for(int i=0; i<st.length(); i++){
	                  char c = st.charAt(i);
	                  if(i==0 && c>='a' && c<='z'){
	                      answer += (char)((int)c - (int)'a' + (int)'A');
	                  }
	                  else if(i != 0 && c>='A' && c<='Z')
	                      answer += (char)((int)c - (int)'A' + (int)'a');
	                  else
	                      answer += c;
	              }
	          }
	          answer += " ";
	      }
	      answer = answer.substring(0,answer.length()-1);	//마지막 공백문자 제거
	      if(s.substring(s.length()-1,s.length()).equals(" "))	//s의 마지막 문자가 공백문자의 경우 split되면서 제거될 수 있음 -> 마지막 문자 확인 후 공백문자면 answer에 공백 추가
	          answer += " ";
	      return answer;
	  }
	}
