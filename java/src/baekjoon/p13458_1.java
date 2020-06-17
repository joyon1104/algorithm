package baekjoon;
import java.util.*;

public class p13458_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] room = new int[N];
		for(int i=0; i<N; i++) {
			room[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			int student = room[i];
			if(student <= B) {
				sum++;
				continue;
			}
			student -= B;
			sum++;
			
			sum += student/C;
			if(student%C>0)
				sum++;
		}
		System.out.println(sum);
	}
}
