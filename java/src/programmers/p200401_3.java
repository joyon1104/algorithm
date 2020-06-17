package programmers;
/*
 * [기지국 설치]
 * -> 그리디 알고리즘
 * 참고 : https://healthydeveloper.tistory.com/39?category=675593
 */
class p200401_3 {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int idx = 0;
        int location = 1;
        while(location<=n) {
            if(idx<stations.length && location >= stations[idx]-w) {
                location = stations[idx]+w+1;
                idx++;
            }else {
                location += 2*w+1;
                ans++;
            }
        }
        return ans;
    }
}

