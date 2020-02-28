package baekjoon;
import java.util.*;

public class p10816_1 {
	static int N,M;
	static HashMap<Integer,Integer> hashmap;
	static int[] mycard;
	static int[] ncard;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		mycard = new int[N];
		hashmap = new HashMap<>();
		for(int i=0; i<N; i++) {
			mycard[i] = sc.nextInt();
			if(!hashmap.containsKey(mycard[i]))
				hashmap.put(mycard[i],1);
			else {
				int tmp = hashmap.get(mycard[i]);
				hashmap.put(mycard[i], tmp+1);
			}
		}
		M = sc.nextInt();
		ncard = new int[M];
		for(int i=0; i<M; i++) {
			ncard[i] = sc.nextInt();
			if(!hashmap.containsKey(ncard[i]))
				System.out.print(0+" ");
			else 
				System.out.print(hashmap.get(ncard[i])+" ");
		}
	}
}
