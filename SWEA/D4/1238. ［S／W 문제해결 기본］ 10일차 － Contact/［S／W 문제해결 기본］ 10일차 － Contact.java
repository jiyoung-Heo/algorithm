import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int len, start;
	static List<Integer>[] listArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());

			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			listArr = new ArrayList[101];
			for (int j = 0; j < listArr.length; j++) {
				listArr[j] = new ArrayList<>();
			}
			for (int j = 0; j < len / 2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				listArr[from].add(to);
			}
			visited = new boolean[101];
			System.out.println("#" + i + " " + bfs());
		}

	}

	static int bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(start, 0));

		int maxDepth = 0;
		int maxNumber = 0;
		while (!que.isEmpty()) {
			Node node = que.poll();
			if (visited[node.number])
				continue;
			visited[node.number] = true;
			int number = node.number;
			int depth = node.depth;
			for (int i = 0; i < listArr[number].size(); i++) {
				que.add(new Node(listArr[number].get(i), depth + 1));
			}
			if (maxDepth < depth) {
				maxDepth = depth;
				maxNumber = number;
			}
			if (maxDepth == depth) {
				maxNumber = Math.max(maxNumber, number);
			}
		}
		return maxNumber;
	}

	static class Node {
		int number;
		int depth;

		public Node(int number, int depth) {
			super();
			this.number = number;
			this.depth = depth;
		}
	}
}