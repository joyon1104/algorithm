package SWEA;
import java.util.*;

public class Main4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int N = Integer.parseInt(s.split(" ")[0]);
		int M = Integer.parseInt(s.split(" ")[1]);
		int[][] map = new int[600][600];
		int INF = 999999;
		
		for(int i=0; i<600; i++) {
			for(int j=0; j<600; j++) {
				map[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			String ss = sc.nextLine();
			ss = ss.replace("o","1").replace("x","0");
			String[] sarr = ss.split(" ");
			int a = Integer.valueOf(sarr[0],2);
			int b = Integer.valueOf(sarr[1],2);
			map[a][b] = Integer.parseInt(sarr[2]);
		}
		
		for(int k=0; k<map.length; k++) {	
			for(int i=0; i<map.length; i++) {	
				for(int j=0; j<map.length; j++) {
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int Q = Integer.parseInt(sc.nextLine());
		for(int q=0; q<Q; q++) {
			String ss = sc.nextLine();
			ss = ss.replace("o","1").replace("x","0");
			String[] sarr = ss.split(" ");
			int a = Integer.valueOf(sarr[0],2);
			int b = Integer.valueOf(sarr[1],2);
			
			int result = map[a][b];
			if(a == b)
				result = 0;
			else if(map[a][b] == INF)
				result = -1;
			System.out.println(result);
		}
	}
}
