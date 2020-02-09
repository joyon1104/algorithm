package baekjoon;
import java.util.*;

public class p10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			int[] bag = new int[4];
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				
				//대문자
				if((int)c >=65 && (int)c <= 90) 
					bag[1] += 1;
				//소문자
				else if((int)c >= 97 && (int)c <= 122)
					bag[0] += 1;
				//숫자
				else if((int)c >= 48 && (int)c <= 57)
					bag[2] += 1;
				//공백
				else if((int)c == 32)
					bag[3] += 1;
			}
			for(int i=0; i<4; i++) {
				System.out.print(bag[i] + " ");
			}
			System.out.println();
		}
		
	}
}
