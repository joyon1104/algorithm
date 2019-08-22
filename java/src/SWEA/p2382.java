package SWEA;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 190822
 * 
 * SW Expert Academy
 * [모의 SW 역량테스트] 미생물 격리 
 * 
 * ->성공 
 * 
 * < 구현방법 >
 * - hashmap : 처음 들어온 미생물 순서를 key로 하여, <Integer, Microbe> 형태로 미생물을 저장.
 * - keyset[] : 살아있는 미생물의 key 인덱스는 1, 죽었으면 0
 * - location[][] : 이동한 미생물의 위치에 해당 미생물의 key값을 넣는다.
 * 
 * 1. Microbe객체 (행, 열, 미생물 개수, 방향) 생성 
 * 2. hashmap에 모든 미생물 저장.
 * 3. M시간 동안 방향에 따라 미생물 이동. (미생물의 i,j값도 next_i, next_j로 변경)
 * 		- location[next_i][next_j] == 0 이면 바로 해당 위치의 미생물 key 삽입. -> 
 * 		- location[next_i][next_j] != 0 (이미 다른 미생물이 존재)하면 -1로 바꿈.
 * 4. 한 시간마다 merge함수와 checkDrug함수를 실행.
 * 		- merge함수
 * 		 : 1) location[i][j]가 -1인 곳을 찾아 해당 위치의 i,j값을 가지는 hashmap의 미생물을 찾는다.
 * 		   2) 기존 location에 존재하는 미생물과 새로 들어가려는 미생물의 cnt값을 비교하여 더 큰 미생물의 key값을 location[i][j]에 넣는다.
 * 		   3) 크기 경쟁에서 밀린 미생물은 hashmap에서 삭제하고, keyset에도 0으로 바꿔줘야 한다.
 * 		   4) 미생물의 총합은 따로 계산하여, 모든 비교가 끝난 후에 갱신한다.
 * 		- checkDrug함수
 * 		 : 약이 칠해진 영역인 경우를 선별하여 drug함수를 실행시킨다.
 * 		- drug함수
 * 		 : 약에 노출된 경우이므로, 미생물의 개수를 반감시키고, 방향을 반대방향으로 바꿔준다.
 * 5. 모든 시간이 지나고 hashmap에 남아있는 미생물의 개수만 모두 더하여 결과값을 출력한다.
 * 
 */

public class p2382 {

	static Scanner sc = new Scanner(System.in);
	static int N,M,K;
	static int[][] location;
	static HashMap<Integer, Microbe> hashmap;
	static int[] keyset = new int[1000+1];
	
	static int[] move_i = {0,-1,1,0,0};
	static int[] move_j = {0,0,0,-1,1};
	
	static class Microbe{
		int i;
		int j;
		int cnt;
		int d;
		
		public Microbe(int i, int j, int cnt, int d) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.d = d;
		}
	}
	
	public static void merge(HashMap<Integer, Microbe> hashmap, int[][] location) {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				if(location[i][j] == -1) {
					int max = 0;
					int sum = 0;
					for(int kh=1; kh<=K; kh++) {
						if(keyset[kh] == 1 && hashmap.get(kh).i == i && hashmap.get(kh).j == j) {
							sum += hashmap.get(kh).cnt;
							if(hashmap.get(kh).cnt > max) {
								if(location[i][j] != -1) {
									hashmap.remove(location[i][j]);
									keyset[location[i][j]] = 0;
								}
								max = hashmap.get(kh).cnt;
								location[i][j] = kh;
							}
							else {
								hashmap.remove(kh);
								keyset[kh] = 0;
							}
								
						}
					}
					hashmap.get(location[i][j]).cnt = sum;
				}
			}
		}
	}
	
	public static void checkDrug(HashMap<Integer, Microbe> hashmap, int[][] location) {
		for(int kh=1; kh<=K; kh++) {
			if(keyset[kh] == 1) {
				if(inRange(hashmap.get(kh).i,hashmap.get(kh).j ) == false) {
					drug(hashmap,kh);
				}
			}
		}
	}
	
	static boolean inRange(int x, int y) {
        return x > 0 && x < N-1 && y > 0 && y < N-1;
    }
	
	public static void drug(HashMap<Integer, Microbe> hashmap, int key) {
		hashmap.get(key).cnt = (int)(hashmap.get(key).cnt/2);
		
		if(hashmap.get(key).cnt == 0) {
			hashmap.remove(key);
			keyset[key] = 0;
		}
		else {
			if(hashmap.get(key).d == 1)
				hashmap.get(key).d = 2;
			else if(hashmap.get(key).d == 2)
				hashmap.get(key).d = 1;
			else if(hashmap.get(key).d == 3)
				hashmap.get(key).d = 4;
			else if(hashmap.get(key).d == 4)
				hashmap.get(key).d = 3;
		}
	}
	
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++){
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			keyset = new int[1000+1];
			hashmap = new HashMap<Integer,Microbe>();
			
			for(int k=1; k<=K; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int cnt = sc.nextInt();
				int d = sc.nextInt();
				
				Microbe micro = new Microbe(i, j, cnt,d);
				hashmap.put(k,micro);
				keyset[k] = 1;
			}
			
			for(int m=0; m<M; m++) {
				location = new int[N][N];
				
				for(int kh=1; kh<=K; kh++) {
					if (keyset[kh] == 1) {
						Microbe mic = hashmap.get(kh);
						
						int next_i = mic.i + move_i[mic.d];
						int next_j = mic.j + move_j[mic.d];
						
						hashmap.get(kh).i = next_i;
						hashmap.get(kh).j = next_j;
						
						if(location[next_i][next_j] == 0) 
							location[next_i][next_j] = kh;
						
						
						else //겹칠 때 
							location[next_i][next_j] = -1;
					}	
				}//
				merge(hashmap,location);
				checkDrug(hashmap,location);
			}
			
			int result = 0;
			
			for(int kh=1; kh<=K; kh++) {
				if(keyset[kh] == 1) {
					result += hashmap.get(kh).cnt;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
	
