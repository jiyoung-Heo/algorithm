import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 치즈
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		while (true) {
			count++;
			visited = new boolean[n][m];

			// 공기찾기
			bfs(0, 0);

			int allcheeze = 0;
			int cheeze = 0;
			// 전체 치즈 크기 체크하면서 녹일 치즈 2로 update
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 || !visited[i][j]) {
						if (isMelting(i, j)) {
							cheeze++;
						}
						;
						allcheeze++;
					}
				}
			}
			// 2인것 0으로 바꾸기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 2) {
						map[i][j] = 0;
					}
				}
			}
			if (allcheeze - cheeze == 0) {
				System.out.println(count);
				return;
			}
		}

	}

	static int[] dirX = new int[] { 1, -1, 0, 0 };
	static int[] dirY = new int[] { 0, 0, 1, -1 };

	static boolean isMelting(int x, int y) {
		int count = 0;
		for (int i = 0; i < dirX.length; i++) {
			int nextX = x + dirX[i];
			int nextY = y + dirY[i];
			if (map[nextX][nextY] == 0 && visited[nextX][nextY]) {
				count++;
			}
		}
		if (count >= 2) {
			map[x][y] = 2;
			return true;
		}
		return false;
	}

	// 공기를 찾는 bfs
	static void bfs(int x, int y) {

		Queue<Point> queue = new ArrayDeque();
		queue.add(new Point(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < dirX.length; i++) {
				int nextX = p.x + dirX[i];
				int nextY = p.y + dirY[i];
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
					visited[nextX][nextY] = true;
					queue.add(new Point(nextX, nextY));
				}
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
