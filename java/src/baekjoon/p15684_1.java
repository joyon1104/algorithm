package baekjoon;
import java.util.*;

/*
 * [��ٸ� ���� ]
 * - ����!
 * - 3���� �迭�� ��ٸ� ���μ��� ǥ���Ͽ���!
 */

public class p15684_1 {

	static class Pair{
		int a;
		int b1;
		int b2;
		
		public Pair(int a, int b1, int b2) {
			this.a = a;
			this.b1 = b1;
			this.b2 = b2;
		}
	}
	
	static int N,M,H,result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		int[][][] bridge = new int[31][31][31];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			bridge[a][b][b+1] = 1;
		}
		
		// ���μ��� �߰����� �ʾ��� �� ����� �����ϴ��� Ȯ��
		solve(bridge,0);
		if(result==-1) {
			System.out.println(0);
			return;
		}
		
		result = 0;
		// ���� �� �ִ� ��� ���μ��� arrlist�� ����
		ArrayList<Pair> arrlist = new ArrayList<>();
		for(int i=1; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(bridge[i][j][j+1]==1)
					continue;
				arrlist.add(new Pair(i,j,j+1));
			}
		}
		
		// 1~3������ ���μ� �����ϱ�
		for(int n=1; n<=3; n++) {
			for(int idx=0; idx<arrlist.size(); idx++) {
				Pair p = arrlist.get(idx);
				if(bridge[p.a][p.b1-1][p.b1] == 1 || bridge[p.a][p.b2][p.b2+1]==1) // �� ���μ��� �����ϰų� �����ִ� ��� ����
					continue;
				bridge[p.a][p.b1][p.b2] = 1;
				dfs(bridge,arrlist,idx,1,n);
				bridge[p.a][p.b1][p.b2] = 0;
			}
			
			// ������� ���μ��� 1�� ������ �� ����� �����ϸ�, ���� 2,3�� ���μ��� �� ��츦 ������� �ʾƵ� �Ǳ� ������ ��������!
			if(result != 0)
				break;
		}
		
		//result�� 0�̸� ����� ������ �� ������ �ǹ� -> -1�� ����
		if(result == 0)
			result = -1;
		
		System.out.println(result);
	}
	
	static void dfs(int[][][]bridge, ArrayList<Pair> arrlist, int idx, int cnt, int n) {
		if(cnt == n) {
			solve(bridge,n);
		}
		else {
			for(int i=idx+1; i<arrlist.size(); i++) {
				Pair p = arrlist.get(i);
				if(bridge[p.a][p.b1-1][p.b1] == 1 || bridge[p.a][p.b2][p.b2+1]==1)
					continue;
				bridge[p.a][p.b1][p.b2] = 1;
				dfs(bridge,arrlist,i,cnt+1,n);
				bridge[p.a][p.b1][p.b2] = 0;
			}
		}
	}
	
	static void solve(int[][][]bridge, int nn) {
		boolean check = true;
		for(int n=1; n<=N; n++) {
			int p = n; //���� ���μ�
			int q = 1; //���� ���μ�
			while(q<=H) {
				if(p==1) {
					if(bridge[q][p][p+1]==1)
						p++;
				}
				else if(p==N) {
					if(bridge[q][p-1][p]==1)
						p--;
				}
				else {
					if(bridge[q][p][p+1]==1)
						p++;
					else if(bridge[q][p-1][p]==1)
						p--;
				}
				q++;
			}
			if(p!=n) {
				check = false;
				break;
			}
		}
		// nn�� 0�� ��, �� �ٸ��� �߰����� �ʾƵ� ������ ��
		if(nn==0 && check==true)
			result = -1;
		
		else if(check==true) {
			result = nn;
		}
	}
}
