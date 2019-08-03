package structure;

import java.util.*;



//190715
//이진트리 생성 후 preorder, inorder, postorder 구현

//node 생성 class

public class BinaryTree<E> {

	static class Node<E>{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		public String toString() {
			return data.toString();
		}
	}
	
	//root node 주소를 보관
	protected Node<E> root;

	public BinaryTree() {
		root = null;
	}

	protected BinaryTree(Node<E> root) {
		this.root = root;
	} 

	
	 public Node makeBT(Object data, Node bt1, Node bt2){
       Node newNode = new Node(data);
       newNode.left = bt1;
       newNode.right =bt2;

       return newNode;
	 }

	 public void preorder(Node root) {
		 if(root !=null){
			System.out.print(root.toString() + " ");
			preorder(root.left);
			preorder(root.right);
		 }
	 }

	 public void inorder(Node root) {
		 if(root !=null){
			inorder(root.left);
			System.out.print(root.toString() + " ");
			inorder(root.right);
		 }
	 }

	 public void postorder(Node root) {
		 if(root !=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.toString() + " ");
		 }
	 }

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node n9 = bt.makeBT("iguana", null ,null);
		Node n8 = bt.makeBT("eagle", null, null);
		Node n7 = bt.makeBT("cat", null, null);
		Node n6 = bt.makeBT("hippo",null, n9);
		Node n5 = bt.makeBT("dog", n7, n8);
		Node n4 = bt.makeBT("ant", null, null);
		Node n3 = bt.makeBT("goose", null, n6);
		Node n2 = bt.makeBT("bear", n4, n5);
		Node n1 = bt.makeBT("fox", n2, n3);

	   System.out.print("preorder : ");
       bt.preorder(n1);
       System.out.println();

       System.out.print("inorder : ");
       bt.inorder(n1);
       System.out.println();

       System.out.print("postorder : ");
       bt.postorder(n1);
       System.out.println();

	}
		
}