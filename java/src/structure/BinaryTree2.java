package structure;

import java.util.*;



//190715
/*
 * 이진검색트리 (BST)
 * - 이진트리이면서
 * - 각 노드에 하나의 키를 저장
 * - 각 노드 v에 대해 v의 왼쪽 subtree에 있는 값들은 v보다 작거나 같고, 오른쪽 subtree 에 있는 값은 v보다 크거나 같다.
 * 
 * 이진검색트리 생성 후 search, insert, delete 구현
 * 최대값, 최소값 추출
 * Successor : 노드 x의 successor란, x보다 크면서 가장 작은 키를 가진 노드 (모든키들이 서로 다르다고 가정)
 * Predecessor : 노드 x의 predecessor란, x보다 작으면서 가장 작은 키를 가진 노드 (모든키들이 서로 다르다고 가정)
 */


class Node{
	int data;
    Node left;
    Node right;

    public Node(int data){
      this.data = data;
      left = null;
      right = null;
  }
}


public class BinaryTree2<E> {
	//root node 주소를 보관
	protected Node root;

	public BinaryTree2() {
		root = null;
	}

	protected BinaryTree2(Node root) {
		this.root = root;
	} 

	 public Node makeBT(int data, Node bt1, Node bt2){
       Node newNode = new Node(data);	//노드 생성 
       newNode.left = bt1;				//생성한 노드의 왼쪽, 오른쪽 자식노드를 지정 
       newNode.right =bt2;

       return newNode;
	 }

	 public void preorder(Node root) {
		 if(root !=null){
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		 }
	 }

	 //search (k : 찾는 데이터)
	 public Node search(Node root, int k) {
		 if(root ==null || k == root.data) {
			 System.out.print(root.data + " ");
			 return root;
		 }
		 if(k < root.data) {
			 System.out.print(root.data + " ");
			 return search(root.left, k);
		 }
		 else {
			 System.out.print(root.data + " ");
			 return search(root.right, k);
		 }
	 }

	 //최소값 추출	-> 가장 왼쪽에 있는 노드의 데이터를 가져오면 됨.
	 public Node minimum(Node root) {
		 if(root.left == null) {
			 System.out.print(root.data);
			 return root;
		 }
		 else {
			 return minimum(root.left);
		 }
	 }

	//최대값 추출 -> 가장 오른쪽에 있는 노드의 데이터를 가져오면 됨.
	 public Node maximum(Node root) {
		 if(root.right == null) {
			 System.out.print(root.data);
			 return root;
		 }
		 else {
			 return maximum(root.right);
		 }
	 }

	 //successor
	 public Node successor(Node root) {
		 //1) 오른쪽 subtree가 있는 경우, 오른쪽 subtree의 최소값이 successor
		 if(root.right != null)
			 return minimum(root.right);
		 
		 //2) 오른쪽 부트리가 없는 경우, root의 왼쪽 subtree의 최대값이 successor 
		 else if(root.right == null && root.left != null)
			 return maximum(root.left);

		 //3) 둘 다 존재하지 안흔ㄴ 경우, successor가 없음.
		 else {
			 System.out.print("successor가 존재하지 않음.");
			 return root;
		 }
	 }


	 public Node successorParent(Node root){
	        Node successor =null;
	        Node successorParent =null;
	        Node successorChild = root.right;

	        while(successorChild!=null){
	            successorParent = successor;
	            successor = successorChild;
	            successorChild = successorChild.left;
	        }
	        
	        if(successor!=root.right){
	            successorParent.left = successor.right;
	            successor.right = root.right;
	        }

	        return successorParent;
	   }

	 //predecessor
	 public Node predecessor(Node root) {
		 //1) 왼쪽 subtree가 있는 경우, 왼쪽 subtree의 최대값이 predecessor
		 if(root.left != null)
			 return maximum(root.left);
		 
		 //2) 왼쪽 subtree가 없는 경우, 오른쪽 subtree의 최소값이 predecessor
		 else if(root.left == null && root.right != null)
			 return minimum(root.right);
		 
		 //3) 둘 다 존재하지 않는 경우, predecessor가 없음.
		 else {
			 System.out.print("predecessor가 존재하지 않음.");
			 return root;
		 }
	 }

	 

