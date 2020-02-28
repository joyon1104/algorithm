package baekjoon;
import java.util.*;

/*
 * [공유기 설치]
 * - 최대 거리를 이분탐색해야함 (최대 거리 범위 : 1~마지막집과 첫번째집 사이 거리)
 * - start =1, end = 첫번째집과 마지막집 거리
 * - 이분탐색을 통해,
 *  mid를 최대거리로 해서 공유기를 설치할 수 있으면 -> ans와 최대값 비교 후 갱신 & start = mid+1
 *  mid를 최대거리로 해서 공유기를 설치할 수 없으면 -> end = mid-1
 * - ans를 출력하면 끝
 * 
 * <check 함수>
 * - 파라미터 dist이상의 거리를 두고 공유기를 설치할 수 있는지 판단하는 함수
 * - cnt : 공유기 설치 수, C : 목표 공유기 설치 수, pos: 최소 공유기 설치 위치(arr[i]+dist)
 * - for문을 돌며 현재 집 위치가 pos보다 크거나 같은지 비교한다.
 *   -> 크거나 같으면, 공유기 설치 수를 증가시키고, pos를 arr[i] + dist로 두고 탐색을 재개한다.
 */

public class p2110 {
	
	static int N;
	static int C;
	static int[] arr;
	static int ans;
	
	static boolean check(int dist) {
		int cnt = 1;
		int pos = arr[0] + dist;
		for(int i=0; i<N; i++) {
			if(arr[i]>=pos) {
				cnt++;
				pos = arr[i]+dist;
			}
		}
		if(cnt<C)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N];
		ans = 0;
		
		for(int i=0; i<N; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[N-1]-arr[0];
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				start = mid+1;
				ans = Math.max(ans, mid);
			}
			else
				end = mid-1;
		}
		System.out.println(ans);
		
	}
}
