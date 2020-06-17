package baekjoon;
import java.util.*;

public class p14891 {
	
	public static int[][] solve(int[][] map, int n, int d){
		int[][] tmp = new int[map.length][map[0].length];
		int[] check = new int[map.length];
		check[n] = d;
		if(n==1) {
			if(map[1][2] != map[2][6])
				check[2] = check[1]*-1;
			if(check[2] != 0 && map[2][2] != map[3][6])
				check[3] = check[2]*-1;
			if(check[3] != 0 && map[3][2] != map[4][6])
				check[4] = check[3]*-1;
		}
		else if(n==2) {
			if(map[2][6] != map[1][2])
				check[1] = check[2]*-1;
			if(map[2][2] != map[3][6])
				check[3] = check[2]*-1;
			if(check[3] != 0 && map[3][2] != map[4][6])
				check[4] = check[3]*-1;
		}
		else if(n==3) {
			if(map[3][6] != map[2][2])
				check[2] = check[3]*-1;
			if(map[3][2] != map[4][6])
				check[4] = check[3]*-1;
			if(check[2] != 0 && map[2][6] != map[1][2])
				check[1] = check[2]*-1;
		}
		else if(n==4) {
			if(map[4][6] != map[3][2])
				check[3] = check[4]*-1;
			if(check[3] != 0 && map[2][2] != map[3][6])
				check[2] = check[3]*-1;
			if(check[2] != 0 && map[2][6] != map[1][2])
				check[1] = check[2]*-1;
		}
		
		for(int i=1; i<=4; i++) {
			if(check[i] == 1) {
				for(int j=0; j<8; j++) {
					if(j-1 <0)
						tmp[i][j] = map[i][7];
					else
						tmp[i][j] = map[i][j-1];
				}
			}
			else if(check[i] == -1) {
				for(int j=0; j<8; j++) {
					if(j+1 >= 8)
						tmp[i][j] = map[i][0];
					else
						tmp[i][j] = map[i][j+1];
				}
			}
			else {
				for(int j=0; j<8; j++) {
					tmp[i][j] = map[i][j];
				}
			}
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] chain = new int[5][8];
		
		for(int i=1; i<=4; i++) {
			String s = sc.nextLine();
			for(int j=0; j<8; j++) {
				chain[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		int K = sc.nextInt();
		int[][] dict = new int[K][2];
		for(int i=0; i<K; i++) {
			dict[i][0] = sc.nextInt();
			dict[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<K; i++) {
			chain = solve(chain,dict[i][0],dict[i][1]);
		}
		
		int result = 0;
		for(int i=1; i<=4; i++) {
			if(chain[i][0] == 1)
				result += Math.pow(2, i-1);
		}
		System.out.println(result);
	}

}
