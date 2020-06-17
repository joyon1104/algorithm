package baekjoon;
import java.util.*;

public class p1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split("\\-");
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			String[] tarr = arr[i].split("\\+");
			int sum = 0;
			for(String ttmp : tarr) {
				sum += Integer.parseInt(ttmp);
			}
			if(i==0)
				result += sum;
			else 
				result -= sum;
		}
		System.out.println(result);
	}
}
