package programmers;

/*
 * [멀쩡한 사각형]
 * => 망가진 사각형 = W+H - (W와 H의 최대공약수)
 */
class p200306_1 {
    
    public long gcd (long a, long b){
        if(a%b == 0)
            return b;
        return gcd(b, a%b);
    }
    
	public long solution(long w,long h) {
		long answer = 1;
        long big = (w>h?w:h);
        long small = (w<h?w:h);
        
        answer = (w*h) - (w + h - gcd(big, small)); // 망가진 사각형 :
		return answer;
	}
}