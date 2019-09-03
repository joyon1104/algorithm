package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 190828
 * 
 * 백준 삼성 SW 역량 테스트 기출 문제
 * 
 * 3190번 
 * [뱀]
 * 
 * -> 성공 
 * 
 * < 구현 방법 >
 * - board[N+2][N+2]로 잡아서 벽까지 생각해 줌.
 * - board 배열에 빈공간:0 / 사과:1 / 뱀:-1 로 표시.
 * - 방향 변환 정보는 hashmap에 <Integer,String>으로 저장
 * - direction 배열은 동,남,서,북 순 (시계방향)
 * - 뱀의 영역은 ArrayList<Pair> 로 저장.
 * 
 * 1. 처음 시작 시, 뱀은 board[1][1]에 위치 -> board[1][1] = -1, head = Pair(1,1), arrlist에 head를 넣음.
 * 
 * 2. 뱀이 다음에 갈 행, 열 next_i, next_j를 설정 (direction에 따라 행,열에 더해주는 값이 다름)
 * 3. time++;
 * 4. 뱀이 다음에 갈 행,열이 갈 수 있는 영역인지 isStop함수로 판단 -> true를 리턴하면 종료.
 * 	  - isStop : 행,열이 벽의 영역인지, 뱀의 영역인지 판단하여 true, false를 판단
 * 5. 갈 수 있는 영역이면, arrlist 맨 앞에 Pair(next_i, next_j)를 추가한다. ( ArrayList메소드의 add(0,Pair)를 쓰면 맨 앞에 Pair을 추가하고 나머지는 한칸씩 뒤로 밀림)
 * 6. 다음에 갈 영역에 사과가 없었으면 맨 끝을 한칸 없애야 함. -> arrlist의 가장 마지막 원소를 제거, 해당 원소의 board 값을 0으로 바꿔줌.
 * 7. 다음 갈 영역 위치의 board값을 -1로 바꿔준다. head도 다음 갈 영역으로 새로 갱신. (6번 전에 하면, 사과가 있었는지 확인하지 못한다.)
 * 8. 방향을 바꿀 시간인지 hashmap의 key를 검색해 확인한다.
 * 	  - 맞으면, 해당 value에 맞게 direction을 갱신해야함.
 * 	  - 이전 direction값과 value(L,D)에 따라 다음 direction이 달라짐. (구현 참조)
 * 
 * 9. 위 while문은 벽에 부딪히거나 뱀에 부딪히면 종료함으로 종료되면 해당 시간을 return하면서 종료한다.
 * 
 * */

public class p3190 {

	static int N,K,L;
	static int board[][];
	static int time,direction;
	static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static Scanner sc = new Scanner(System.in);
	
	static class Pair {
		int i;
		int j;
		
		Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static boolean isStop(int i, int j) {
		if(i==0 || j==0 || i==N+1 || j==N+1)
			return true;
		else if(board[i][j] == -1)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		board = new int[N+2][N+2];
		
		K = sc.nextInt();
		for(int k=0; k<K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			board[i][j] = 1;
		}
		
		L = sc.nextInt();
		HashMap<Integer, String> hashmap = new HashMap<Integer,String>();
		
		for(int l=0; l<L; l++) {
			int X = sc.nextInt();
			String C = sc.next();
			hashmap.put(X, C);
		}
		
		board[1][1] = -1;
		Pair p = new Pair(1,1);
		ArrayList<Pair> arrlist = new ArrayList<Pair>();
		arrlist.add(p);
		
		Pair head = new Pair(1,1);
		direction = 0;

		while(true) {
			
			int next_i = head.i + move[direction][0];
			int next_j = head.j + move[direction][1];
			
			time++;
			
			if(isStop(next_i, next_j) == true)
				break;
			
			Pair tmp = new Pair(next_i,next_j);
			arrlist.add(0,tmp);

			if(board[next_i][next_j] != 1) {
				Pair tail = arrlist.get(arrlist.size()-1);
				board[tail.i][tail.j] = 0;
				arrlist.remove(arrlist.size()-1);
			}
			
			board[next_i][next_j] = -1;
			head = new Pair(next_i,next_j);
			
			if(hashmap.containsKey(time)) {
				if(direction == 0 && hashmap.get(time).equals("L"))			// 동 + 왼쪽 => 북 
					direction = 3;
				else if (direction == 0 && hashmap.get(time).equals("D"))	// 동 + 오른쪽 => 남 
					direction = 1;
				else if(direction == 1 && hashmap.get(time).equals("L"))	// 남 + 왼쪽 => 동 
					direction = 0;
				else if (direction == 1 && hashmap.get(time).equals("D"))	// 남 + 오른쪽 => 서
					direction = 2;
				else if(direction == 2 && hashmap.get(time).equals("L"))	// 서 + 왼쪽 => 남 
					direction = 1;
				else if (direction == 2 && hashmap.get(time).equals("D"))	// 서 + 오른쪽 => 북
					direction = 3;
				else if(direction == 3 && hashmap.get(time).equals("L"))	// 북 + 왼쪽 => 서
					direction = 2;
				else if (direction == 3 && hashmap.get(time).equals("D"))	// 북 + 오른쪽 => 동
					direction = 0;
			}
		}
		
		System.out.println(time);
	}
}
