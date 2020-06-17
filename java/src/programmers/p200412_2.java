package programmers;
import java.util.*;
/*
 * [���� ū ��]
 */
class p200412_2 {
    public String solution(int[] numbers) {
        String[] str_numbers = new String[numbers.length];
        for(int i=0; i<numbers.length ; i++)
            str_numbers[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(str_numbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);    // �������� -> return o2.compareTo(o1); ���� �ϸ� 30�� 3���� �տ� ���Ե�.
                // return (o1+o2).compareTo(o2+o1); // ��������
            }
        });
        
        if(str_numbers[0].equals("0"))
            return "0";
        
        String answer = "";
        for(int i=0; i<str_numbers.length; i++)
            answer += str_numbers[i];
        
        return answer;
    }
}