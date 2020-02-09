package baekjoon;
import java.util.*;

public class p11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String[] arr = new String[word.length()];
		for(int i=0; i<word.length(); i++) {
			String tmp = word.substring(i,word.length());
			arr[i] = tmp;
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}
