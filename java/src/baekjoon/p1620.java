package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1620 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = sc.nextInt();	// 포켓몬 개수 
		int M = sc.nextInt();	// 문제 개수
		
		HashMap<String, Integer> map = new HashMap();
		String list[] = new String[N];
		
		sc.nextLine();
		
		for (int i=1; i<=N; i++) {
			String str = sc.nextLine();
			map.put(str, i);
			list[i-1] = str;
		}
		
		for(int j =0; j<M; j++) {
			if(sc.hasNextInt())
				System.out.println(list[sc.nextInt()-1]);
			else
				System.out.println(map.get(sc.next()));
		}
	}
}
