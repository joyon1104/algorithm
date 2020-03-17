package structure;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS_comb {
	static boolean [] visit = new boolean[3];
	static int [] result = new int [3];
	static int [] arr = {1,2,3};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		//조합
		System.out.println("****조  합****");
		combination(list, n, r, 0);
		list.clear();
		
		//중복조합
		System.out.println("****중복조합****");
		reCombination(list, n, r, 0);

	}
	
    //중복조합
	private static void reCombination(LinkedList<Integer> list, int n, int r, int index) {
		if(r == 0){
			for(int i : list){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		if(index == n) return;
		
		list.add(index);
		reCombination(list, n, r-1, index);
		list.removeLast();
		reCombination(list, n, r, index+1);
	}

	//조합
	private static void combination(LinkedList<Integer> list, int n, int r, int index) {
		if(r == 0){//r이 0이면 다 뽑았다는 뜻
			for(int i : list){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		if(index == n) return; //다 탐색했으면 종료..
		
		list.add(index);
		combination(list, n, r-1, index+1);//뽑았으니 ,r-1
		list.removeLast();
		combination(list, n, r, index+1);//안뽑았으니, r
	}
}