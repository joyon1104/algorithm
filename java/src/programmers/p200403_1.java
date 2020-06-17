package programmers;
/*
 * [큰 수 만들기]
 * - idx번째 수가 idx+1번째 수보다 작으면 삭제
 * - idx가 0이면 그대로, idx > 0 이면 idx를 감소시켜 다시 탐색할 수 있도록 한다.
 * !!! StringBuilder를 사용해야 시간이 단축됨 -> strb.deleteCharAt(idx)를 통해 삭제시간을 줄여줌 !!!!
 */
import java.lang.*;
class p200403_1 {
    public String solution(String number, int k) {
        StringBuilder strb = new StringBuilder(number);
        int idx = 0;
        while(idx < strb.length()-1){
            if(strb.charAt(idx) < strb.charAt(idx+1)){
                strb.deleteCharAt(idx);
                if(idx > 0)
                    idx--;
                k--;
            }
            else idx++;
            if(k<=0)
                break;
        }
        if(k>0)
            strb.delete(strb.length()-k, strb.length());
        return strb.toString();
    }
}