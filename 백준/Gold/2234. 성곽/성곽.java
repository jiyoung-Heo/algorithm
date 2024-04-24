import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] who;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		arr = new int[m * 2 + 1][n * 2 + 1];
		who = new int[m * 2 + 1][n * 2 + 1];
		arr = new int[m * 2 + 1][n * 2 + 1];
		visited = new boolean[m * 2 + 1][n * 2 + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int number = Integer.parseInt(st.nextToken());
				if (number - 8 >= 0) {
					// 남쪽
					arr[i * 2 + 1 + 1][j * 2 + 1 - 1] = -1;
					arr[i * 2 + 1 + 1][j * 2 + 1] = -1;
					arr[i * 2 + 1 + 1][j * 2 + 1 + 1] = -1;
					number -= 8;
				}
				if (number - 4 >= 0) {
					// 동쪽
					arr[i * 2 + 1 - 1][j * 2 + 1 + 1] = -1;
					arr[i * 2 + 1][j * 2 + 1 + 1] = -1;
					arr[i * 2 + 1 + 1][j * 2 + 1 + 1] = -1;
					number -= 4;
				}
				if (number - 2 >= 0) {
					// 북쪽
					arr[i * 2 + 1 - 1][j * 2 + 1 - 1] = -1;
					arr[i * 2 + 1 - 1][j * 2 + 1] = -1;
					arr[i * 2 + 1 - 1][j * 2 + 1 + 1] = -1;
					number -= 2;
				}
				if (number - 1 >= 0) {
					// 서쪽
					arr[i * 2 + 1 - 1][j * 2 + 1 - 1] = -1;
					arr[i * 2 + 1][j * 2 + 1 - 1] = -1;
					arr[i * 2 + 1 + 1][j * 2 + 1 - 1] = -1;
					number -= 1;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m * 2 + 1; i++) {
			for (int j = 0; j < n * 2 + 1; j++) {
				if (arr[i][j] != -1 && visited[i][j] == false) {
					cnt++;
					int count = bfs(i, j);
					list.add(count);
					changeNumber(i, j, count);
				}
			}
		}
		
		int maxNumber = 0;
		for (int i = 0; i < m * 2 + 1; i++) {
			for (int j = 0; j < n * 2 + 1; j++) {
				for (int j2 = 0; j2 < dirX.length; j2++) {
					int nextX = i + dirX[j2];
					int nextY = j + dirY[j2];
					int nextXX = nextX + dirX[j2];
					int nextYY = nextY + dirY[j2];
					if (nextXX < 0 || nextYY < 0 || nextXX >= m * 2 + 1 || nextYY >= n * 2 + 1)
						continue;
					if (arr[i][j] == -1 || arr[nextXX][nextYY] == -1)
						continue;
					// 사이에 -1이 껴있으면 계산해야한다.
					if (who[i][j] != who[nextXX][nextYY]) {
						// 두 값이 다르면 더해서 max
						maxNumber = Math.max(arr[i][j] + arr[nextXX][nextYY], maxNumber);
					}
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(list.get(0));

		
		System.out.println(maxNumber);
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };

	static void changeNumber(int x, int y, int count) {
		for (int i = 0; i < m * 2 + 1; i++) {
			for (int j = 0; j < n * 2 + 1; j++) {
				if (arr[i][j] == -2) {
					arr[i][j] = count;
				}
			}
		}
	}
	static int cnt = 0;
	static int bfs(int x, int y) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(x, y));
		who[x][y] = cnt;
		int count = 1;

		while (!que.isEmpty()) {
			Point p = que.poll();
			visited[p.x][p.y] = true;
			arr[p.x][p.y] = -2;
			for (int i = 0; i < dirX.length; i++) {
				int nextX = p.x + dirX[i];
				int nextY = p.y + dirY[i];
				if (nextX < 0 || nextY < 0 || nextX >= m * 2 + 1 || nextY >= n * 2 + 1)
					continue;
				if (!visited[nextX][nextY] && arr[nextX][nextY] != -1 && arr[nextX][nextY] != -2) {
					que.add(new Point(nextX, nextY));
					// 임시
					arr[nextX][nextY] = -2;
//					System.out.println("-----------------");
//					System.out.println(nextX+" "+nextY);
					if (nextX % 2 == 1 && nextY % 2 == 1) {
//						System.out.println(nextX+" "+nextY);
						who[nextX][nextY] = cnt;
						count++;
					}
				}
			}
		}
		return count;
	}

	static class Point {

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
