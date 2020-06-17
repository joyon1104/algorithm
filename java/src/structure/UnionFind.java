package structure;

public class UnionFind {
	
	static int n;
	static int[] parents;
	
	public static int getParent(int[] parents, int x) {
		if(parents[x]==x) 
			return x;
		return getParent(parents, parents[x]);
	}
	
	public static void unionParent(int[] parents, int x, int y) {
		x = getParent(parents, x);
		y = getParent(parents, y);
		
		// 더 작은 값으로 부모 노드 설정
		if(x < y)
			parents[y] = x;
		else
			parents[x] = y;
	}
	
	public static boolean isSameParent(int[] parents, int x, int y) {
		boolean result = false;
		if(parents[x] == parents[y])
			result = true;
		return result;
	}
	
	public static void main(String[] args) {
		n = 10;
		parents = new int[n+1];
		
		// 값 초기화 및 노드 연결 전
		System.out.println("<연결 전>");
		for(int i=1; i<=n; i++) {
			parents[i] = i;
			System.out.print(parents[i] + " ");
		}
		System.out.println();
		
		// 노드 연결 
		unionParent(parents, 1, 2); 
		unionParent(parents, 2, 3); 
		unionParent(parents, 3, 4); 
		unionParent(parents, 5, 6); 
		unionParent(parents, 6, 7); 
		unionParent(parents, 7, 8); 
		unionParent(parents, 9, 10); 
		
		// 연결 후
		System.out.println("< 연결 후 >"); 
		for (int i = 1; i <= n; i++) {
			System.out.print(parents[i] + " "); 
		} 
		System.out.println();

		//출처: https://hongku.tistory.com/158 [IT에 취.하.개.]
	}

}
