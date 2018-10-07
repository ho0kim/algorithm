import java.util.Arrays;
import java.util.Scanner;

//BOJ_1991
/*
INPUT
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */
/*
PREORDER
INORDER
POSTORDER

ABDCEFG
DBAECFG
DBEGFCA
 */
public class Main {

	public static void main(String[] args) {
		sol_using_node();
	}
	
	static int Aascii = 'A';
	
	public static void sol_using_arr() {
		Scanner sc = new Scanner(System.in);
		//node 갯수받
		int nodeCnt = sc.nextInt();
		sc.nextLine();
		int[][] tree = new int[nodeCnt][2];
		
		for(int i =0 ; i<nodeCnt;i++) {
			String input = sc.nextLine();
			
			int data = (int)input.charAt(0) - Aascii;
			int left = (int)input.charAt(2) - Aascii;
			int right = (int)input.charAt(4) - Aascii;
			
			tree[data][0] = left;
			tree[data][1] = right;
		}
		sc.close();
		
		arr_preorder(0, tree);
		System.out.println();
		arr_inorder(0, tree);
		System.out.println();
		arr_postorder(0, tree);
	}
	
	public static void arr_preorder(int data, int[][] tree) {
		if(data == '.' - Aascii)
			return;
		System.out.print((char)(data+Aascii));
		arr_preorder(tree[data][0], tree);
		arr_preorder(tree[data][1], tree);
	}
	public static void arr_inorder(int data, int[][] tree) {
		if(data == '.' - Aascii)
			return;
		arr_inorder(tree[data][0], tree);
		System.out.print((char)(data+Aascii));
		arr_inorder(tree[data][1], tree);
	}
	public static void arr_postorder(int data,int[][] tree) {
		if(data == '.' - Aascii)
			return;
		arr_postorder(tree[data][0], tree);
		arr_postorder(tree[data][1], tree);
		System.out.print((char)(data+Aascii));
	}
	
////////////////////////////////////////////////////////////////////
// Use tree node
	public static void sol_using_node() {
		Scanner sc = new Scanner(System.in);
		int nodeCnt = sc.nextInt();
		sc.nextLine();
		
		Tree tree = new Tree();
		
		for(int i = 0; i< nodeCnt; i++) {
			String input = sc.nextLine();
			
			char nodeData  = input.charAt(0);
			char leftData = input.charAt(2);
			char rightData = input.charAt(4);
			
			tree.add(nodeData, leftData, rightData);
		}
		
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
	}

}

class Tree{
	Node root;
	
	public void add(char data, char left, char right) {
		if(root == null && data != '.') {
			root = new Node(data);
			root.left = new Node(left);
			root.right = new Node(right);
		}else {
			searchAndAdd(root, data, left, right);
		}
	}
	
	public void searchAndAdd(Node searchNode, char data,char left,char right) {
		if(searchNode == null) {
			return;
		}else if(searchNode.data == data) {
			if(data != '.') {
				searchNode.left = new Node(left);
				searchNode.right = new Node(right);
			}
		}else {
			searchAndAdd(searchNode.left, data, left, right);
			searchAndAdd(searchNode.right, data, left, right);
		}
	}
	//left - root - right
	public void inorder(Node node) {
		if(node.left != null)
			inorder(node.left);
		if(node.data != '.')
			System.out.print(node.data);
		if(node.right != null)
			inorder(node.right);
	}
	//root - left - right
	public void preorder(Node node) {
		if(node.data != '.')
			System.out.print(node.data);
		if(node.left != null)
			preorder(node.left);
		if(node.right != null)
			preorder(node.right);
	}
	//left - right - root
	public void postorder(Node node) {
		if(node.left != null)
			postorder(node.left);
		if(node.right != null)
			postorder(node.right);
		if(node.data != '.')
			System.out.print(node.data);
	}
}

class Node{
	char data;
	Node left, right;
	
	public Node(char data) {
		this.data = data;
	}
}