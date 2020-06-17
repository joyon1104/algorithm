package programmers;

/*
 * [입국심사]
 * 1. min = 1, max = 가장 느린 심사관이 모든 사람들을 한명씩 심사하는 경우 => 이분탐색
 * 2. 이분탐색 결과 중간값이 입국심사를 기다리는 사람 모두를 수용할 수 있지만, 최소값이 아닐 수 있음 -> 조건을 별도로 붙여야 한다.
 * 2-2. 이분탐색을 적용하면, 총 걸리는 시간동안 각 심사관들이 처리할 수 있는 심사 수를 구하게 된다. 그러므로 정확히 n명을 처리하지 않는 순간이 있을 수 있다.
		예를 들면 n = 1, times = [5, 5]인 경우 n = 1임에도 두 심사관이 동시에 심사를 시작하는 것으로 간주한다.
 * 3. 최대시간이 int형 범위를 초과할 수 있음 => long 타입으로 변환 필요!
 */
import java.util.*;
class p200322_2 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;
        long max = (long)times[times.length-1]*n;
        long answer = max; // => Long.MAX_VALUE 도 가능
        
        while(min<=max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int x : times)
                sum += mid/x;
            if(sum<n)
                min = mid  +1;
            else{
                if(answer > mid) // answer 갱신이 필요!
                    answer = mid;
                max = mid - 1;
            }
        }
        return answer;
    }
}