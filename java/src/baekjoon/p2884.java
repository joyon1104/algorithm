package baekjoon;

//6월 30일 스터디
//알람시계 (성공)

import java.util.Scanner;

public class p2884 {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int H = scanner.nextInt();
		int M = scanner.nextInt();
		
		if (M>=45) M = M -45; // M -= 45
		else {
			if(H == 0) H = 23;
			else H = H-1;
			M = 60-(45-M);
		}
		
		System.out.print(H + " " + M);
	}
}
