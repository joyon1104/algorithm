package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 190820
 * 
 * 백준 13904번
 * -> 분류 : 탐욕법
 * 
 * [ 과제 ]
 * 
 * => 실패
 *	 답 참고 : https://yangorithm.tistory.com/64
 * 
 * < 구현 방법 >
 * 1. 우선 입력받은 과제들을 점수가 많은 순부터 정렬한다. (점수가 동일하면 마감일이 작은 것 부터 정렬한다.)
 * 2. 점수가 많은 과제부터 N개까지의 과제를 due 배열에 넣으려 시도한다.
 * 3. 넣으려는 과제(d,w)의 마감일 d에 맞게 due[d]에 넣는다.
 * 		1) due[d] == 0이면, 해당 인덱스에 값을 넣는다. (값은 0을 제외한 아무거나 상관없음)
 * 		2) due[d] != 0이면(비어있지 않으면), --d를 해가면서 이전 인덱스 중 비어있는 곳에 값을 넣는다.
 * 		3) 비어있는 곳을 찾지 못하면 해당 과제는 할 수 없음.
 * 			** due배열에 값을 넣었으면, 해당 과제는 할 수 있다는 의미이므로 result값에 해당 과제의 w(점수)를 더해준다.
 * 4. result를 출력한다.
 * 		
 */

public class p13904 {

	static Scanner sc = new Scanner(System.in);
	static int[] due = new int[10001];
		
	public static void main(String[] args) {
		int N = sc.nextInt();
		int[][] dw = new int[N][2];
		
		for(int i=0; i<N; i++) {
			dw[i][0] = sc.nextInt();
			dw[i][1] = sc.nextInt();
		}
		
		//1. 점수가 많은 순으로, 점수가 동일하면 마감일이 작은 순으로 sort
		Arrays.sort(dw, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				if(o2[1]==o1[1]) {
					return o1[0]-o2[0];
				}
				else return o2[1]-o1[1];
			}
		});
		
		// 결과값
		int result = 0;
		
		//2. due배열 삽입 시도
		for(int i=0; i<N; i++) {
			if(due[dw[i][0]] == 0) {	//3-1. 해당 인덱스가 비어있으면 값을 넣는다.
				due[dw[i][0]] = dw[i][0];
				result += dw[i][1];
			}
			else {
				for(int j=dw[i][0]-1; j>=1; j--) {	//3-2. 비어있는 배열에 값을 넣었으면 꼭 break!!!
					if(due[j] == 0) {
						due[j] = dw[i][0];
						result+= dw[i][1];
						break;
					}
				}
			}
		}
		
		//4. 결과값 출력 
		System.out.println(result);
		
	}
	
	

}
