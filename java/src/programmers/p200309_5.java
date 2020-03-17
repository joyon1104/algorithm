package programmers;
/*
 * [구명보트]
 */
import java.util.*;

class p200309_5 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int cnt = 0; // 둘이 같이 타는 경우의 수
        int min = 0;
        int max = people.length-1;
        while(min<max){
            if(people[min]+people[max] <=limit){
                min++;
                max--;
                cnt++;
            }
            else
                max--;
        }
        answer = people.length-cnt;
        return answer;
    }
}