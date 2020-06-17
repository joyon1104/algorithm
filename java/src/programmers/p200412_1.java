package programmers;
/*
 * [주식 가격]
 */
class p200412_1 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int sum = 0;
            for(int j=i+1; j<prices.length; j++){
                sum++;
                if(prices[i] > prices[j])
                    break;
            }
            answer[i] = sum;
        }
        return answer;
    }
}