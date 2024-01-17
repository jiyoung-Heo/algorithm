package 실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양치기꿍 {
	static boolean[][] visit;
	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };
	static char[][] ground;
	static int r;
	static int c;
	static int sheep = 0;
	static int wolf = 0;
	static int sumSheep = 0;
	static int sumWolf = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		ground = new char[r][c];
		visit = new boolean[r][c];

		for (int j = 0; j < r; j++) {
			char[] str = br.readLine().toCharArray();
			for (int j2 = 0; j2 < c; j2++) {
				if (str[j2] == 'v') sumWolf++;
				if (str[j2] == 'k')	sumSheep++;

				ground[j][j2] = str[j2];
			}
		}
		for (int j = 0; j < r; j++) {
			for (int j2 = 0; j2 < c; j2++) {
				if (ground[j][j2] != '#' && !visit[j][j2]) {
					//초기화
					sheep = 0;
					wolf = 0;

					dfs(j, j2);

					if (sheep <= wolf) {
						sumSheep -= sheep;
					} else if (sheep > wolf) {
						sumWolf -= wolf;
					}
				}
			}
		}

		System.out.println(sb.append(sumSheep).append(" ").append(sumWolf));
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		// 늑대
		if (ground[x][y] == 'v')
			wolf++;
		// 양
		if (ground[x][y] == 'k')
			sheep++;

		for (int i = 0; i < dirX.length; i++) {
			int nowX = x + dirX[i];
			int nowY = y + dirY[i];
			
			if (nowX >= r || nowY >= c || nowX < 0 || nowY < 0) {
				continue;
			}
			
			if (ground[nowX][nowY] != '#' && !visit[nowX][nowY]) {
				dfs(nowX, nowY);
			}
		}
	}
}
