package programmers;

/*
 * [타겟 넘버]
 */
class p200309_4 {
    static int answer;
    
    static void dfs(int[] numbers,int target,int n, int cnt, int result){
        if(n==cnt){
            if(result==target)
                answer++;
        }
        else{
            dfs(numbers,target,n,cnt+1,result+numbers[cnt]);
            dfs(numbers,target,n,cnt+1,result-numbers[cnt]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, numbers.length, 0, 0);
        return answer;
    }
}