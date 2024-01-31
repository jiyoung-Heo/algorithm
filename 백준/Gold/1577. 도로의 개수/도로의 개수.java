import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		int[][] width = new int[n + 1][m + 1];
		int[][] height = new int[n + 1][m + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (b == d) {
				height[Math.min(a, c)][b] = 1;
			} else {
				width[a][Math.min(b, d)] = 1;
			}
		}

		long[][] dp = new long[n + 1][m + 1];

		dp[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			if (height[i - 1][0] == 1)
				break;

			dp[i][0] = 1;
		}
		for (int i = 1; i <= m; i++) {
			if (width[0][i - 1] == 1)
				break;

			dp[0][i] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if(height[i-1][j] == 1) {
					dp[i][j] -= dp[i-1][j];
				}
				if(width[i][j-1] == 1) {
					dp[i][j] -= dp[i][j-1];
				}
			}
		}
		System.out.println(dp[n][m]);

	}
}
