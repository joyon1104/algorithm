package programmers;
import java.util.*;
/*
 * [�߱�����]
 * - �켱���� ť�� �̿��Ѵ�.(��������)
 * - ���� �۾����� ���� �Ϻ��� �켱���� ť���� ������.
 * - ��ٱ��� ���� �ð� n�� 1���ҽ�Ű��, ���� �ϵ� 1���ҽ�Ų �� �ٽ� �켱���� ť�� �ִ´�.
 * - n�� 0�� �� ������ �ݺ� -> ���� ���� �۾����� ���� ���� 0�̸� ��� ���� ��� ���� ���´ٴ� ���̹Ƿ� �ٷ� 0�� �����Ѵ�.
 * - �켱����ť�� ���� �ϵ�� �߱������� ����ؼ� �����Ѵ�.
 */
class p200330_2 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : works)
            pq.offer(x);
        
        while(n>0){
            int tmp = pq.poll();
            if(tmp == 0)
                return answer;
            pq.offer(tmp-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
        return answer;
    }
}