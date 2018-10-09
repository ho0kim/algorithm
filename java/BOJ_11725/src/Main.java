import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
input
7
1 6
6 3
3 5
4 1
2 4
4 7
output
4 6 1 3 1 4 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeCnt = sc.nextInt();
		sc.nextLine();
		Graph graph = new Graph(nodeCnt + 1);
		int[] parentNodes ;
		
		for(int i = 0;i < nodeCnt - 1; i++) {
			String input = sc.nextLine();
			int n = Integer.parseInt(input.split(" ")[0]);
			int m = Integer.parseInt(input.split(" ")[1]);
			
			graph.addEdge(n, m);
		}
		
		sc.close();
		
		parentNodes = graph.searchParent_dfs(1);
		
		for(int i = 2; i<=nodeCnt; i++){
			System.out.print(parentNodes[i] + " ");
		}
	}

}

class Graph{
	//node 인접한노드들 linkedlist에 저장
	//방문확인을 위한 mark
	class Node{
		int data;
		LinkedList<Node> adjacentNodes;
		Boolean marked;
		
		public Node(int data) {
			this.data = data;
			this.marked = false;
			adjacentNodes = new LinkedList<Node>();
		}
	}
	static Node[] nodes;
	
	public Graph(int size) {
		nodes = new Node[size+1];
		for(int i = 0; i<size ; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int a, int b) {
		Node n = nodes[a];
		Node m = nodes[b];
		
		if(!n.adjacentNodes.contains(m))
			n.adjacentNodes.add(m);
		if(!m.adjacentNodes.contains(n))
			m.adjacentNodes.add(n);
	}
	
	static int[] searchParent_bfs(int start) {
		Queue<Node> q = new LinkedList<>();
		int[] parents = new int[nodes.length + 1];
		
		Node startNode = nodes[start];
		q.offer(startNode);
		startNode.marked = true;
		
		while(!q.isEmpty()) {
			Node dequeueNode = q.poll();
			for(Node n: dequeueNode.adjacentNodes) {
				if(!n.marked) {
					q.offer(n);
					n.marked = true;
					parents[n.data] = dequeueNode.data; 
				}
			}
		}
		return parents;
	}
	
	static int[] searchParent_dfs(int start) {
		Stack<Node> stack = new Stack<>();
		int[] parents = new int[nodes.length + 1];
		Node startNode = nodes[start];
		stack.push(startNode);
		startNode.marked = true;
		
		while(!stack.isEmpty()) {
			Node popNode = stack.pop();
			for(Node n : popNode.adjacentNodes) {
				if(!n.marked) {
					stack.push(n);
					n.marked = true;
					parents[n.data] = popNode.data;
				}
			}
		}
		
		return parents;
	}
}