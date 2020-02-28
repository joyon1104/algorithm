package baekjoon;
import java.util.*;

public class p10610 {
	static String N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLine();
		arr = new int[10];
		String ans = "";	// 결과 출력을 위한 변수
		int sum = 0;		// 3으로 나눠 나머지가 0이면 3의 배수, 0이 아니면 3의배수 아님을 판단하기 위한 변수
		
		//N에 0~9까지의 숫자가 각각 몇개씩 있는지 알기 위해 배열에 담음.
		for(int i=0; i<N.length(); i++) {
			arr[N.charAt(i)-'0']++; 	// '1'(char)을 int로 바꿔줌
		}
		
		// N에 0이없으면 30의 배수가 될 수 없다.
		if(arr[0]==0) 
			ans = "-1";
		else {		// 0이 있으면 3의 배수인지 확인하기 위해 모든 숫자의 총합을 구함.
			for(int i=9; i>=0; i--) {	// 거꾸로부터 탐색하여, ans에 최대의 30의 배수를 구한다.
				while(arr[i]>0) {
					sum += i;	// 3의 배수인지 알기 위한 변수 sum (숫자덧셈)
					ans += i;	// 결과값 출력을 위해 string변수에 인덱스를 더함 (문자열합치기)
					arr[i]--;
				}
			}
		}
		// 각 자리 숫자 총합인 sum에서 3으로 나눠지면 3의 배수, 아니면 3의배수가 아님.
		if(sum%3 != 0)
			ans = "-1";
		System.out.println(ans);
	}
}
