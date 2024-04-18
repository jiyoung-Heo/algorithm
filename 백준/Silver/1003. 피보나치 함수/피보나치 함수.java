import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int sumA;
	static int sumB;
	static int dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			sumA = 0;
			sumB = 0;
			int number = Integer.parseInt(br.readLine());
			dp = new int[number+1][2];
			if (number == 0) {
				dp[0][0]++;
			} else if (number == 1) {
				dp[1][1]++;
			} else {
				dp[0][0]++;
				dp[1][1]++;
				for (int j = 0; j < dp.length - 2; j++) {
					dp[j + 2][0] = dp[j][0] + dp[j + 1][0];
					dp[j + 2][1] = dp[j][1] + dp[j + 1][1];
				}
			}
			System.out.println(dp[number][0] + " " + dp[number][1]);
		}
	}
}
