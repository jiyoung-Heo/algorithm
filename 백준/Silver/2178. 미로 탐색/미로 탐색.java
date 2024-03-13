import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] countArr;
	static char[][] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 0,0에서 출발하여 n-1, m-1까지 이동할 때 지나야 하는 최소의 칸 수
		countArr = new int[n][m];
		countArr[0][0]++;
		bfs(0, 0);
		System.out.println(countArr[n - 1][m - 1]);
	}

	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int nowX = xy[0];
			int nowY = xy[1];
			for (int i = 0; i < dirX.length; i++) {
				int nextX = nowX + dirX[i];
				int nextY = nowY + dirY[i];
				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}
				if (countArr[nextX][nextY] != 0 && countArr[nowX][nowY] > countArr[nextX][nextY])
					continue;
				if (arr[nextX][nextY] == '1' && visited[nextX][nextY] == false) {
					countArr[nextX][nextY] = countArr[nowX][nowY] + 1;
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY});
				}
			}
		}
	}
}
