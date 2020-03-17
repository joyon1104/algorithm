package programmers;
import java.util.*;

/*
 * [큰 수 만들기]
 * 참고 : https://ju-nam2.tistory.com/75
 */

class p200308_1 {
    public String solution(String number, int k) {
        //빠른 연산을 위해 StringBuilder을 사용했다.
        StringBuilder sb = new StringBuilder(number);
        int delete_count = 0;
        int index = 1;
        
        while(delete_count != k) {
            //전의 숫자와 비교해야 하므로 index는 1부터 시작한다.
            //전의 숫자보다 더 크면 전의 숫자를 삭제하고 크기가 줄어들었으므로 index를 줄여준다.
            if(index>=1 && sb.charAt(index) > sb.charAt(index-1)) {
                sb.deleteCharAt(index-1);
                index--;
                delete_count++;
            } else {
                //index가 맨 끝으로 가고, 그 전의 숫자와 작거나 같으면 지금의 숫자를 삭제해준다.
                if(index==sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)) {
                    sb.deleteCharAt(index);
                    delete_count++;
                    index--;
                } else {
                //그 외의 경우에는 index를 추가해준다.
                index++;
                }
            }
        }      
        return sb.toString();
    }
}
