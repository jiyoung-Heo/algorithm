import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int y, x, n;
	static int[][] visited;
	static StringBuilder sb = new StringBuilder();

	// bfs
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;

		visited = new int[n][n];
		bfs(x, y);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int enX = Integer.parseInt(st.nextToken()) - 1;
			int enY = Integer.parseInt(st.nextToken()) - 1;
			sb.append(visited[enX][enY]).append(" ");
		}

		System.out.println(sb);
	}

	static int[] dirX = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dirY = { -1, 1, -2, 2, -2, 2, -1, 1 };

	private static void bfs(int enX, int enY) {
		Queue<Point> que = new ArrayDeque<Point>();
		que.add(new Point(enX, enY));

		while (!que.isEmpty()) {
			Point point = que.poll();

			int currX = point.x;
			int currY = point.y;

			for (int i = 0; i < dirX.length; i++) {
				int nextX = currX + dirX[i];
				int nextY = currY + dirY[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
					continue;
				}
				if (visited[nextX][nextY] == 0) {
					visited[nextX][nextY] = visited[currX][currY] + 1;
					que.add(new Point(nextX, nextY));
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
