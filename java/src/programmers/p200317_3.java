package programmers;
/*
 * [N으로 표현]
 * -> dp문제이지만, 완전탐색으로 풀었음
 * 참고 : https://heunnnn.github.io/DP(1)-N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84/
 */
class p200317_3 {
    int answer = -1;

    public int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }

    public void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) {
            nn=nn*10+n;
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }
}