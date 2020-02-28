package baekjoon;
import java.util.*;

public class p1991 {
	
	static class Node{
		char data;
		Node left, right;
		public Node(char data) {
			this.data = data;
		}
	}
	
	static class Tree{
		Node root;	// 루트노드. 초기값 null
		
		public void add(char data, char leftData, char rightData) {
			if(root==null) {
				if(data!='.')
					root = new Node(data);
				if(leftData!='.')
					root.left = new Node(leftData);
				if(rightData!='.')
					root.right = new Node(rightData);
			}
			else
				search(root, data, leftData, rightData);
		}
		
		public void search(Node root, char data, char leftData, char rightData) {
			// 도착한 노드가 null이면 종료
			if(root== null)
				return;
			// 해당 위치를 찾은 경우
			else if(root.data == data) {
				if(leftData != '.')
					root.left = new Node(leftData);
				if(rightData != '.')
					root.right = new Node(rightData);
			}
			// 해당 위치를 못찾은 경우.
			else {
				search(root.left, data, leftData, rightData); //왼쪽 재귀탐색
				search(root.right, data, leftData, rightData); //오른쪽 재귀탐색
			}
		}
		
		public void preorder(Node root) {
			System.out.print(root.data);
			if(root.left != null) preorder(root.left);
			if(root.right != null) preorder(root.right);
		}
		
		
		public void inorder(Node root) {
			if(root.left!=null) inorder(root.left);
			System.out.print(root.data);
			if(root.right!=null) inorder(root.right);

		}
		
		public void postorder(Node root) {
			if(root.left!=null) postorder(root.left);
			if(root.right!=null) postorder(root.right);
			System.out.print(root.data);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Tree t = new Tree();
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			char[] sarr = s.replaceAll(" ","").toCharArray();
			t.add(sarr[0], sarr[1], sarr[2]);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
	}

}
