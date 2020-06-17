package programmers;
/*
 * [숫자야구]
 */

class p200413_1 {
    static int answer;
    
    static void count(String str, int[][]baseball){
        boolean check = true;
        for(int i=0; i<baseball.length; i++){
            String tmp = String.valueOf(baseball[i][0]);
            int strike =0;
            int ball =0;
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(j==k && str.charAt(j)==tmp.charAt(k))
                        strike++;
                    else if(str.charAt(j)==tmp.charAt(k))
                        ball++;
                }
            }
            if(baseball[i][1] != strike || baseball[i][2] != ball){
                check = false;
                break;
            }
        }
        
        if(check==true)
            answer++;
    }
    
    static void dfs(String str, int[] visited, int cnt, int[][]baseball){
        if(cnt==3){
            count(str,baseball);
        }
        else{
            for(int i=1; i<=9; i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    dfs(str+i, visited, cnt+1, baseball);
                    visited[i] = 0;
                }
            }
        }
        
    }
    public int solution(int[][] baseball) {
        answer = 0;
        int[] visited = new int[10];
        dfs("",visited,0,baseball);
        return answer;
    }
}