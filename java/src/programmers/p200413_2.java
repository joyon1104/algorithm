package programmers;
/*
 * [JadenCase ���ڿ� �����]
 */
class p200413_2 {
	  public String solution(String s) {
	      String answer = "";
	      String[] str = s.split(" ");
	      for(String st : str){
	          if(st.length()!=0){	// ���鹮�ڰ� ������ �� �� ����. -> ���鹮�ڰ� ���������� ��� st�� �ƹ��͵� �������� �ʱ� ������ continue����� ��.
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
	      answer = answer.substring(0,answer.length()-1);	//������ ���鹮�� ����
	      if(s.substring(s.length()-1,s.length()).equals(" "))	//s�� ������ ���ڰ� ���鹮���� ��� split�Ǹ鼭 ���ŵ� �� ���� -> ������ ���� Ȯ�� �� ���鹮�ڸ� answer�� ���� �߰�
	          answer += " ";
	      return answer;
	  }
	}
