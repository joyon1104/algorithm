package programmers;
/*
 * [소수 만들기]
 */
import java.util.*;
class p200313_3 {
    static boolean isPrime(int n){
        if(n==1)
            return false;
        for(int i=2; i<=n/2; i++){
            if(n%i ==0)
                return false;
        }
        return true;
    }
    
    static int answer;
    static void dfs(int[]arr, int[]nums, int[]visited, int cnt){
        if(cnt == arr.length){
            int tmp = 0;
            for(int x : arr)
                tmp += nums[x];
            if(isPrime(tmp))
                answer++;
        }
        else{
            int i = 0;
            if(cnt>0) i = arr[cnt-1]+1;
            for(; i<nums.length; i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    arr[cnt] = i;
                    dfs(arr,nums,visited,cnt+1);
                    visited[i] = 0;
                }
            }
        }
    }
    public int solution(int[] nums) {
        answer = 0;
        int[]arr = new int[3];
        int[]visited = new int[nums.length];
        dfs(arr,nums,visited,0);

        return answer;
    }
}