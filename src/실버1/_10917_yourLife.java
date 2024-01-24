package 실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10917_yourLife {
	static ArrayList<Integer>[] list;
	static int n, min;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		visited = new boolean[n + 1];

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
		}

		bfs(1);

	}

	public static void bfs(int node) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(node, 0));
		visited[node] = true;

		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int nextNode : list[point.node]) {
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					if (nextNode == n) {
						System.out.println(point.depth + 1);
						return;
					}
					que.add(new Point(nextNode, point.depth + 1));
				}
			}
		}
	}

	static class Point {
		int node;
		int depth;

		public Point(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
