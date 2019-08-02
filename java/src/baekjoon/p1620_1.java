package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//190721 스터디
//시간초과  -> arraylist 대신 hashmap으로 재코

public class p1620_1 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = sc.nextInt();	// 포켓몬 개수 
		int M = sc.nextInt();	// 문제 개수
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i=0; i<=N; i++) {
			String str = sc.nextLine();
			list.add(str);
		}
		
		for(int j =0; j<M; j++) {
			String problem = sc.nextLine();
			try {
				int index = Integer.parseInt(problem);
				System.out.println(list.get(index));
			} catch(Exception e) {
				System.out.println(list.indexOf(problem));
			}
		}
	}
}
