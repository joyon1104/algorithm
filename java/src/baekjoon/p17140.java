package baekjoon;
import java.util.*;

public class p17140 {
	static int N;
	static int M;
	static int[][] map;
	
	static class Pair implements Comparable<Pair>{
		int num;
		int cnt;
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
		public int compareTo(Pair target) {
			if(this.cnt < target.cnt)
				return -1;
			else if(this.cnt == target.cnt) {
				if(this.num < target.num) return -1;
				else if(this.num > target.num) return 1;
				else return 0;
			}
			else return 1;
		}
	}

	public static void solve(ArrayList<Integer> arrlist, int idx, char c){
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int n : arrlist) {
			if(hm.containsKey(n))
				hm.put(n,hm.get(n)+1);
			else
				hm.put(n,1);
		}
		for(int k : hm.keySet())
			pq.add(new Pair(k,hm.get(k)));
		
		int n=1;
		int[] arr = new int[101];
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(n<=100)
				arr[n] = p.num;
			else break;
			if(n+1<=100)
				arr[n+1] = p.cnt;
			else break;
			n+=2;
		}
		
		if(c=='r') {
			for(int i=1; i<=100; i++) {
				map[idx][i] = arr[i];
			}
		}
		else {
			for(int i=1; i<=100; i++) {
				map[i][idx] = arr[i];
			}
		}
	}
	
	public static int reset(int[][] map, char c) {
		int max = 0;
		if(c == 'c') {
			for(int i=1; i<=100; i++) {
				int j = 1;
				for(j= 1; j<=100; j++) {
					if(map[i][j]==0)
						break;
				}
				if(max < j-1)
					max = j-1;
			}
		}
		else {
			for(int i=1; i<=100; i++) {
				int j = 1;
				for(j= 1; j<=100; j++) {
					if(map[j][i]==0)
						break;
				}
				if(max < j-1)
					max = j-1;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		int time = 0;
		map = new int[101][101];
		N = 3;
		M = 3;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++)
				map[i][j] = sc.nextInt();
		}
		
		while(map[r][c] != k) {
			if(time > 100) {
				time = -1;
				break;
			}
			if(N>=M) {
				for(int i=1; i<=N; i++) {
					ArrayList<Integer> arrlist = new ArrayList<>();
					for(int j=1; j<=100; j++) {
						if(map[i][j]==0)
							continue;
						arrlist.add(map[i][j]);
					}
					solve(arrlist,i,'r');
				}
				M = reset(map,'c');
			}
			else {
				for(int j=1; j<=M; j++) {
					ArrayList<Integer> arrlist = new ArrayList<>();
					for(int i=1; i<=100; i++) {
						if(map[i][j]==0)
							continue;
						arrlist.add(map[i][j]);
					}
					solve(arrlist,j,'c');
				}
				N = reset(map,'r');
			}
			time++;
		}
		
		System.out.println(time);
		
	}

}
