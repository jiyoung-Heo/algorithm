package 실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {
	static int[][] land;
	static boolean[][] visit;
	static int w;
	static int h;
	static int count;
	static int dirX[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int dirY[] = { -1, 1, 0, 0, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;

			if (w == 0 && h == 0) {
				break;
			}

			land = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visit[i][j] == false && land[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nowX = dirX[i] + x;
			int nowY = dirY[i] + y;
			
			if (nowX >= h || nowY >= w || nowX < 0 || nowY < 0) {
				continue;
			}
			if(!visit[nowX][nowY] && land[nowX][nowY] == 1) {
				dfs(nowX, nowY);
			}
		}
	}
}