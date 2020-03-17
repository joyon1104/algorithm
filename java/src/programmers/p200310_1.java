package programmers;

import java.util.*;
/*
 * [가장 큰 정사각형 찾기]
 */

class p200310_1
{
    public int solution(int [][]board)
    {
        int max = 0;
        int answer = 0;
        if(board.length==1 || board[0].length==1){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == 1)
                        return 1;
                }
            }
            return 0;
        }
        else{
            for(int i=1; i<board.length; i++){
                for(int j=1; j<board[0].length; j++){
                    if(board[i][j] == 1){
                        board[i][j] = Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1])) +1;
                        if(max < board[i][j]) max = board[i][j];
                    }
                }
            }
        }
        answer = max * max;
        return answer;
    }
}