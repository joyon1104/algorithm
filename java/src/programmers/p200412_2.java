package programmers;
import java.util.*;
/*
 * [가장 큰 수]
 */
class p200412_2 {
    public String solution(int[] numbers) {
        String[] str_numbers = new String[numbers.length];
        for(int i=0; i<numbers.length ; i++)
            str_numbers[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(str_numbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);    // 내림차순 -> return o2.compareTo(o1); 으로 하면 30이 3보다 앞에 서게됨.
                // return (o1+o2).compareTo(o2+o1); // 오름차순
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