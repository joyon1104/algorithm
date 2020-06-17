package baekjoon;
import java.util.*;

/*
 * [사다리 조작 ]
 * - 성공!
 * - 3차원 배열로 사다리 가로선을 표시하였음!
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
		
		// 가로선을 추가하지 않았을 때 결과가 만족하는지 확인
		solve(bridge,0);
		if(result==-1) {
			System.out.println(0);
			return;
		}
		
		result = 0;
		// 놓을 수 있는 모든 가로선을 arrlist에 저장
		ArrayList<Pair> arrlist = new ArrayList<>();
		for(int i=1; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(bridge[i][j][j+1]==1)
					continue;
				arrlist.add(new Pair(i,j,j+1));
			}
		}
		
		// 1~3개까지 가로선 선택하기
		for(int n=1; n<=3; n++) {
			for(int idx=0; idx<arrlist.size(); idx++) {
				Pair p = arrlist.get(idx);
				if(bridge[p.a][p.b1-1][p.b1] == 1 || bridge[p.a][p.b2][p.b2+1]==1) // 두 가로선이 연속하거나 접해있는 경우 제외
					continue;
				bridge[p.a][p.b1][p.b2] = 1;
				dfs(bridge,arrlist,idx,1,n);
				bridge[p.a][p.b1][p.b2] = 0;
			}
			
			// 예를들어 가로선을 1개 놓았을 때 결과를 만족하면, 굳이 2,3개 가로선을 고를 경우를 고려하지 않아도 되기 때문에 종료조건!
			if(result != 0)
				break;
		}
		
		//result가 0이면 결과를 만족할 수 없음을 의미 -> -1로 선언
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
			int p = n; //시작 세로선
			int q = 1; //시작 가로선
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
		// nn이 0일 때, 즉 다리를 추가하지 않아도 만족할 때
		if(nn==0 && check==true)
			result = -1;
		
		else if(check==true) {
			result = nn;
		}
	}
}
