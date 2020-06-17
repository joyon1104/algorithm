package baekjoon;
import java.util.*;

public class p17825_1 {

	static int[] board = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40, // 0 ~ 20
				10,13,16,19,25,30,35,40, // 21 ~ 28
				20,22,24,25,30,35,40, // 29 ~ 35
				30,28,27,26,25,30,35,40 // 36 ~ 43
	};
	
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dice = new int[10];
		int[] turn = new int[10];
		result = 0;
		for(int i=0; i<10; i++)
			dice[i] = sc.nextInt();
		
		for(int i=1; i<=4; i++) {
			turn[0] = i;
			dfs(dice,turn,1);
		}
		
		System.out.println(result);
	}
	
	static void dfs(int[] dice, int[]turn, int cnt) {
		if(cnt == 10) {
			solve(dice,turn);
		}
		else {
			for(int i=1; i<=4; i++) {
				turn[cnt] = i;
				dfs(dice,turn,cnt+1);
			}
		}
	}
	
	static void solve(int[] dice, int[] turn) {
		int score = 0;
		int[] horse = new int[5]; // ****진짜 중요 *** 매 번 초기화되어야함!!!!!!!!!
		for(int i=0; i<10; i++) {
			int h = turn[i];
			if(horse[h] == -1) {
				return;
			}
			else {
				int next = relocate(horse[h], dice[i]);
				if(isHere(horse,next,h)) {
					return;
				}
				if(next != -1) {
					score += board[next];
				}
				horse[h] = next;
			}
		}
		if(score > result)
			result = score;
	}
	
	static boolean isHere(int[] horse, int next, int h) {
		boolean result = false;
		if(next == -1)
			return false;
		else {
			for(int i=1; i<=4; i++) {
				if(horse[i] == -1 || i == h)
					continue;
				if(next == horse[i]){
					result = true;
					break;
				}
				else {
					if((board[next] == board[horse[i]]) && (board[next] == 25 || board[next] == 35 || board[next]==40)) {
						result = true;
						break;
					}
					else if(board[next] == board[horse[i]] && board[next] == 30 && next!=36 && horse[i]!=36) {
						result = true;
						break;
					}
				}
			}
			return result;
		}
	}
	
	static int relocate(int before, int d) {
		int next = before + d;
		
		if(before<=20) {
			if(next > 20)
				next = -1;
			else if(board[next] == 10)
				next = 21;
			else if(board[next] == 20)
				next = 29;
			else if(board[next] == 30)
				next = 36;
			
		}
		else if(before<=28) {
			if(next> 28)
				next = -1;
		}
		else if(before<=35){
			if(next> 35)
				next = -1;
		}
		else if(before<=43) {
			if(next> 43)
				next = -1;
		}
		return next;
	}
}
