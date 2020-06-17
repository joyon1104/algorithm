package programmers;
/*
 * [ū �� �����]
 * - idx��° ���� idx+1��° ������ ������ ����
 * - idx�� 0�̸� �״��, idx > 0 �̸� idx�� ���ҽ��� �ٽ� Ž���� �� �ֵ��� �Ѵ�.
 * !!! StringBuilder�� ����ؾ� �ð��� ����� -> strb.deleteCharAt(idx)�� ���� �����ð��� �ٿ��� !!!!
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