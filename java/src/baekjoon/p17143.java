package baekjoon;
import java.util.*;

public class p17143 {
	
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
	
	static Shark move(Shark sh) {
		int[][] moved = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
		int n = 0;
		
		// speed = speed%(2*(R or C)-2) => 시간초과 없애는 법! (만약 R이 5이고, 열연산일 때 -> speed 1과 speed 9는 완전히 동일하다) 
		if(sh.d==1||sh.d==2)
			n = sh.s%(2*R-2);
		else
			n = sh.s%(2*C-2);
		
		int r = sh.r;
		int c = sh.c;
		int d = sh.d;
		while(n>0) {
			r += moved[d][0];
			c += moved[d][1];
			if(r<=0 || c<=0 || r>R || c>C) {
				if(d==1) {
					d = 2;
					r = 2;
				}
				else if(d==2) {
					d = 1;
					r = R-1;
				}
				else if(d==3) {
					d = 4;
					c = C-1;
				}
				else {
					d = 3;
					c = 2;
				}
			}
			n--;
		}
		return new Shark(r,c,sh.s,d,sh.z);
	}
	
	static void printmap(int[][] map, ArrayList<Shark> arrlist) {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j] == 0)
					System.out.print(0 +" ");
				else
					System.out.print(arrlist.get(map[i][j]-1).z +" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	static int R;
	static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[R+1][C+1];
		ArrayList<ArrayList<Integer>> arrmap = new ArrayList<>();
		for(int i=0; i<=C; i++)
			arrmap.add(new ArrayList<Integer>());
		
		ArrayList<Shark> arrlist = new ArrayList<>();
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			arrlist.add(new Shark(r,c,s,d,z));
			map[r][c] = arrlist.size();
		}
		
		int time = 1;
		int result = 0;
		while(time<=C) {
			//printmap(map,arrlist);
			// 상어잡기
			for(int i=1; i<=R; i++) {
				if(map[i][time] > 0) {
					int idx = map[i][time]-1;
					result += arrlist.get(idx).z;
					arrlist.get(idx).z = 0;
					map[i][time] = 0;
					break;
				}
			}
			
			//상어 이동
			int[][] tmp = new int[R+1][C+1];
			ArrayList<Shark> tmplist = new ArrayList<>();
			for(int i=0; i<arrlist.size(); i++) {
				Shark s = arrlist.get(i);
				if(s.z == 0)
					continue;
				Shark next = move(s);
				if(tmp[next.r][next.c] > 0) {
					int idx = tmp[next.r][next.c]-1;
					Shark before = tmplist.get(idx);
					if(before.z >= next.z)
						continue;
					else {
						tmplist.set(idx, next);
						continue;
					}
				}
				else {
					tmplist.add(next);
					tmp[next.r][next.c] = tmplist.size();
				}
			}
			map = tmp;
			arrlist = tmplist;
			
			//낚시왕 이동
			time++;
		}
		
		System.out.println(result);
	}
}

