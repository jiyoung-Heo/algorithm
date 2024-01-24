package 골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 빠른무작위숫자탐색_25688 {
	static int[][] arr;
	static int number = 1;
	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };
	static int[][] visitCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[5][5];
		visitCount = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		// 현재 X
		int currX = Integer.parseInt(st.nextToken());
		// 현재 Y
		int currY = Integer.parseInt(st.nextToken());

		int result = bfs(currX, currY);

		System.out.println(result);

	}

	public static int bfs(int x, int y) {
		Queue<Point> que = new ArrayDeque<Point>();

		que.add(new Point(x, y, 0, new HashSet<Integer>()));

		while (!que.isEmpty()) {
			Point xyPoint = que.poll();

			int currX = xyPoint.x;
			int currY = xyPoint.y;
			HashSet<Integer> set = xyPoint.visitNumberSet;

			visitCount[currX][currY]++;

			if (arr[currX][currY] >= 1 && arr[currX][currY] <= 6) {
				set.add(arr[currX][currY]);
			}

			if (set.size() == 6)
				return xyPoint.count;

			if (visitCount[currX][currY] < 6) {
				for (int i = 0; i < 4; i++) {

					int nextX = currX + dirX[i];
					int nextY = currY + dirY[i];

					if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length
							|| visitCount[nextX][nextY] > 6)
						continue;

					if (arr[nextX][nextY] != -1) {
						que.add(new Point(nextX, nextY, xyPoint.count + 1, set));
					}
				}
			}
		}
		return -1;
	}

	static class Point {
		int x, y, count;
		HashSet<Integer> visitNumberSet;

		public Point(int x, int y, int count, HashSet<Integer> visitNumberSet) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.visitNumberSet = visitNumberSet;
		}
	}
}
