package programmers;

/*
 * [단속카메라]
 * 1. 차량이 고속도로에서 나간 지점을 기준으로 오름차순 정렬을 한다.
 * 2. 차량이 들어온 지점이 이전 카메라 위치보다 오른쪽에 있으면 차량이 나간 지점에 카메라를 설치한다.
 */
import java.util.Arrays;

class p200322_1 {
    public int solution(int[][] routes) {
        int answer = 0; // 카메라의 갯수
        int camera = -30001; // 카메라의 위치

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}