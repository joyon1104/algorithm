package baekjoon;
import java.util.*;

/*
 * <진수 변환 API>
 * 1. 10진수 -> 2,8,16진수
 * 	int num = 77;
	String a2 = Integer.toBinaryString(num);  // 10진수 -> 2진수
	String a8= Integer.toOctalString(num);    // 10진수 -> 8진수
	String a16 = Integer.toHexString(num);    // 10진수 -> 16진수
 * 2. 2,8,16진수 -> 10진수
 * 	int a2_2 = Integer.parseInt(a2, 2);
	int a8_8 = Integer.parseInt(a8, 8);
	int a16_16 = Integer.parseInt(a16, 16);
	
	그러나, 여기서는 api 사용하면 안됨.
	[해결법]
	110101 이라는 이진수가 있을 때
	세 자리씩 끊어서 10진수로 변환하면 8진수가 된다.
 */

public class p1373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		
		if(n.length()%3 == 1) {
			n = "00"+n;
		}
		else if(n.length()%3 == 2) {
			n = "0"+n;
		}
		for(int i=0; i<n.length(); i+=3) {
			String temp = n.substring(i,i+3);
			System.out.print(Integer.parseInt(n.substring(i,i+1))*4 
					+ Integer.parseInt(n.substring(i+1,i+2))*2
					+ Integer.parseInt(n.substring(i+2,i+3)));
		}
	}
}
