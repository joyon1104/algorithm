package baekjoon;
import java.util.*;

/*
 * [드래곤 커브]
 * - 성공
 * - map을 충분히 크게 할 것.
 * - 로직에서 사소한 실수, 에러 금물!
 */
public class p15685 {
	
	static class Pair{
		int x;
		int y;
		int d;
		
		public Pair(int x, int y, int d) {
			this.x =x;
			this.y =y;
			this.d =d;
		}
	}
	
	static void printmap(int[][] map) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++)
				System.out.print(map[j][i]+" ");
			System.out.println();
		}
		System.out.println("======================");
	}
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int result = 0;
		int[][] map = new int[500][500];	// 입력은 0~100사이에 들어와도 드래곤커브가 진행되면서 이를 벗어날 수 있기 때문에 여유있게 할 것.
		for(int n=0; n<N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			map = solve(map,x+200,y+200,d,g); //시작을 (200,200)에서 할 수 있게함.
		}
		for(int i=200; i<=300; i++) {
			for(int j=200; j<=300; j++) {
				if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1)
					result++;
			}
		}
		
		System.out.println(result);
	}

	static int[][] solve(int[][] map, int x, int y, int d, int g) {
		int[][] move = {{1,0},{0,-1},{-1,0},{0,1}};
		
		ArrayList<Pair> arrlist = new ArrayList<>();
		arrlist.add(new Pair(x,y,d));
		arrlist.add(new Pair(x+move[d][0],y+move[d][1],-1)); //처음 생성된 끝점은 방향이 정해지지 않음.
		map[x][y] = 1;
		map[x+move[d][0]][y+move[d][1]] = 1;
		
		for(int gg=0; gg<g; gg++) {
			int end = arrlist.size()-1;
			int tmp =end;
			for(int i=tmp-1; i>=0; i--) {
				Pair p = arrlist.get(i);	// 이동할 점
				Pair pend = arrlist.get(end); // 끝점
				int dnew = (p.d+1)%4; // 이동할 점 방향에서 90도 꺾은 방향. (현재 끝점의 방향이 됨.)
				Pair pnew = new Pair(pend.x+move[dnew][0],pend.y+move[dnew][1],-1); //끝점 기준으로 이동해야함!!!
				arrlist.add(pnew);  // 새로 생긴 끝점 추가
				map[pnew.x][pnew.y] = 1; // map에 방문여부 체크
				arrlist.get(end).d = dnew; // 새로운 끝점이 생성되면서 이전 끝점의 방향이 생성되었기 때문에 재설정!
				end++;	// 끝점을 초기화시킴.
			}
		}
		return map;
	}
}
