package SWEA;
import java.util.*;

public class p2383 {
	
	static class Pair{
		int i;
		int j;
		int stair;
		int k;
		public Pair(int i, int j, int stair, int k) {
			this.i = i;
			this.j = j;
			this.stair = stair;
			this.k = k;
		}
	}
	
//	static void print(ArrayList<Pair> plist) {
//		for(Pair p : plist) {
//			System.out.println(p.i+"/"+p.j+"-"+p.stair+" "+p.k);
//		}
//		System.out.println("=====================");
//	}
	
	// 클래스 객체의 경우 '깊은복사'해서 사용해야함!!!
	static void solve(ArrayList<Pair> p, ArrayList<Pair> s) {
		ArrayList<Pair> plist = new ArrayList<>();
		for(Pair tmp : p)	// 복사하지않고 그대로 사용하니까 함수 이후의 arraylist 자체가 변함. (삭제,수정 할 때는 복사해서 사용하자!)
			plist.add(new Pair(tmp.i, tmp.j, tmp.stair, tmp.k));	// plist.add(p) -> 마찬가지로 객체 p가 call by reference로 불러와져서 기존값이 변경됨! -> 새로 복사해서 사용..
		int[] sarr = new int[2];
		for(int i=0; i<s.size(); i++)
			sarr[i] = s.get(i).k;
		
		LinkedList<Pair> s1 = new LinkedList<>();
		LinkedList<Pair> s2 = new LinkedList<>();
		int time = 0;
		while(true) {
			time++;
			for(int i=0; i<plist.size(); i++) {
				Pair tmp = plist.get(i);
				if(tmp.k==0) {
					tmp.k = sarr[tmp.stair];
					if(tmp.stair == 0) s1.add(tmp);
					else s2.add(tmp);
					plist.remove(i); i--;
				}
				else
					tmp.k--;
			}
			
			for(int i=0; i<s1.size(); i++) {
				if(i>=3)
					break;
				if(s1.get(i).k==0) {
					s1.remove(i); i--;
				}
				else
					s1.get(i).k--;
			}
			for(int i=0; i<s2.size(); i++) {
				if(i>=3)
					break;
				if(s2.get(i).k==0) {
					s2.remove(i); i--;
				}
				else
					s2.get(i).k--;
			}
			
			if(s1.size()==0 && s2.size()==0 && plist.size()==0)
				break;
		}
		if(result > time) result = time; 
	}
	
	static void dfs(ArrayList<Pair> plist, ArrayList<Pair> slist, int idx) {
		if(idx == plist.size()) {
			solve(plist, slist);
		}
		else {
			for(int n=0; n<slist.size(); n++) {
				plist.get(idx).stair = n;
				plist.get(idx).k = Math.abs(plist.get(idx).i-slist.get(n).i) + Math.abs(plist.get(idx).j-slist.get(n).j);
				dfs(plist,slist,idx+1);
			}
		}
	}

	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = Integer.MAX_VALUE;
			int N = sc.nextInt();
			ArrayList<Pair> plist = new ArrayList<>();
			ArrayList<Pair> slist = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int tmp = sc.nextInt();
					if(tmp==1)
						plist.add(new Pair(i,j,0,0));
					else if(tmp>=2)
						slist.add(new Pair(i,j,0,tmp));
				}
			}
			dfs(plist,slist,0);
			
			System.out.println("#"+t+" "+result);
		}
	}
}
