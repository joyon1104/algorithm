package baekjoon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 190806
 * 
 * 백준 3085번
 * -> 분류 : 브루트 포스 
 * 
 * [ 사탕 게임 ]
 * 탐색방법
 * 1. 특정 위치 board[i][j]를 기준으로 오른쪽(board[i][j+1])과 아래쪽(board[i+1][j]) 위치를 바꾼다.
 * 		- 만일 board[i][j]가 마지막 행에 있는 경우 -> 더이상 아래 행이 존재하지 않으므로 오른쪽 배열이랑만 위치 바꿈.
 * 		- 만일 board[i][j]가 마지막 열에 있는 경우 -> 더이상 오른쪽 열이 존재하지 않으므로 아래쪽 배열이랑만 위치 바꿈.
 * 		- 만일 board[i][j]가 마지막 행,열에 있는 경우 -> 위치를 바꿀 수 없음.(바꿀필요 없음, 이미 이전에 계산됨)
 * 2. 위치를 바꾼 배열을 입력받아 사탕 개수를 계산한다.
 * 		- 특정 위치 board[i][j]를 기준으로
 * 			- 행방향 탐색 : board[i][j+1] or board[i][j-1]이 board[i][j]와 같은지 비교하며 확장. (j를 N-1까지 늘리거나, 0까지 줄임)
 * 			- 열방향 탐색 : board[i+1][j] or board[i-1][j]이 board[i][j]와 같은지 비교하며 확장. (i를 N-1까지 늘리거나, 0까지 줄임)
 * 3. 2번에서 계산한 사탕 개수 n이 map에 존재하는 해당 사탕의 개수보다 크면, map의 value값을 n으로 갱신
 * 4. 모든 인덱스의 배열을 탐색한 후, map의 사탕의 개수(value)들 중 가장 큰 value를 리턴한다.
 * 
 */

public class p3085 {
	static int N;
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	
	static void check(String[][] board) {
		String[][] tmp = deepCopy(board);	// 이중배열 복사
		
		//1번
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == N-1 && j != N-1)	
					row(tmp, i, j);
				else if(i != N-1 && j == N-1) {
					column(tmp, i, j);
				}
				else if(i == N-1 && j == N-1)
					break;
				else {
					row(tmp, i, j);
					column(tmp, i, j);
				}
			}
		}
	}
	
	// 현재 위치 board[i][j]를 기준으로 오른쪽(board[i][j+1])과 위치를 바꿔줌.
	static void row(String[][] board, int i, int j) {
		String[][] tmp = deepCopy(board);
		String t = tmp[i][j];
		tmp[i][j] = tmp[i][j+1];
		tmp[i][j+1] = t;
		columnCheck(tmp, i, j);		// 위치를 바꾼 후, 사탕 개수 계산 (j열, j+1열, i행의 사탕 개수 계산)
		columnCheck(tmp, i, j+1);	
		rowCheck(tmp, i, j);
	}
	
	static void column(String[][] board, int i, int j) {
		String[][] tmp = deepCopy(board);
		String t = tmp[i][j];
		tmp[i][j] = tmp[i+1][j];
		tmp[i+1][j] = t;
		rowCheck(tmp, i, j);		// 위치를 바꾼 후, 사탕 개수 계산 (i행, i+1행, j열의 사탕 개수 계산)
		rowCheck(tmp, i+1, j);
		columnCheck(tmp, i, j);
	}
	
	// board에서 특정 행에서 연속적으로 존재하는 사탕의 개수를 계산한다.
	static void rowCheck(String[][] board, int i, int j) {
		String tmp = board[i][j];
		int n = 0;
		
		for(int jl = j; jl>=0; jl--) {
			if(board[i][jl].equals(tmp))
				n++;
			if(!(board[i][jl].equals(tmp)))	//연속되지 않으면 break; <- 이거를 놓쳐서 시간 많이 걸림;;
				break;
		}
		for(int jr = j; jr<N; jr++) {
			if(board[i][jr].equals(tmp))
				n++;
			if(!(board[i][jr].equals(tmp)))	//연속되지 않으면 break;
				break;
		}
		n = n-1;
		if(n > map.get(tmp))	// 계산한 사탕 개수가 최대값인지 판별
				map.put(tmp,n);
	}
	
	// board에서 특정 열에서 연속적으로 존재하는 사탕의 개수를 계산한다.
	static void columnCheck(String[][] board, int i, int j) {
		
		String tmp = board[i][j];
		int n = 0;
		
		for(int iu = i; iu>=0; iu--) {
			if(board[iu][j].equals(tmp))
				n++;
			if(!(board[iu][j].equals(tmp)))	//연속되지 않으면 break;
				break;
		}
		for(int id = i; id<N; id++) {
			if(board[id][j].equals(tmp))
				n++;
			if(!(board[id][j].equals(tmp)))	//연속되지 않으면 break;
				break;
		}
		n = n-1;
		if(n > map.get(tmp))	// 계산한 사탕 개수가 최대값인지 판별
				map.put(tmp,n);
	}
	
	
	static void printBoard(String[][] board) {
		for(int i =0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println("========");
	}
	
	//이중배열 복사하는 메소드 
	private static String[][] deepCopy(String[][] original2) {
        if(original2 == null) return null;
        String[][] result = new String[original2.length][original2[0].length];
         
        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }
         
        return result;
    }
	
	public static void main(String[] args) {
		N = sc.nextInt();
		String [][] board = new String[N][N];
		
		for(int i=0; i<N ; i++) {
			String line = sc.next();
			String[] tmp = line.split("");
			for(int j=0; j<N; j++) {
				board[i][j] = tmp[j];
			}
		}
		
		map.put("C", 0);
		map.put("P", 0);
		map.put("Z", 0);
		map.put("Y", 0);
		
		check(board);
		
		System.out.println(Collections.max(map.values()));
	}
}
