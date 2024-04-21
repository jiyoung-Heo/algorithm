import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Point>[][] listArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];

		listArr = new ArrayList[n][n];
		ArrayList<Point> cowList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				listArr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < r; i++) {
			// 인접한 길 xy, xy
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int xx = Integer.parseInt(st.nextToken()) - 1;
			int yy = Integer.parseInt(st.nextToken()) - 1;
			listArr[x][y].add(new Point(xx, yy));
			listArr[xx][yy].add(new Point(x, y));
		}
		for (int i = 0; i < k; i++) {
			// 소의 위치
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 1;
			cowList.add(new Point(x, y));
		}
		cowList.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
//		System.out.println(cowList);
		// 소 위치 탐색
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					for (int j2 = 0; j2 < cowList.size(); j2++) {
						// 다음 소 위치
						Point p = cowList.get(j2);
						if (i == p.x && j == p.y)
							continue;
						// 연결성 체크 ( 길 없는곳으로 갈 수 있는지 체크하기)
						boolean check = bfs(i, j, p.x, p.y);
						// true 이면 다리 없이 갈 수 이씀
						if (!check) {
							count++;
//							System.out.println(i + " " + j + " " + p.x + " " + p.y);
						}
					}
				}
			}
		}
//		System.out.println(count);
		System.out.println(count/2);
	}

	static boolean bfs(int startX, int startY, int endX, int endY) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(startX, startY));
		boolean[][] visited = new boolean[n][n];
		visited[startX][startY] = true;
		boolean flag = false;
		while (!que.isEmpty() && !flag) {
			Point p = que.poll();
			for (int i = 0; i < dirX.length; i++) {
				if (flag)
					break;
				int nextX = p.x + dirX[i];
				int nextY = p.y + dirY[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || visited[nextX][nextY]) {
					continue;
				}
				int tempCount = 0;
				for (int j = 0; j < listArr[p.x][p.y].size(); j++) {
					if (listArr[p.x][p.y].get(j).x == nextX && listArr[p.x][p.y].get(j).y == nextY) {
						tempCount++;
					}
				}
				if (tempCount == 0) {
					if (nextX == endX && nextY == endY) {
						flag = true;
						break;
					}
					// 다리가 아닌경우임
					que.add(new Point(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}

		return flag;
	}

	static int[] dirX = new int[] { 1, -1, 0, 0 };
	static int[] dirY = new int[] { 0, 0, 1, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
