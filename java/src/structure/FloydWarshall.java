package structure;

public class FloydWarshall {	// -> p11404
	static int INF = 999999;
	public static void main(String[] args) {
		
		int arr[][] = {{0,   1,   INF, 4, 5},
                       {INF, 0,   3,   2, 1},
                       {1,   INF, 0,   5, 3},
                       {INF, INF, 4, 0, 2},
                       {4, INF, 1, 7, 0}};
		
		for(int k=0; k<arr.length; k++) {	// k = 거쳐가는 노드
			for(int i=0; i<arr.length; i++) {	// i = 출발노드
				for(int j=0; j<arr.length; j++) {	// j = 도착노드
					if(arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
		
	}
}
