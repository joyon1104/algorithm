package programmers;

/*
 * [4단고음]
 * 참고 : https://ydeer.tistory.com/44
 */
class p1831 {
    static int answer;
    
    public static void solve(int n, int cnt){
        if(n==1 && cnt==0)
            answer++;
        else if(n<0)
            return;
        else if(n < Math.pow(3,cnt/2))
            return;
        else{
            if(cnt >=2 && n%3==0)
                solve(n/3,cnt-2);
            solve(n-1,cnt+1);
        }
    } 
    
    public int solution(int n) {
        answer = 0;
        solve(n,0);
        return answer;
    }
}