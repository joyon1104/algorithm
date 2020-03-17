package programmers;
/*
 * [점프와 순간 이동]
 * 	1. 최대거리를 계속 2로나눔
	2. 2로 안나눠지면 -1하고 1이 될 때 까지 2로 나눔
	3. -1할 때 마다 건전지++
	4. 마지막 1이 됐을 때 건전지++하고 끝
 */
class p200313_6
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }

        return answer;
    }
}