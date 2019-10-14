//package baekjoon;
//
//import java.util.*;
//
//public class p17472 {
//	
//	static Scanner sc = new Scanner(System.in);
//	static int N,M;
//	static int q =1;
//	
//	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
//	
//	static class Pair{
//		int i;
//		int j;
//		
//		public Pair(int i, int j) {
//			this.i = i;
//			this.j = j;
//		}
//	}
//	
//	public static void print(int[][]map, int n, int m) {
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	
//	public static void BFS(int[][]map, int[][]visited, Queue<Pair> que) {
//		
//		while(!(que.isEmpty())) {
//			Pair p = que.poll();
//			
//			visited[p.i][p.j] = 1;
//			
//			for(int n =0; n<4; n++) {
//				int next_i = p.i + move[n][0];
//				int next_j = p.j + move[n][1];
//				
//				if(next_i>=0 && next_i<N && next_j>=0 && next_j< M) {
//					if(map[next_i][next_j] == 1 && visited[next_i][next_j] == 0) {
//						map[next_i][next_j] = q;
//						Pair tmp = new Pair(next_i,next_j);
//						que.offer(tmp);
//					}
//				}
//			}
//		}
//		q++;
//	}
//	
//	public static void main(String[] args) {
//		N = sc.nextInt();
//		M = sc.nextInt();
//		
//		int[][]map = new int[N][M];
//		int[][]visited = new int[N][M];
//		
//		Queue<Pair> que = new LinkedList<Pair>();
//		
//		for(int n=0; n<N; n++) {
//			for(int m=0; m<M; m++) {
//				map[n][m] = sc.nextInt();
//			}
//		}
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				if(map[i][j] == 1 && visited[i][j] == 0) {
//					map[i][j] =q;
//					Pair p = new Pair(i,j);
//					que.offer(p);
//					BFS(map,visited,que);
//				}
//			}
//		}
//
//		
//		HashMap<Pair, Integer> hashmap = new HashMap<Pair, Integer>();
//		
//		for(int i=0; i<N; i++) {
//			int start = 0;
//			int end = 0;
//			int n= 0;
//			
//			for(int j=0; j<M; j++) {
//				if(start==0 && end==0 && map[i][j] >0) {
//					start = map[i][j];
//				}
//				else if(start>0 && end==0 && map[i][j] == 0) {
//					n++;
//				}
//				
//				else if(start>0 && end==0 && map[i][j]>0 && map[i][j] != start) {
//					end = map[i][j];
//					if(tmp)
//					Pair tmp = new Pair(i, j);
//					bridge(hashmap,tmp,n);
//					start = end;
//					end = 0;
//					n = 0;
//				}
//				
//			}
//		}
//	}
//	
//	public static void bridge(HashMap<Pair, Integer> hashmap, Pair tmp, int n) {
//		
//		if(hashmap.containsKey(tmp)){
//			if(hashmap.get(tmp) > n)
//				hashmap.put(tmp, n);
//		}
//		else
//			hashmap.put(tmp, n);
//	}
//
//}
