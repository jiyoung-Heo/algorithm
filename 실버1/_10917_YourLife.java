package 실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10917_YourLife {
	static ArrayList<Integer>[] list;
	static int n, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
		}

		bfs(1);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void bfs(int node) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(node, 1));

		while (!que.isEmpty()) {
			Point point = que.poll();
			ArrayList<Integer> nodeArr = list[point.node];
			for (int i = 0; i < nodeArr.size(); i++) {
				int a = nodeArr.get(i);
				if (a == n) {
					if (min > point.depth) {
						min = point.depth;
					}
				}
				que.add(new Point(a, point.depth + 1));
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
