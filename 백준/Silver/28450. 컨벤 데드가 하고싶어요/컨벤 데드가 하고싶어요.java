import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[n + 1][m + 1];
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int h = Integer.parseInt(br.readLine());

		dp[1][1] = arr[1][1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i + 1 <= n) {
					if (dp[i + 1][j] != -1) {
						dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + arr[i + 1][j]);
					} else {
						dp[i + 1][j] = dp[i][j] + arr[i + 1][j];
					}
				}
				if (j + 1 <= m) {
					if (dp[i][j + 1] != -1) {
						dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + arr[i][j + 1]);
					} else {
						dp[i][j + 1] = dp[i][j] + arr[i][j + 1];
					}
				}
			}
		}
		if (dp[n][m] > h) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(dp[n][m]);
		}
	}
}
