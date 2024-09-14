import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine()) - 1;
            System.out.println(dp[target]);
        }
    }
}