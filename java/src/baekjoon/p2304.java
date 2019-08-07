package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 190807
 * 
 * 백준 2304번 
 * 
 * [ 창고 다각형 ]
 * 
 * => 성공
 * 
 * < 구현방법 >
 *  1. map에 좌표값을 저장한다.
 *  2. arr배열에 X값만 따로 저장한다 -> sort하여 X가 작은 것부터 배열시킨다.
 *  3. map의 value(Y)값 중 최대값을 찾는다. (max)
 *  4. 탐색
 *  	1) 왼쪽 -> 오른쪽
 *  		- 왼쪽 X의 인덱스 값인 p, q는 p+1 부터 시작하여 map.get(arr[q])가 map.get(arr[p])보다 클 때 까지 계속 증가시킨다.
 *  		- map.get(arr[q])가 map.get(arr[p])보다 크면 p와 q사이의 직사각형 넓이를 계산해 결과값에 더해준다.
 *  		- map.get(arr[p])가 max 전까지 계속 반복하고, max값에 도달하면 반복문이 멈추고, p값이 저장된다.
 *  	2) 오른쪽 -> 왼쪽
 *  		- 1)의 방향과 반대로 하면 됨.
 *  		- 이 때 r값이 저장된다.
 *  5. 높이가 최대값인 직사각형 넓이를 구해 result해 더해준다.
 *  	- result += (arr[r]-arr[p]+1) * max => 1을 더해줘야 함!
 */

public class p2304 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		// 1. HashMap 저장
		for(int i=0; i<N; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			arr[i] = X;		// 2. arr배열에 X 따로 저장
			map.put(X,Y);
		}
		Arrays.sort(arr);	// sort
		
		// 3. 높이 최대값을 찾음.
		int max = Collections.max(map.values());	
		int result = 0;
		
		int p = 0;
		int q = 0;
		
		// 4-1. 왼쪽 -> 오른쪽 탐색 
		while(map.get(arr[p]) < max) {		
			q++;
			if(map.get(arr[p]) < map.get(arr[q])) {
				result += map.get(arr[p]) * (arr[q]-arr[p]);
				p = q;
			}
		}
		
		int r = N-1;
		q = N-1;
		
		// 4-2. 오른쪽 -> 왼쪽 탐색 
		while(map.get(arr[r]) < max) {		
			q--;
			if(map.get(arr[r]) < map.get(arr[q])) {
				result += map.get(arr[r]) * (arr[r]-arr[q]);
				r=q;
			}
		}
		
		// 5. 높이가 최대값인 직사각형 넓이를 더해 result 계산완료 
		result += (arr[r]-arr[p]+1) * max;	//(r-p+1)이라고 해서 틀림
		
		System.out.print(result);
	}
}
