package baekjoon;
import java.util.*;

/*
 * 큐에서 빼고 난 후, 자기 자신까지 가장 오래 걸린 시간을 배열에 저장해야 함.
 * result[y] = Math.max(result[y], result[x] + time[y]);
 * - 건물들은 동시에 세워질 수 있음이 가정되어 있다!
 * 예제)
 * 	5
	10 -1
	10 1 -1
	4 -1
	4 3 1 -1
	3 3 -1
	10
	20
	4
	14 -> 18이 아니고 14임!(1과 3이 설립되는 시간 중 시간이 더 긴 1에 맞춰지기 때문)
	7
 */

public class p1516 {
	static int N;
	static int[] indegree;
	static int[] time;
	static int[] result;
	static ArrayList<ArrayList<Integer>> arrlist;
	
	static void solve() {
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				que.offer(i);
				result[i] = time[i];
			}
		}
		
		while(!que.isEmpty()) {
			int x = que.poll();
			for(int j=0; j<arrlist.get(x).size(); j++) {
				int y = arrlist.get(x).get(j);
				indegree[y]--;
				result[y] = Math.max(result[y], result[x] + time[y]); 
				if(indegree[y] == 0) {
					que.offer(y);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		indegree = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		arrlist = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N; i++)
			arrlist.add(new ArrayList<Integer>());
		
		for(int i=1; i<=N; i++) {
			String[] s = sc.nextLine().split(" ");
			time[i] = Integer.parseInt(s[0]);
			for(int j=1; j<s.length-1; j++) {
				int y = Integer.parseInt(s[j]);
				arrlist.get(y).add(i);		// 이전 위상정렬과 반대로 arrlist에 넣어줘야 함.
				indegree[i]++;
			}
		}
		solve();
		for(int i=1; i<=N; i++)
			System.out.println(result[i]);
	}
}
