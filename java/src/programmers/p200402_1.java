package programmers;
/*
 * [N-Queen]
 * -> 백트래킹 알고리즘의 대표문제
 */
class p200402_1 {
    static int N;
    static int[] cols;
    static int result;
    
    public int solution(int n) {
        int answer = 0;
        N = n;
        cols = new int[n];
        result = 0;
        backtracking(0);
        answer = result;
        return answer;
    }
    
    static void backtracking(int level){
        if(level == N)
            result++;
        else{
            for(int i=0; i<N; i++){
                cols[level] = i;
                if(isPossible(level))
                    backtracking(level+1);
            }
        }
    }
    
    static boolean isPossible(int level){
        for(int i=0; i<level; i++){
            if(cols[i] == cols[level] || Math.abs(cols[i]-cols[level]) == Math.abs(i-level))
                return false;
        }
        return true;
    }
}