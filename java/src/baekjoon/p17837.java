package baekjoon;
import java.util.*;

public class p17837 {

	static int N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				map[i][j] = sc.nextInt();
		}
		
		int[][] horse = new int[K+1][3];
		HashMap<String,ArrayList<Integer>> hm = new HashMap<>();
		for(int k=1; k<=K; k++) {
			horse[k][0] = sc.nextInt(); //r
			horse[k][1] = sc.nextInt(); //c
			horse[k][2] = sc.nextInt(); //d
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(k);
			hm.put(horse[k][0]+"/"+horse[k][1],tmp);
		}
		
		int turn = 0;
		int[][] move = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
		while(turn<=10) {
			turn++;
			boolean check = false;
			for(int k=1; k<=K; k++) {
				int r = horse[k][0];
				int c = horse[k][1];
				int d = horse[k][2];
				System.out.println(k+":" + r+"-"+c +"-" + d);
				
				int next_r = r + move[d][0];
				int next_c = c + move[d][1];
				int color = 0;
				if(next_r<=0 || next_c<=0 || next_r>N || next_c>N) {
					color= 2;
				}
				else color = map[next_r][next_c];
				
				if(color == 2) {
					int reverse_d = 0;
					if(d==1) reverse_d =2;
					else if(d==2) reverse_d = 1;
					else if(d==3) reverse_d = 4;
					else if(d==4) reverse_d = 3;
					
					next_r = r + move[reverse_d][0];
					next_c = c + move[reverse_d][1];
					horse[k][2] = reverse_d;
					
					if(next_r<=0 || next_c<=0 || next_r>N || next_c>N) {
						horse[k][2] = d;
						continue;
					}
					if(map[next_r][next_c] == 2)
						continue;
					else
						color = 0;
				}
				
				
				ArrayList<Integer> arrlist = new ArrayList<>();
				int start = 0;
				for(int i=0; i<hm.get(r+"/"+c).size(); i++) {
					if(hm.get(r+"/"+c).get(i) == k) {
						start = i;
						break;
					}
				}
				for(int i = start; i<hm.get(r+"/"+c).size(); i++) {
					arrlist.add(hm.get(r+"/"+c).get(i));
				}
				int z = hm.get(r+"/"+c).size();
				for(int i = start; i<z; i++) {
					hm.get(r+"/"+c).remove(hm.get(r+"/"+c).size()-1);
				}
				
				for(int n: arrlist) {
					horse[n][0] = next_r;
					horse[n][1] = next_c;
				}
				
				if(color == 0) {
					if(hm.containsKey(next_r+"/"+next_c)==true && hm.get(next_r+"/"+next_c).size()>=1) {
						for(int n : arrlist)
							hm.get(next_r+"/"+next_c).add(n);
					}
					else {
						hm.put(next_r+"/"+next_c,arrlist);
					}
				}
				else if(color == 1) {
					ArrayList<Integer> reverse = new ArrayList<>();
					for(int i=arrlist.size()-1; i>=0; i--)
						reverse.add(arrlist.get(i));
					if(hm.containsKey(next_r+"/"+next_c)==true && hm.get(next_r+"/"+next_c).size()>=1) {
						for(int n : reverse)
							hm.get(next_r+"/"+next_c).add(n);
					}
					else {
						hm.put(next_r+"/"+next_c,reverse);
					}
				}

				if(hm.get(next_r+"/"+next_c).size() >= 4) {
					check = true;
					break;
				}
			} //for
			if(check == true)
				break;
		}
		
		if(turn > 1000)
			turn = -1;
		System.out.println(turn);
	}
}
