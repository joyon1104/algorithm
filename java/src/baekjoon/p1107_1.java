package baekjoon;
import java.util.*;
/*
 * 따라서 굳이 복잡한 수학적 방식이 아닌, 
 * 모든 숫자를 1번씩 선택해가며 최소값을 구하는 브루트포스 방식을 적용하면 쉽게 해결이 가능하다.
 * => 꼭 차이의 최솟값이 최선이 아닐 수 있음! 참조 : http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=221354997206&categoryNo=49&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
 */

public class p1107_1 {
	static int c;
	static int N;
	static char[] carr;
	static int[] button;
	
	static boolean check(int n) {
		boolean ch = true;
		char[] carr = Integer.toString(n).toCharArray();
		
		for(int i=0; i<carr.length; i++) {
			int idx = (int)carr[i] - (int)'0';
			if(button[idx] == -1) {
				ch = false;
				break;
			}
		}
		return ch;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		button = new int[10];
		c = sc.nextInt();
		N = sc.nextInt();
		if(N==0)
			System.out.println(Math.min(c-100, Integer.toString(c).length()));
		else {
			for(int i=0; i<N; i++) {
				button[sc.nextInt()] = -1;
			}
			int min = c-100;
			if(min <0)
				min*=-1;
			for(int i=0; i<=1000001; i++) {
				if(check(i)==false)
					continue;
				int l = Integer.toString(i).length();
				int k = Math.abs(c-i);
				if(k <0)
					k*=-1;
				if(min > l+k)
					min = l+k;
			}
			System.out.println(min);
		}
	}
}
