import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int m, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[m][n];
			visited = new boolean[m][n];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int result = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr[j].length; j2++) {
					if (arr[j][j2] == 1 && !visited[j][j2]) {
						bfs(j, j2);
						result++;
					}
				}
			}
			System.out.println(result);
		}

	}

	static int[] dirX = new int[] { 1, -1, 0, 0 };
	static int[] dirY = new int[] { 0, 0, 1, -1 };

	static void bfs(int j, int j2) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(j, j2));
		visited[j][j2] = true;

		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int i = 0; i < dirX.length; i++) {
				int nextX = point.x + dirX[i];
				int nextY = point.y + dirY[i];
				if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]
						|| arr[nextX][nextY] == 0)
					continue;
				que.add(new Point(nextX, nextY));
				visited[nextX][nextY] = true;
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
