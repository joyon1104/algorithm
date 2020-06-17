package baekjoon;
import java.util.*;

/*
 * [주사위 윷놀이]
 */

public class p17825 {

	// 윷놀이 판
	static int[] A = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,-1, // 0~21
					10,13,16,19,25,30,35,40,-1,	// 22~30
					20,22,24,25,30,35,40,-1,	// 31~38
					30,28,27,26,25,30,35,40,-1	// 39~47
	};
	
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dice = new int[10];  //주사위 10회 던진 기록
		for(int i=0; i<10; i++)
			dice[i] = sc.nextInt();
		max = 0;
		int[] turn = new int[10];  // dfs로 10회 turn동안 어떤 말이 움직일 지 저장하는 배열
		for(int i=0; i<4; i++) {
			turn[0] = i;
			dfs(dice,turn,0,1);
		}
		System.out.println(max);
	}
	
	static void dfs(int[] dice, int[] turn, int idx, int cnt) {
		if(cnt==10) {
			play(dice, turn); 	// 윷놀이 시작
		}
		else {
			for(int i=0; i<4; i++) {
				turn[idx+1] = i;
				dfs(dice,turn,idx+1,cnt+1);
			}
		}
	}
	
	static void play(int[] dice, int[] turn) {
		int[] check = new int[4]; //말의 위치(index)를 담는 배열, -1이면 움직일 수 없음.
		int result = 0;
		for(int i=0; i<10; i++) {
			int horse = turn[i];  // 움직일 말
			int now = check[horse];  // 말의 현재 인덱스 정보
			if(now==-1)  // 움직일 수 없는 말일 경우 -> return
				return;
			int next = move(now,dice[i]);  // move함수를 통해 이동할 인덱스를 추출
			if(next == -1) {	// 만일 말이 도착한 경우
				check[horse] = next;  // result에 점수를 합하지 않고, 현재 말 인덱스를 next 인덱스로 초기화
				continue;
			}
			
			for(int j=0; j<4; j++) {  // 움직이려는 인덱스에 이미 말이 있는지 확인
				if(check[j] != -1 && isSame(check[j], next))
					return;
			}
			check[horse] = next;  // 현재 말 인덱스를 next로 초기화
			result += A[next];   // result 점수 더하기
		}
		
		//최대값 설정
		if(max < result) {
			max = result;
		}
	}
	
	// 인덱스가 다르더라도 실제로 같은 위치인경우를 판별하기 위한 함수 -> true(같음) / false(다름)
	static boolean isSame(int idx1, int idx2) {
		boolean result = false;
		
		if(A[idx1] == A[idx2] && (A[idx1]==25 || A[idx1]==35 || A[idx1]==40))
			result = true;
		else if(A[idx1] == A[idx2] && A[idx1]==30) {
			if(idx1 != 39 && idx2 !=39)
				result = true;
			else if(idx1 == 39 && idx1==idx2)
				result = true;
		}
		else if(idx1 == idx2)
			result = true;
		
		return result;
	}
	
	// 먈 인덱스 움직이기 위한 함수
	static int move(int now, int d) {
		int next = now+d;
		if(now>=0 && now<=20) {
			if(next>=21)
				return -1;
			else {
				if(A[next] == 10)
					return 22;
				else if(A[next]==20)
					return 31;
				else if(A[next]==30)
					return 39;
				else return next;
			}
		}
		else if(now>=22 && now<=29 && next>=30)
			return -1;
		else if(now>=31 && now<=37 && next>=38)
			return -1;
		else if(now>=39 && now<=46 && next>=47)
			return -1;
		else return next;
	}
}
