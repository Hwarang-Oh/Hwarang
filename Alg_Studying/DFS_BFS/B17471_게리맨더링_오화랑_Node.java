import java.io.*;
import java.util.*;

public class B17471_게리맨더링_오화랑_Node {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int vertexNum = Integer.parseInt(input.readLine());
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		ArrayList<Node> adjList = new ArrayList<Node>(vertexNum + 1);
		int[] vertexValue = new int[vertexNum + 1];
		for (int i = 0 ; i <= vertexNum ; i++) adjList.add(null);
		for (int i = 1 ; i <= vertexNum ; i++) vertexValue[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1 ; i <= vertexNum ; i++) {
			st = new StringTokenizer(input.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				addEdge(adjList, i, Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 1 ; i <= vertexNum ; i++)
			System.out.println(adjList.get(i));
	}
	
	public static void addEdge(ArrayList<Node> adjList, int from, int to) {
		Node adjNode = new Node(to);
		adjNode.next = adjList.get(from);
		adjList.set(from, adjNode);
	}
	
	public static void gatherBFS() {
		
	}
	
	
	
	
	
	
	
}