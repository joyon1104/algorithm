package SWEA;
import java.util.*;


/*
 * [Ȱ�ַ� �Ǽ�]
 * - ����
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
			
			//����
			int p = 0;
			while(p<2) {
				for(int i=0; i<N; i++) {
					boolean check = true;
					Stack<Integer> stack = new Stack<>();
					stack.push(map[i][0]);
					for(int j=1; j<N; j++) {
						if(map[i][j]-stack.peek()>=2 || map[i][j]-stack.peek()<=-2) { //���� ���� 2 �̻��̸� ������ false
							check = false;
							break;
						}
						
						//���簡 �������� Ŭ �� -> �׵����� ���û���� ���Ѵ�.
						if(stack.peek() < map[i][j]) {
							if(stack.size()>=X) {
								stack.clear();  // �����ʱ�ȭ!
								stack.push(map[i][j]);
								continue;
							}
							else {
								check = false;
								break;
							}
						}
						
						// ���簡 �������� ���� �� 
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
									if(map[i][jj]-map[i][jj+1] == 1) { // ����
										stack.clear(); // �����ʱ�ȭ!
										stack.push(map[i][jj]);
										j = jj;
									}
									else if(map[i][jj] == map[i][jj+1]) { //--
										stack.clear(); // �����ʱ�ȭ!
										stack.push(map[i][jj+1]);
										j = jj+1;
									}
									else { // _|- or ���̰� 2�̻� �� ��
										check = false;
										break;
									}
								}
							}
							else { //cnt�� X���� ���� ��� -> ���θ� ���� �� ����.
								check = false;
								break;
							}
						}
						
						// ����� ������ ���� �� -> ���ÿ� �ִ´�.
						else {
							stack.push(map[i][j]);
						}
					}
					if(check== true)
						result++;
				}
				p++;
				map = turnleft(map); //���η� �ٲ��� �ʰ� �迭�� �ݽð�������� 90�� ȸ����.
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	//�ݽð� ���� 90�� ȸ��
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