	 //insert

	 public void insert(Node root, Node z) {
		 Node y = null;
		 Node x = root;

		 while(x != null){
			y = x;
			if(z.data < x.data)
				x = x.left;
			else
				x = x.right;
		 }

		 if(y == null)
			 root = z;
		 else {
			 if(z.data < y.data)
				 y.left = z;
			 else 
				 y.right = z;
		 }
	 }

	 //delete
	 public void delete(Node root, Node z) {
		 Node parent = root;
		 Node current = root;

		 while(current.data != z.data) {
			 parent = current;
		
			 if(z.data < current.data)
				 current = current.left;
			 else
				 current = current.right;
			 
			 if (current == null)
				 System.out.println("삭제하려는 노드를 찾을 수 없습니다.");
		 }

		//Case 1: 자식노드가 없는 경우
	      if(current.left==null && current.right==null){
	          if(current==root){
	              root = null;
	          }
	
	          if(parent.data < current.data){
	              parent.right = null;
	          }else{
	              parent.left = null;
	          }
	      }

	    //Case 2 : 1개의 자식노드를 가지는 경우
	      else if(current.left != null && current.right == null){		//삭제할 노드가 왼쪽 자식 노드만 가지는 경우
	          if(current==root){
	              root = current.left;
	          }
	          else{
	              if(parent.data > current.left.data)
	              	parent.left = current.left;
	              else
	              	parent.right = current.left;
	          }
	      }

	      else if(current.right != null && current.left == null){		//삭제할 노드가 오른쪽 자식 노드만 가지는 경우
	          if(current==root){
	              root = current.right;
	          }
	          else{
	              if(parent.data > current.right.data)
	              	parent.left = current.right;
	              else
	              	parent.right = current.right;
	          }
	      }

	    //Case 3 : 두개의 자식을 갖는 경우
	      else{
	          // 오른쪽 서브트리의 최소값을 찾음
	          Node successor = successor(current);
	          Node successorParent = successorParent(current);
	
	          if(current==root){	// 삭제할 노드가 root인 경우
	              root = successor;
	          }
	          else{	
	              if(successor.right == null) //교체할 successor의 자식노드가 없을 경우 (successor는 right child밖에 가질 수 밖에 없음)
	              	successorParent.left = null;
	              else						//교체할 successor의 자식노드가 하나 있을 경우 (자식노드가 두개 일 수는 없음)
	              	successorParent.left = successor.right;    
	          }
	          current.data = successor.data;
	      }
	}


	public static void main(String[] args) {
		BinaryTree2 bt = new BinaryTree2();

		Node n11 = bt.makeBT(9, null ,null);
		Node n10 = bt.makeBT(13, n11 ,null);
		Node n9 = bt.makeBT(4, null ,null);
		Node n8 = bt.makeBT(2, null, null);
		Node n7 = bt.makeBT(20, null, null);
		Node n6 = bt.makeBT(17, null, n9);
		Node n5 = bt.makeBT(7, null, n10);
		Node n4 = bt.makeBT(3, n8, n9);
		Node n3 = bt.makeBT(18, n6, n7);
		Node n2 = bt.makeBT(6, n4, n5);
		Node n1 = bt.makeBT(15, n2, n3);

		System.out.print("preorder : ");
		bt.preorder(n1);

		System.out.println();
		
		System.out.print("Search : ");
		bt.search(n1, 13);
		
		System.out.println();


		System.out.print("Minimum : ");
		bt.minimum(n1);

		System.out.println();

		System.out.print("Maximum : ");
       	bt.maximum(n1);
       
       	System.out.println();

       	System.out.print("Successor : ");
       	bt.successor(n1);
       	System.out.println();

       	System.out.print("predecessor : ");
       	bt.predecessor(n1);

       	System.out.println();

       	/*
       	System.out.println("insert 14");
       	Node newNode = new Node(14);
       	bt.insert(n1, newNode);

       	System.out.print("Search : ");
       	bt.search(n1, 14);
       	System.out.println();
       	 */

       	System.out.print("delete : ");
       	bt.delete(n1, n1);

       	System.out.println();

       	System.out.print("preorder : ");
       	bt.preorder(n1);

       	System.out.println();

	}
}

	