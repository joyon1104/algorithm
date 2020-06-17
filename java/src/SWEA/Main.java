package SWEA;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int[] check = new int[6];
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			int cc = (int)c;
			if(cc >= 97 && cc <=122) {
				check[1] = 1;
			}
			else if(cc >=65 && cc <=90) {
				check[2] = 1;
			}
			else if(cc >= 48 && cc <=57)
				check[3] = 1;
			else
				check[4] = 1;
		}
		if(s.length()>=10)
			check[5] = 1;
		
		int level = 0;
		for(int i=1; i<=5; i++) {
			level += check[i];
		}
		
		String result = "LEVEL"+level;
		System.out.println(result);
	}

}
