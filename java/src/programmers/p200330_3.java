package programmers;
import java.util.*;
/*
 * [줄 서는 방법]
 * -> 어려움...ㅠㅠ
 */
class p200330_3 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1; // k가 1부터 시작하므로

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }

        return answer;
    }
}