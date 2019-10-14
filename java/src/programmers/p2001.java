package programmers;

class p2001 {
    public long solution(int N) {
        long answer = 0;
        
        long[] arr = new long[N+2];
        
        fibo(N+1, arr);
        
        answer = arr[N]*2 + arr[N+1] *2;
        return answer;
    }
    
    public static long fibo(int N, long[] arr){
        if(N == 1 || N == 2)
            arr[N] = 1;
            
        else if(arr[N] == 0)
            arr[N] = fibo(N-1, arr) + fibo(N-2, arr);
        
        return arr[N];
    }
}