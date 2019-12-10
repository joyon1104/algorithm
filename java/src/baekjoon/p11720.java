package baekjoon;
import java.util.Scanner;

public class p11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		String[] array = str.split("");	//한글자씩 자르기
		int sum = 0;
		
		for(int t=0; t<T; t++) {
			sum+= Integer.parseInt(array[t]);
		}
		System.out.println(sum);
	}
}
