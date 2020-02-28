package baekjoon;
import java.util.*;

public class p1931_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] time = new int[N][2];
		int endTime = -1;
		int result = 0;
		
		for(int i=0; i<N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		
		Arrays.sort(time,(time1, time2) -> time1[1]==time2[1] ? time1[0]-time2[0] : time1[1]-time2[1]);
		
		for(int i=0; i<N; i++) {
			if(time[i][0] >= endTime) {
				result++;
				endTime = time[i][1];
			}
		}
		System.out.println(result);
	}
}
