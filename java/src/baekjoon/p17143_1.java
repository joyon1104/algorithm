package baekjoon;
import java.util.*;

public class p17143_1 {

	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static void catchFish(int loc) {
		for(int i=1; i<=R; i++) {
			if(map[i][loc] > 0) {
				result += map[i][loc];
				map[i][loc] = 0;
				break;
			}
		}
	}
	
	static void printmap() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("================");
	}
	
	static Shark moveFish(Shark sh) {
		Shark res = new Shark(sh.r,sh.c,sh.s,sh.d,sh.z);
		int[][] moved = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
		if(sh.d==1 || sh.d==2) {
			int speed = sh.s % (2*R-2);
			while(speed>0) {
				int next_r = res.r + moved[res.d][0];
				int next_c = res.c + moved[res.d][1];
				if(next_r<=0) {
					res.d = 2;
					next_r = 2;
				}
				else if(next_r>R) {
					res.d = 1;
					next_r = R-1;
				}
				res.r = next_r;
				res.c = next_c;
				
				speed--;
			}
			
		}
		else {
			int speed = sh.s % (2*C-2);
			while(speed>0) {
				int next_r = res.r + moved[res.d][0];
				int next_c = res.c + moved[res.d][1];
				if(next_c<=0) {
					res.d = 3;
					next_c = 2;
				}
				else if(next_c>C) {
					res.d = 4;
					next_c = C-1;
				}
				res.r = next_r;
				res.c = next_c;
				
				speed--;
			}
		}
		
		return res;
	}
	
	static int R,C,M,result;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		map = new int[R+1][C+1];
		
		Queue<Shark> que = new LinkedList<>();
		for(int m=0; m<M; m++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			que.add(new Shark(r,c,s,d,z));
			map[r][c] = z;
		}
		
		int loc =1;
		while(loc <= C) {
			catchFish(loc);
			Queue<Shark> tmp = new LinkedList<>();
			int[][] tmpmap = new int[R+1][C+1];
			while(!que.isEmpty()) {
				Shark sh = que.poll();
				if(map[sh.r][sh.c] == 0)
					continue;
				Shark next = moveFish(sh);
				if(tmpmap[next.r][next.c]==0) {
					tmpmap[next.r][next.c] = next.z;
					tmp.add(next);
				}
				else {
					if(tmpmap[next.r][next.c]<next.z) {
						tmpmap[next.r][next.c] = next.z;
						tmp.add(next);
					}
				}
			}
			
			if(tmp.size()==0)
				break;
			
			while(!tmp.isEmpty()) {
				Shark sh = tmp.poll();
				if(tmpmap[sh.r][sh.c] > sh.z)
					continue;
				que.add(sh);
			}
			map = tmpmap;
			
			loc++;
		}
		System.out.println(result);
	}
}
