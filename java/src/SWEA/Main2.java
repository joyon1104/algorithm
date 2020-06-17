package SWEA;
import java.util.*;

public class Main2 {
	
	static class Team implements Comparable<Team>{
		String name;
		int win;
		int setnum;
		
		public Team(String name,int win, int setnum) {
			this.name = name;
			this.win = win;
			this.setnum = setnum;
		}
		
		public int compareTo(Team target) {
			if(this.win > target.win)
				return -1;
			else if(this.win < target.win)
				return 1;
			else {
				if(this.setnum > target.setnum)
					return -1;
				else if(this.setnum < target.setnum)
					return 1;
				else {
					return this.name.compareTo(target.name);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		HashMap<String, int[]> hm = new HashMap<>();
		for(int i=0; i<N*(N-1); i++) {
			String tmp = sc.nextLine();
			String[] sarr = tmp.split(" ");
			String s1 = sarr[0]; int n1 = Integer.parseInt(sarr[1]);
			String s2 = sarr[2]; int n2 = Integer.parseInt(sarr[3]);
			if(hm.isEmpty()) {
				hm.put(s1,new int[2]); hm.put(s2, new int[2]);
				if(n1 < n2)
					hm.get(s2)[0] += 1;
				else
					hm.get(s1)[0] += 1;
			}
			else {
				if(!hm.containsKey(s1))
					hm.put(s1,new int[2]);
				if(!hm.containsKey(s2))
					hm.put(s2, new int[2]);
				if(n1 < n2)
					hm.get(s2)[0] += 1;
				else
					hm.get(s1)[0] += 1;
			}
			hm.get(s1)[1] += n1 - n2;
			hm.get(s2)[1] += n2 - n1;
		}
		
		PriorityQueue<Team> pq = new PriorityQueue<>();
		for(String k : hm.keySet()) {
			pq.add(new Team(k,hm.get(k)[0],hm.get(k)[1]));
		}
		
		while(!pq.isEmpty()) {
			Team t = pq.poll();
			System.out.println(t.name +" " + t.win + " " + t.setnum);
		}
	}
}
