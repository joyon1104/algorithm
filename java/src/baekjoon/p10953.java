package baekjoon;
import java.util.*;

public class p10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t=0; t<T; t++) {
			String str = sc.nextLine();
			String[] list = str.split(",");
			int a = Integer.parseInt(list[0]);
			int b = Integer.parseInt(list[1]);
			
			System.out.println(a+b);
		}
	}
}
