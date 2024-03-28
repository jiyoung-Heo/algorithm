import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static char[][] arr;
	static int[][] time;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new char[n][n];
			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine().toCharArray();
			}

			time = new int[n][n];
			for (int j = 0; j < n; j++) {
				Arrays.fill(time[j], Integer.MAX_VALUE);
			}

			// 0,0부터 출발하여 n,n까지 가장 작은 경로의 복구시간 출력
			bfs();
			System.out.println("#" + i + " " + time[n - 1][n - 1]);
		}
	}

	static int[] dirX = new int[] { 1, -1, 0, 0 };
	static int[] dirY = new int[] { 0, 0, 1, -1 };

	static void bfs() {
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(0, 0));
		time[0][0] =Character.getNumericValue(arr[0][0]);
		while (!que.isEmpty()) {
			Point point = que.poll();
			int x = point.x;
			int y = point.y;
			for (int i = 0; i < dirX.length; i++) {
				int nextX = x + dirX[i];
				int nextY = y + dirY[i];
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
					continue;
				if (time[nextX][nextY] == Integer.MAX_VALUE ||time[nextX][nextY] > Character.getNumericValue(arr[nextX][nextY]) + time[x][y]) {
					time[nextX][nextY] = Character.getNumericValue(arr[nextX][nextY]) + time[x][y];
					que.add(new Point(nextX, nextY));
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