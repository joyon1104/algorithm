package baekjoon;
import java.util.*;

public class p5373_1 {

	static void printmap(char[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	
	static char[][] copy(char[][] map) {
		char[][] tmp = new char[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				tmp[i][j] = map[i][j];
		}
		return tmp;
	}
	
	static char[][] UP = {{'w','w','w'},{'w','w','w'},{'w','w','w'}};
	static char[][] DOWN = {{'y','y','y'},{'y','y','y'},{'y','y','y'}};
	static char[][] LEFT = {{'g','g','g'},{'g','g','g'},{'g','g','g'}};
	static char[][] RIGHT = {{'b','b','b'},{'b','b','b'},{'b','b','b'}};
	static char[][] FRONT = {{'r','r','r'},{'r','r','r'},{'r','r','r'}};
	static char[][] BACK = {{'o','o','o'},{'o','o','o'},{'o','o','o'}};
	static char[][] U,D,L,R,F,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			U = copy(UP); D = copy(DOWN); L = copy(LEFT);
			R = copy(RIGHT); F = copy(FRONT); B = copy(BACK);
			
			int n = sc.nextInt();
			for(int nn=0; nn<n; nn++) {
				String s = sc.next();
				char side = s.charAt(0);
				char turn = s.charAt(1);
				if(side=='U') {
					U = turnside(turn,U);
				}
				else if(side=='D') {
					D = turnside(turn,D);
				}
				else if(side=='L') {
					L = turnside(turn,L);
				}
				else if(side=='R') {
					R = turnside(turn,R);
				}
				else if(side=='F') {
					F = turnside(turn,F);
				}
				else if(side=='B') {
					B = turnside(turn,B);
				}
				
				solve(side,turn);
			}
			printmap(U);
		}
	}
	
