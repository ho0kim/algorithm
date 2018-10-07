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
		sol_using_arr();
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
		arr_preorder(tree[data][0], tree);
		System.out.print((char)(data+Aascii));
		arr_preorder(tree[data][1], tree);
	}
	public static void arr_postorder(int data,int[][] tree) {
		if(data == '.' - Aascii)
			return;
		arr_postorder(tree[data][0], tree);
		arr_postorder(tree[data][1], tree);
		System.out.print((char)(data+Aascii));
	}
	
	
	public static void sol_using_node() {
		
	}

}
