import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dx = { 0, 1, 1, 1 };
		int[] dy = { 1, 1, 0, -1 };

		char[][] map = new char[N][];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		String ans = "ongoing";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char tmp = map[i][j];
				if (tmp != '.') {
					for (int k = 0; k < dx.length; k++) {
						int cnt = 0;
						for (int l = 1; l < 3; l++) {
							int nx = i + (dx[k] * l);
							int ny = j + (dy[k] * l);
							if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
								break;
							}
							if (tmp == map[nx][ny]) {
								cnt++;
							} else {
								break;
							}
						}
						if (cnt == 2) {
							ans = String.valueOf(tmp);
							break;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}