	static char[][] turnside( char turn, char[][] map) {
		char[][] tmp = copy(map);
		if(turn=='+') {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					tmp[i][j] = map[3-j-1][i];
				}
			}
		}
		else {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					tmp[i][j] = map[j][3-i-1];
				}
			}
		}
		return tmp;
	}
	
	static void solve(char side, char turn) {
		char[][]  tmp1, tmp2, tmp3, tmp4;
		if(side == 'U') {
			tmp1 = copy(B); tmp2 = copy(R); tmp3 = copy(F); tmp4 = copy(L);
			if(turn=='+') {
				tmp1[0][0] = L[0][0]; tmp1[0][1] = L[0][1]; tmp1[0][2] = L[0][2];
				tmp2[0][0] = B[0][0]; tmp2[0][1] = B[0][1]; tmp2[0][2] = B[0][2];
				tmp3[0][0] = R[0][0]; tmp3[0][1] = R[0][1]; tmp3[0][2] = R[0][2];
				tmp4[0][0] = F[0][0]; tmp4[0][1] = F[0][1]; tmp4[0][2] = F[0][2];
			}
			else {
				tmp1[0][0] = R[0][0]; tmp1[0][1] = R[0][1]; tmp1[0][2] = R[0][2];
				tmp2[0][0] = F[0][0]; tmp2[0][1] = F[0][1]; tmp2[0][2] = F[0][2];
				tmp3[0][0] = L[0][0]; tmp3[0][1] = L[0][1]; tmp3[0][2] = L[0][2];
				tmp4[0][0] = B[0][0]; tmp4[0][1] = B[0][1]; tmp4[0][2] = B[0][2];
			}
			B = tmp1; R = tmp2; F = tmp3; L = tmp4;
		}
		else if(side == 'D') {
			tmp1 = copy(F); tmp2 = copy(R); tmp3 = copy(B); tmp4 = copy(L);
			if(turn=='+') {
				tmp1[2][0] = L[2][0]; tmp1[2][1] = L[2][1]; tmp1[2][2] = L[2][2];
				tmp2[2][0] = F[2][0]; tmp2[2][1] = F[2][1]; tmp2[2][2] = F[2][2];
				tmp3[2][0] = R[2][0]; tmp3[2][1] = R[2][1]; tmp3[2][2] = R[2][2];
				tmp4[2][0] = B[2][0]; tmp4[2][1] = B[2][1]; tmp4[2][2] = B[2][2];
			}
			else {
				tmp1[2][0] = R[2][0]; tmp1[2][1] = R[2][1]; tmp1[2][2] = R[2][2];
				tmp2[2][0] = B[2][0]; tmp2[2][1] = B[2][1]; tmp2[2][2] = B[2][2];
				tmp3[2][0] = L[2][0]; tmp3[2][1] = L[2][1]; tmp3[2][2] = L[2][2];
				tmp4[2][0] = F[2][0]; tmp4[2][1] = F[2][1]; tmp4[2][2] = F[2][2];
			}
			F = tmp1; R = tmp2; B = tmp3; L = tmp4;
		}
		else if(side == 'L') {
			tmp1 = copy(U); tmp2 = copy(F); tmp3 = copy(D); tmp4 = copy(B);
			if(turn=='+') {
				tmp1[0][0] = B[2][2]; tmp1[1][0] = B[1][2]; tmp1[2][0] = B[0][2];
				tmp2[0][0] = U[0][0]; tmp2[1][0] = U[1][0]; tmp2[2][0] = U[2][0];
				tmp3[0][0] = F[0][0]; tmp3[1][0] = F[1][0]; tmp3[2][0] = F[2][0];
				tmp4[0][2] = D[2][0]; tmp4[1][2] = D[1][0]; tmp4[2][2] = D[0][0];
			}
			else {
				tmp1[0][0] = F[0][0]; tmp1[1][0] = F[1][0]; tmp1[2][0] = F[2][0];
				tmp2[0][0] = D[0][0]; tmp2[1][0] = D[1][0]; tmp2[2][0] = D[2][0];
				tmp3[0][0] = B[2][2]; tmp3[1][0] = B[1][2]; tmp3[2][0] = B[0][2];
				tmp4[0][2] = U[2][0]; tmp4[1][2] = U[1][0]; tmp4[2][2] = U[0][0];
			}
			U = tmp1; F = tmp2; D = tmp3; B = tmp4;
		}
		else if(side == 'R') {
			tmp1 = copy(U); tmp2 = copy(B); tmp3 = copy(D); tmp4 = copy(F);
			if(turn=='+') {
				tmp1[0][2] = F[0][2]; tmp1[1][2] = F[1][2]; tmp1[2][2] = F[2][2];
				tmp2[0][0] = U[2][2]; tmp2[1][0] = U[1][2]; tmp2[2][0] = U[0][2];
				tmp3[2][2] = B[0][0]; tmp3[1][2] = B[1][0]; tmp3[0][2] = B[2][0];
				tmp4[0][2] = D[0][2]; tmp4[1][2] = D[1][2]; tmp4[2][2] = D[2][2];
			}
			else {
				tmp1[2][2] = B[0][0]; tmp1[1][2] = B[1][0]; tmp1[0][2] = B[2][0];
				tmp2[0][0] = D[2][2]; tmp2[1][0] = D[1][2]; tmp2[2][0] = D[0][2];
				tmp3[0][2] = F[0][2]; tmp3[1][2] = F[1][2]; tmp3[2][2] = F[2][2];
				tmp4[0][2] = U[0][2]; tmp4[1][2] = U[1][2]; tmp4[2][2] = U[2][2];
			}
			U = tmp1; B = tmp2; D = tmp3; F = tmp4;
		}
		else if(side == 'F') {
			tmp1 = copy(U); tmp2 = copy(R); tmp3 = copy(D); tmp4 = copy(L);
			if(turn=='+') {
				tmp1[2][0] = L[2][2]; tmp1[2][1] = L[1][2]; tmp1[2][2] = L[0][2];
				tmp2[0][0] = U[2][0]; tmp2[1][0] = U[2][1]; tmp2[2][0] = U[2][2];
				tmp3[0][2] = R[0][0]; tmp3[0][1] = R[1][0]; tmp3[0][0] = R[2][0];
				tmp4[0][2] = D[0][0]; tmp4[1][2] = D[0][1]; tmp4[2][2] = D[0][2];
			}
			else {
				tmp1[2][0] = R[0][0]; tmp1[2][1] = R[1][0]; tmp1[2][2] = R[2][0];
				tmp2[0][0] = D[0][2]; tmp2[1][0] = D[0][1]; tmp2[2][0] = D[0][0];
				tmp3[0][0] = L[2][0]; tmp3[0][1] = L[2][1]; tmp3[0][2] = L[2][2];
				tmp4[2][0] = U[2][2]; tmp4[2][1] = U[2][1]; tmp4[2][2] = U[2][0];
			}
			U = tmp1; R = tmp2; D = tmp3; L = tmp4;
		}
		else if(side == 'B') {
			tmp1 = copy(U); tmp2 = copy(L); tmp3 = copy(D); tmp4 = copy(R);
			if(turn=='+') {
				tmp1[0][0] = R[0][2]; tmp1[0][1] = R[1][2]; tmp1[0][2] = R[2][2];
				tmp2[0][0] = U[0][2]; tmp2[1][0] = U[0][1]; tmp2[2][0] = U[0][0];
				tmp3[2][0] = L[0][0]; tmp3[2][1] = L[1][0]; tmp3[2][2] = L[2][0];
				tmp4[0][2] = D[2][2]; tmp4[1][2] = D[2][1]; tmp4[2][2] = D[2][0];
			}
			else {
				tmp1[0][0] = L[2][0]; tmp1[0][1] = L[1][0]; tmp1[0][2] = L[0][0];
				tmp2[0][0] = D[2][0]; tmp2[1][0] = D[2][1]; tmp2[2][0] = D[2][2];
				tmp3[2][0] = R[2][2]; tmp3[2][1] = R[1][2]; tmp3[2][2] = R[0][2];
				tmp4[0][2] = U[0][0]; tmp4[1][2] = U[0][1]; tmp4[2][2] = U[0][2];
			}
			U = tmp1; L = tmp2; D = tmp3; R = tmp4;
		}
	}
}
