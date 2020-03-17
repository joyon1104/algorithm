package programmers;

/*
 * [탑]
 */

class p200304_4 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i=1; i<heights.length; i++){
            for(int j=i-1; j>=0; j--){
                if(heights[j]> heights[i]){
                    answer[i] = j+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}