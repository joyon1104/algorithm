package baekjoon;

import java.util.*;

public class p17140 {
	
	static int[][] A = new int[100][100];
	static int rc = 0; //0 : 행연산, 1 : 열연산
	static int time = 0;
	static int max_r = 2;
	static int max_c = 2;
	static int tmp = 0;
	
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Integer> map = new HashMap(); 
	
	public static Object getKeyFromValue(HashMap<Integer, Integer> map, int val) {
	  for (Object o : map.keySet()) {
		  if (map.get(o).equals(val)) {
			  return o;
		  }
	  }
	  return null;
	}
	
	static void row(int[][]A) {
		System.out.println("r연산");
		tmp = 0;	//max_c계산을 위한 임시값
		for(int i = 0; i<= max_r; i++) {
			// map에 (A[i][j],등장횟수)로 추가 
			for(int j=0; j<=max_c; j++) {
				if(A[i][j] == 0)             
					continue;
				else {
					if(map.containsKey(A[i][j])== false)
						map.put(A[i][j], 1);
					else {
						int val = (int)map.get(A[i][j]);
						map.put(A[i][j], val+1);
					}
					A[i][j] = 0;
				}
			}
			
			if(map.isEmpty()) continue; 
			
			int j=0;
			
			while(!(map.isEmpty())) {
				int min_val = Collections.min(map.values());
				int min_key = (int)getKeyFromValue(map, min_val);
				A[i][j] = min_key;
				A[i][j+1] = min_val;
				System.out.print(A[i][j] + " " + A[i][j+1] + " ");
				map.remove(min_key);
				
				if(j+1 > tmp)	tmp = j+1;
				j += 2;
			}
			System.out.println();
		}
		System.out.println("===============");
		max_c = tmp;
		System.out.println(max_c);
	}
	
	static void column(int[][]A) {
		System.out.println("c연산");
		tmp = 0;	//max_c계산을 위한 임시값
		for(int j = 0; j<= max_c; j++) {
			// map에 (A[i][j],등장횟수)로 추가 
			for(int i=0; i<=max_r; i++) {
				if(A[i][j] == 0)             
					continue;
				else {
					if(map.containsKey(A[i][j])== false)
						map.put(A[i][j], 1);
					else {
						int val = (int)map.get(A[i][j]);
						map.put(A[i][j], val+1);
					}
					A[i][j] = 0;
				}
			}
			
			if(map.isEmpty()) continue; 
						
			int i=0;
			
			while(!(map.isEmpty())) {
				int max_val = Collections.min(map.values());
				int max_key = (int)getKeyFromValue(map, max_val);
				A[i][j] = max_key;
				A[i+1][j] = max_val;
				System.out.print(A[i][j] + " " + A[i+1][j] + " ");
				map.remove(max_key);
				if(i+1 > tmp)	tmp = i+1;
				i += 2;
			}
			System.out.println();
		}
		System.out.println("===============");
		max_r = tmp;
		System.out.println(max_r);
	}
	
	public static void main(String[] args) {
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		while(A[r-1][c-1] != k && time <= 100){
			if(rc == 0) {	//r연산 
				row(A);
				if(max_r < max_c)	rc = 1;
			}
			else {			//c연산 
				column(A);
				if(max_r >= max_c)	rc = 0;
			}
			time +=1;
		}
		
		if (time > 100)
			System.out.println(-1);
		else
			System.out.println(time);
		
	}

}
