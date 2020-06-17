package SWEA;
import java.util.*;


/*
 * [활주로 건설]
 * - 성공
 * 
 * 
 */
public class p4014_2 {

	static int N, X, result;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = 0;
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//가로
			int p = 0;
			while(p<2) {
				for(int i=0; i<N; i++) {
					boolean check = true;
					Stack<Integer> stack = new Stack<>();
					stack.push(map[i][0]);
					for(int j=1; j<N; j++) {
						if(map[i][j]-stack.peek()>=2 || map[i][j]-stack.peek()<=-2) { //높이 차가 2 이상이면 무조건 false
							check = false;
							break;
						}
						
						//현재가 이전보다 클 때 -> 그동안의 스택사이즈를 비교한다.
						if(stack.peek() < map[i][j]) {
							if(stack.size()>=X) {
								stack.clear();  // 스택초기화!
								stack.push(map[i][j]);
								continue;
							}
							else {
								check = false;
								break;
							}
						}
						
						// 현재가 이전보다 작을 때 
						else if(stack.peek() > map[i][j]) {
							int cnt = 0;
							int jj = 0;
							for(jj=j; jj<N; jj++) {
								if(map[i][j] == map[i][jj])
									cnt++;
								else break;
								if(cnt==X)
									break;
							}
							if(cnt==X) {
								if(jj+1>=N) break;
								else { 
									if(map[i][jj]-map[i][jj+1] == 1) { // ㄱㄴ
										stack.clear(); // 스택초기화!
										stack.push(map[i][jj]);
										j = jj;
									}
									else if(map[i][jj] == map[i][jj+1]) { //--
										stack.clear(); // 스택초기화!
										stack.push(map[i][jj+1]);
										j = jj+1;
									}
									else { // _|- or 차이가 2이상 날 때
										check = false;
										break;
									}
								}
							}
							else { //cnt가 X보다 작은 경우 -> 경사로를 지을 수 없음.
								check = false;
								break;
							}
						}
						
						// 현재와 이전이 같을 때 -> 스택에 넣는다.
						else {
							stack.push(map[i][j]);
						}
					}
					if(check== true)
						result++;
				}
				p++;
				map = turnleft(map); //세로로 바꾸지 않고 배열을 반시계방향으로 90도 회전함.
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	//반시계 방향 90도 회전
	static int[][] turnleft(int[][] map){
		int[][] tmp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmp[i][j] = map[j][N-i-1];
 			}
		}
		return tmp;
	}
}
