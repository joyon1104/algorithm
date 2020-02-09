package baekjoon;
import java.util.*;

/*
 * 진법변환
 */

public class p2745 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		
		String n = arr[0];
		int b = Integer.parseInt(arr[1]);
		
		int res = 0;
		for(int i = 0; i< n.length(); i++) {
			char c = n.charAt(i);  // 한 char씩 추출
			int temp = (int)c;  // int형으로 바꿔 temp에 저장
			if(temp >= 65) {  // 9보다 클 경우 A가 65부터 시작되므로 55를 뺌
				temp -= 55;
			}
			else {
				temp -= 48;
			}
			res += temp * Math.pow(b,(n.length()-1)-i);  // 자릿수만큼 곲해 res에 더해줌
		}
		System.out.println(res);
	}
}
