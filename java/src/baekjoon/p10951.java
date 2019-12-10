package baekjoon;
import java.util.Scanner;

public class p10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력값이 int형이므로 sc.hasNextInt()를 써도 무방
		while(sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(A+B);
		}
	}
}
