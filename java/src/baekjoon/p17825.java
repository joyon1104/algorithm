package baekjoon;
import java.util.*;

/*
 * [�ֻ��� ������]
 */

public class p17825 {

	// ������ ��
	static int[] A = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,-1, // 0~21
					10,13,16,19,25,30,35,40,-1,	// 22~30
					20,22,24,25,30,35,40,-1,	// 31~38
					30,28,27,26,25,30,35,40,-1	// 39~47
	};
	
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dice = new int[10];  //�ֻ��� 10ȸ ���� ���
		for(int i=0; i<10; i++)
			dice[i] = sc.nextInt();
		max = 0;
		int[] turn = new int[10];  // dfs�� 10ȸ turn���� � ���� ������ �� �����ϴ� �迭
		for(int i=0; i<4; i++) {
			turn[0] = i;
			dfs(dice,turn,0,1);
		}
		System.out.println(max);
	}
	
	static void dfs(int[] dice, int[] turn, int idx, int cnt) {
		if(cnt==10) {
			play(dice, turn); 	// ������ ����
		}
		else {
			for(int i=0; i<4; i++) {
				turn[idx+1] = i;
				dfs(dice,turn,idx+1,cnt+1);
			}
		}
	}
	
	static void play(int[] dice, int[] turn) {
		int[] check = new int[4]; //���� ��ġ(index)�� ��� �迭, -1�̸� ������ �� ����.
		int result = 0;
		for(int i=0; i<10; i++) {
			int horse = turn[i];  // ������ ��
			int now = check[horse];  // ���� ���� �ε��� ����
			if(now==-1)  // ������ �� ���� ���� ��� -> return
				return;
			int next = move(now,dice[i]);  // move�Լ��� ���� �̵��� �ε����� ����
			if(next == -1) {	// ���� ���� ������ ���
				check[horse] = next;  // result�� ������ ������ �ʰ�, ���� �� �ε����� next �ε����� �ʱ�ȭ
				continue;
			}
			
			for(int j=0; j<4; j++) {  // �����̷��� �ε����� �̹� ���� �ִ��� Ȯ��
				if(check[j] != -1 && isSame(check[j], next))
					return;
			}
			check[horse] = next;  // ���� �� �ε����� next�� �ʱ�ȭ
			result += A[next];   // result ���� ���ϱ�
		}
		
		//�ִ밪 ����
		if(max < result) {
			max = result;
		}
	}
	
	// �ε����� �ٸ����� ������ ���� ��ġ�ΰ�츦 �Ǻ��ϱ� ���� �Լ� -> true(����) / false(�ٸ�)
	static boolean isSame(int idx1, int idx2) {
		boolean result = false;
		
		if(A[idx1] == A[idx2] && (A[idx1]==25 || A[idx1]==35 || A[idx1]==40))
			result = true;
		else if(A[idx1] == A[idx2] && A[idx1]==30) {
			if(idx1 != 39 && idx2 !=39)
				result = true;
			else if(idx1 == 39 && idx1==idx2)
				result = true;
		}
		else if(idx1 == idx2)
			result = true;
		
		return result;
	}
	
	// �� �ε��� �����̱� ���� �Լ�
	static int move(int now, int d) {
		int next = now+d;
		if(now>=0 && now<=20) {
			if(next>=21)
				return -1;
			else {
				if(A[next] == 10)
					return 22;
				else if(A[next]==20)
					return 31;
				else if(A[next]==30)
					return 39;
				else return next;
			}
		}
		else if(now>=22 && now<=29 && next>=30)
			return -1;
		else if(now>=31 && now<=37 && next>=38)
			return -1;
		else if(now>=39 && now<=46 && next>=47)
			return -1;
		else return next;
	}
}
