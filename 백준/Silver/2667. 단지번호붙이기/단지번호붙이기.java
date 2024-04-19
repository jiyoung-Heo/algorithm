import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static boolean[][] visited;
	static char[][] arr;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!visited[i][j] && arr[i][j] == '1') {
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int a : list) {
			System.out.println(a);
		}
	}

	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };

	static int bfs(int i, int j) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(i, j));
		visited[i][j] = true;
		int count = 0;
		while (!que.isEmpty()) {
			Point p = que.poll();
			count++;
			for (int k = 0; k < dirX.length; k++) {
				int nextX = p.x + dirX[k];
				int nextY = p.y + dirY[k];
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
					continue;
				if (!visited[nextX][nextY] && arr[nextX][nextY] == '1') {
					que.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
		return count;
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
