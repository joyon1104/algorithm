package baekjoon;
import java.util.*;

/*
 * [�巡�� Ŀ��]
 * - ����
 * - map�� ����� ũ�� �� ��.
 * - �������� ����� �Ǽ�, ���� �ݹ�!
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
		int[][] map = new int[500][500];	// �Է��� 0~100���̿� ���͵� �巡��Ŀ�갡 ����Ǹ鼭 �̸� ��� �� �ֱ� ������ �����ְ� �� ��.
		for(int n=0; n<N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			map = solve(map,x+200,y+200,d,g); //������ (200,200)���� �� �� �ְ���.
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
		arrlist.add(new Pair(x+move[d][0],y+move[d][1],-1)); //ó�� ������ ������ ������ �������� ����.
		map[x][y] = 1;
		map[x+move[d][0]][y+move[d][1]] = 1;
		
		for(int gg=0; gg<g; gg++) {
			int end = arrlist.size()-1;
			int tmp =end;
			for(int i=tmp-1; i>=0; i--) {
				Pair p = arrlist.get(i);	// �̵��� ��
				Pair pend = arrlist.get(end); // ����
				int dnew = (p.d+1)%4; // �̵��� �� ���⿡�� 90�� ���� ����. (���� ������ ������ ��.)
				Pair pnew = new Pair(pend.x+move[dnew][0],pend.y+move[dnew][1],-1); //���� �������� �̵��ؾ���!!!
				arrlist.add(pnew);  // ���� ���� ���� �߰�
				map[pnew.x][pnew.y] = 1; // map�� �湮���� üũ
				arrlist.get(end).d = dnew; // ���ο� ������ �����Ǹ鼭 ���� ������ ������ �����Ǿ��� ������ �缳��!
				end++;	// ������ �ʱ�ȭ��Ŵ.
			}
		}
		return map;
	}
}
