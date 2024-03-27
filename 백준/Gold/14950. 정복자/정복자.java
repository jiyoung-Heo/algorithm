import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.pay - o2.pay;
			}
		});
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			Node node = new Node(a, b, c);
			que.add(node);
		}

		int cost = 0;
		int count = 0;
		while (!que.isEmpty()) {
			if (count == n - 1)
				break;
			Node node = que.poll();
			if (findParent(node.b) == findParent(node.a))
				continue;
			// a는 부모가 따로 있는것. b를 a의 자식으로 넣기
			cost += node.pay;
			count++;
			parent[findParent(node.a)] = findParent(node.b);
		}
		
		int tCount = 0;
		for (int i = 0; i < n-1; i++) {
			tCount += i * t;
		}
		System.out.println(cost + tCount);

	}

	static int findParent(int x) {
		if (parent[x] != x) {
			return parent[x] = findParent(parent[x]);
		}
		return parent[x];
	}

	static class Node {
		int a;
		int b;
		int pay;

		public Node(int a, int b, int pay) {
			super();
			this.a = a;
			this.b = b;
			this.pay = pay;
		}
	}
}
