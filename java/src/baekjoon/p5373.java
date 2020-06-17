//package baekjoon;
//import java.util.*;
//
//public class p5373 {
//	
//	public static void printcube(char[][] cube) {
//		for(int i=0; i<cube.length; i++) {
//			for(int j=0; j<cube[0].length; j++)
//				System.out.print(cube[i][j]);
//			System.out.println();
//		}
//	}
//	
//	public static char[] getArr(char[][] cube,int j) {
//		char[] carr = new char[cube.length];
//		for(int i=0; i<cube.length; i++) {
//			carr[i] = cube[i][j];
//		}
//		return carr;
//	}
//	
//	public static ArrayList<char[][]> copy(ArrayList<char[][]> cube){
//		ArrayList<char[][]> tmp = new ArrayList<>();
//		for(int i=0; i<cube.size(); i++) {
//			char[][] arr = cube.get(i);
//			char[][] tmparr = new char[arr.length][arr[0].length];
//			for(int p=0; p<3; p++) {
//				for(int q=0; q<3; q++)
//					tmparr[p][q] = arr[p][q];
//			}
//			tmp.add(tmparr);
//		}
//		return tmp;
//	}
//
//	public static void solve(ArrayList<char[][]> cube, char d, char turn) {
//		ArrayList<char[][]> tmp = copy(cube);
//		int idx = 0;
//		if(d=='U' || d=='D') {
//			if(d=='U') idx = 0; else idx = 2;
//			if((d=='U' && turn=='+') || (d=='D' && turn=='-')) {
//				for(int j=0; j<3; j++) {
//					tmp.get(4)[idx][j] = cube.get(2)[idx][j];
//					tmp.get(2)[idx][j] = cube.get(5)[idx][j];
//					tmp.get(5)[idx][j] = cube.get(3)[idx][j];
//					tmp.get(3)[idx][j] = cube.get(4)[idx][j];
//				}
//			}
//			else {
//				for(int j=0; j<3; j++) {
//					tmp.get(2)[idx][j] = cube.get(4)[idx][j];
//					tmp.get(5)[idx][j] = cube.get(2)[idx][j];
//					tmp.get(3)[idx][j] = cube.get(5)[idx][j];
//					tmp.get(4)[idx][j] = cube.get(3)[idx][j];
//				}
//			}
//			
//		}
//		else if(d=='F' || d=='B') {
//			if((d=='F' && turn=='+')||(d=='B' && turn=='-')) {
//				if(turn=='+') change(cube.get(0)[2],tmp.get(5),'j',0); else change(cube.get(0)[0],tmp.get(5),'j',2);
//				if(turn=='+') change(getArr(cube.get(5),0),tmp.get(1),'i',0); else change(getArr(cube.get(5),2),tmp.get(1),'i',2);
//				if(turn=='+') change(cube.get(1)[0],tmp.get(4),'j',2); else change(cube.get(1)[2],tmp.get(4),'j',0);
//				if(turn=='+') change(getArr(cube.get(4),2),tmp.get(0),'i',2); else change(getArr(cube.get(4),0),tmp.get(0),'i',0);
//				
//			}
//			else {
//				if(turn=='+') change(cube.get(0)[2],tmp.get(4),'j',2); else change(cube.get(0)[0],tmp.get(4),'j',0);
//				if(turn=='+') change(getArr(cube.get(4),2),tmp.get(1),'i',0); else change(getArr(cube.get(4),0),tmp.get(1),'i',2);
//				if(turn=='+') change(cube.get(1)[0],tmp.get(5),'j',0); else change(cube.get(1)[2],tmp.get(4),'j',0);
//				if(turn=='+') change(getArr(cube.get(5),0),tmp.get(0),'i',2); else change(getArr(cube.get(4),0),tmp.get(0),'i',0);
//				
//			}
//		}
//		else if(d=='L' || d=='R') {
//			if(d=='U') idx = 0; else idx = 2;
//			if((d=='U' && turn=='+') || (d=='D' && turn=='-')) {
//				for(int j=0; j<3; j++) {
//					tmp.get(4)[idx][j] = cube.get(2)[idx][j];
//					tmp.get(2)[idx][j] = cube.get(5)[idx][j];
//					tmp.get(5)[idx][j] = cube.get(3)[idx][j];
//					tmp.get(3)[idx][j] = cube.get(4)[idx][j];
//				}
//			}
//			else {
//				for(int j=0; j<3; j++) {
//					tmp.get(2)[idx][j] = cube.get(4)[idx][j];
//					tmp.get(5)[idx][j] = cube.get(2)[idx][j];
//					tmp.get(3)[idx][j] = cube.get(5)[idx][j];
//					tmp.get(4)[idx][j] = cube.get(3)[idx][j];
//				}
//			}
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = Integer.parseInt(sc.nextLine());
//		ArrayList<char[][]> cube = new ArrayList<>();
//		for(int i=0; i<6; i++) {
//			char[][] tmp = new char[3][3];
//			char c = 'a';
//			if(i==0) c = 'w';
//			else if(i==1) c ='y';
//			else if(i==2) c = 'r';
//			else if(i==3) c = 'o';
//			else if(i==4) c = 'g';
//			else if(i==5) c = 'b';
//			for(int p=0; p<3; p++) {
//				for(int q=0; q<3; q++)
//					tmp[p][q] = c;
//			}
//			cube.add(tmp);
//		}
//		
//		for(int t=0; t<T; t++) {
//			int N = Integer.parseInt(sc.nextLine());
//			String[] sarr = sc.nextLine().split(" ");
//			for(String s : sarr) {
//				solve(cube, s.charAt(0), s.charAt(1));
//			}
//		}
//		
//		printcube(cube.get(0));
//		
//		
//	}
//}
