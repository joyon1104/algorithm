package SWEA;
import java.util.*;

public class p5658 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			String[] arr = s.split("");
			
			HashSet<Integer> hashset = new HashSet<>();	// 중복없이 데이터를 담을 수 있음!
			
			for(int i=1; i<=N/4; i++) {
				String[] tmp = new String[arr.length];
				for(int j=0; j<N; j++)
					tmp[j] = arr[j];
				
				// 회전
				for(int j=0; j<N; j++) {
					if(j+1==arr.length)
						arr[0] = tmp[j];
					else
						arr[j+1] = tmp[j];
				}
				
				// 10진법 변환
				for(int j=0; j<N; j+=N/4) {
					String ss = "";
					for(int k=j; k<j+N/4; k++)
						ss += arr[k];
					hashset.add(Integer.parseInt(ss,16)); // 16진법 -> 10진법
					/* [10진법 -> 2,8,16진법]
					 * String a2 = Integer.toBinaryString(num);  // 10진수 -> 2진수
					 * String a8= Integer.toOctalString(num);    // 10진수 -> 8진수
					 * String a16 = Integer.toHexString(num);    // 10진수 -> 16진수
					 */
				}
			}
			
			//내림차순 정렬
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int h : hashset) 
				pq.add(h);
			int result = 0;
			while(!pq.isEmpty()) {
				int answer = pq.poll();
				K--;
				if(K==0) {
					result = answer;
					break;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
