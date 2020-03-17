package programmers;

/*
 * [땅따먹기]
 */

class p200310_4 {
    int solution(int[][] land) {
        int answer = 0;

        if(land.length>1){
            for(int i=0; i<land.length-1; i++){
                int[] arr = new int[4];
                for(int j=0; j<4; j++){
                    for(int k=0; k<4; k++){
                        if(j!=k) arr[k] = Math.max(arr[k],land[i+1][k]+land[i][j]);
                    }
                }
                for(int j=0; j<4; j++)
                    land[i+1][j] = arr[j];
            }
        }
        
        for(int i=0; i<4; i++){
            if(answer < land[land.length-1][i])
                answer = land[land.length-1][i];
        }

        return answer;
    }
}