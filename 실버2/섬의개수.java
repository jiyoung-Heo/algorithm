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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while (flag) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			
			if(w == 0 && h == 0) {
				flag = false;
				break;
			}
			
			land = new int[h][w];
			visit = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					int num = Integer.parseInt(st1.nextToken());
					land[i][j] = num;
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (land[i][j] == 1 && visit[i][j] == false) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
			
		}
	}

	public static void dfs(int i, int j) {
		if (i >= h || j >= w || i < 0 || j < 0) {
			return;
		}
		if (visit[i][j] == false) {
			if (land[i][j] == 1) {
				visit[i][j] = true;
			}else {
				return;
			}
		}else {
			return;
		}
		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j + 1);
		dfs(i, j - 1);
		dfs(i + 1, j + 1);
		dfs(i - 1, j - 1);
		dfs(i + 1, j - 1);
		dfs(i - 1, j + 1);
	}
}
