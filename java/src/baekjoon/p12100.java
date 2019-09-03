package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 190827
 * 
 * 백준 삼성 SW 역량 테스트 기출 문제 
 * 
 * 12100번 
 * [2048 easy]
 * 
 * -> 실패
 * 
 * < 구현방법 >
 * - 다시 정리 할 것! 
 * 
 * 
 * */


public class p12100 {

	static Scanner sc = new Scanner(System.in);
	static int N, cnt, max;
	static int map[][];
	static int tmp[][];
	static boolean change;
	
	static int find_max(int[][] map) {
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(max < map[i][j])
					max = map[i][j];
			}
		}
		return max;
	}
	
	static void merge(int d)
	{
	    Queue<Integer> q = new LinkedList<Integer>();
	    int cnt = 0;
	 
	 
	    switch (d){
	 
	    case 0://위
	        for (int i = 0; i < N; i++){
	            for (int j = 0; j < N; j++){
	                if (map[j][i] != 0) q.offer(map[j][i]);
	                map[j][i] = 0;
	            }
	 
	            int idx = 0;
	            int poll_data;
	 
	            while (!q.isEmpty()){
	                poll_data = q.peek();
	                q.poll();
	 
	                if (map[idx][i] == 0) map[idx][i] = poll_data;
	                else if (map[idx][i] == poll_data){
	                    map[idx][i] *= 2;
	                    idx++;
	                }
	                else map[++idx][i] = poll_data;
	            }
	 
	        }
	        break;
	    case 1://아래
	        for (int i = 0; i < N; i++){
	            for (int j = N - 1; j >= 0; j--){
	                if (map[j][i] != 0) q.offer(map[j][i]);
	                map[j][i] = 0;
	            }
	 
	            int idx = N - 1;
	            int poll_data;
	 
	            while (!q.isEmpty()){
	                poll_data = q.peek();
	                q.poll();
	 
	                if (map[idx][i] == 0) map[idx][i] = poll_data;
	                else if (map[idx][i] == poll_data){
	                    map[idx][i] *= 2;
	                    idx--;
	                }
	                else map[--idx][i] = poll_data;
	            }
	        }
	        break;
	        
	    case 2://왼
	        for (int i = 0; i < N; i++){
	            for (int j = 0; j < N; j++){
	                if (map[i][j] != 0) q.offer(map[i][j]);
	                map[i][j] = 0;
	            }
	 
	            int idx = 0;
	            int poll_data;
	 
	            while (!q.isEmpty()){
	                poll_data = q.peek();
	                q.poll();
	 
	                if (map[i][idx] == 0) map[i][idx] = poll_data;
	                else if (map[i][idx] == poll_data){
	                    map[i][idx] *= 2;
	                    idx++;
	                }
	                else map[i][++idx] = poll_data;
	            }
	 
	        }
	        break;
	 
	    case 3://오
	        for (int i = 0; i < N; i++){
	            for (int j = N - 1; j >= 0; j--){
	                if (map[i][j] != 0) q.offer(map[i][j]);
	                map[i][j] = 0;
	            }
	 
	            int idx = N - 1;
	            int poll_data;
	 
	            while (!q.isEmpty()){
	                poll_data = q.peek();
	                q.poll();
	 
	                if (map[i][idx] == 0) map[i][idx] = poll_data;
	                else if (map[i][idx] == poll_data){
	                    map[i][idx] *= 2;
	                    idx--;
	                }
	                else map[i][--idx] = poll_data;
	            }
	        }
	        break;
	 
	 
	    }
	}
	
	static void compress(int[][] tmp, ArrayList<Integer> list, int ij, int p) {
			
			for(int i=0; i+1<list.size(); i++) {
				if(list.get(i) == list.get(i+1)) {
					list.set(i, list.get(i)*2);
					list.remove(i+1);
				}
			}
			
			if(p==0) {
				for(int index = 0; index<list.size(); index++) {
					tmp[index][ij] = list.get(index);
				}
			}
			else if(p==1){
				for(int index = 0; index<list.size(); index++) {
					tmp[N-1-index][ij] = list.get(index);
				}
			}
			else if(p==2){
				for(int index = 0; index<list.size(); index++) {
					tmp[ij][index] = list.get(index);
				}
			}
			else if(p==3){
				for(int index = 0; index<list.size(); index++) {
					tmp[ij][N-1-index] = list.get(index);
				}
			}
	}
	
	static int[][] move_map(int[][] map, int p){
		tmp = new int[N][N];
		ArrayList<Integer> list;
		
		if(p==0) {
			for(int j=0; j<N; j++) {
				list = new ArrayList<Integer>();
				for(int i=0; i<N; i++) {
					if(map[i][j] != 0)
						list.add(map[i][j]);
				}
				compress(tmp,list,j,p);
			}
		}
		
		else if(p==1) {
			for(int j=0; j<N; j++) {
				list = new ArrayList<Integer>();
				for(int i=N-1; i>=0; i--) {
					if(map[i][j] != 0)
						list.add(map[i][j]);
				}
				compress(tmp,list,j,p);
			}
		}
		
		else if(p==2) {
			for(int i=0; i<N; i++) {
				list = new ArrayList<Integer>();
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0)
						list.add(map[i][j]);
				}
				compress(tmp,list,i,p);
			}
		}
		
		else if(p==3) {
			for(int i=0; i<N; i++) {
				list = new ArrayList<Integer>();
				for(int j=N-1; j>=0; j--) {
					if(map[i][j] != 0)
						list.add(map[i][j]);
				}
				compress(tmp,list,i,p);
			}
		}
		
		return tmp;
	}
	
	static void DFS(int[][] map, int cnt) {
		
		if(cnt>5) {
			max = Math.max(find_max(map),max);
			return;
		}
		else {
			for(int p=0; p<4; p++) {
				int[][] tmp = move_map(map,p);
				DFS(tmp,cnt+1);
			}
			
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		map = new int[N][N];
		max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		
		DFS(map,0);
		System.out.print(max);
	}
}
