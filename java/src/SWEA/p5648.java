package SWEA;
import java.util.*;

/*
 * [원자 소멸 시뮬레이션]
 * - 시간초과...ㅠㅠ
 */

public class p5648 {

	static int result;
	static int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
	
	static boolean check(int[][] atom, HashMap<String,ArrayList<Integer>> hm) {
		boolean res = false;
		HashMap<Integer, String> hm2 = new HashMap<>();
		ArrayList<Integer> arrlist = new ArrayList<>();
		for(String k : hm.keySet()) {
			hm2.put(hm.get(k).get(0),k);
			arrlist.add(hm.get(k).get(0));
		}
		for(int i=0; i<arrlist.size(); i++) {
			int n = arrlist.get(i);
			int nd = atom[n][0];
			float nx = Float.parseFloat(hm2.get(n).split("/")[0]);
			float ny = Float.parseFloat(hm2.get(n).split("/")[1]);
			for(int j=0; j<arrlist.size(); j++) {
				int m = arrlist.get(j);
				int md = atom[m][0];
				float mx = Float.parseFloat(hm2.get(m).split("/")[0]);
				float my = Float.parseFloat(hm2.get(m).split("/")[1]);
				if(nx==mx || ny==my) {
					if(nx==mx && ((ny>my && nd==1 && md==0)||(ny<my && nd==0 && md==1))) {
						return true;
					}
					else if(ny==my && ((nx>mx && nd==2 && md==3)||(nx<mx && nd==3 && md==2))) {
						return true;
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = 0;
			int N = sc.nextInt();
			int[][] atom = new int[N][2];
			HashMap<String,ArrayList<Integer>> hm = new HashMap<>();
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int d = sc.nextInt();
				int z = sc.nextInt();
				atom[i][0] = d;
				atom[i][1] = z;
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				hm.put(x+"/"+y,tmp);
			}
			
			while(true) {
				if(check(atom, hm)==false)
					break;
				
				HashMap<String,ArrayList<Integer>> hm2 = new HashMap<>();
				for(String key : hm.keySet()) {
					int a = hm.get(key).get(0);
					float x = Float.parseFloat(key.split("/")[0]);
					float y = Float.parseFloat(key.split("/")[1]);
					
					float next_x = (float) (x + 0.5*move[atom[a][0]][0]);
					float next_y = (float) (y + 0.5*move[atom[a][0]][1]);
					
					if(hm2.containsKey(next_x+"/"+next_y)) {
						hm2.get(next_x+"/"+next_y).add(a);
					}
					else {
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(a);
						hm2.put(next_x+"/"+next_y,tmp);
					}
				}
				
				ArrayList<String> sarr = new ArrayList<>();
				for(String key : hm2.keySet()) {
					if(hm2.get(key).size() >=2) {
						ArrayList<Integer> arrlist = hm2.get(key);
						for(int n : arrlist) {
							result += atom[n][1];
						}
						sarr.add(key);
					}
				}
				for(String s : sarr)
					hm2.remove(s);
				hm = hm2;
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
