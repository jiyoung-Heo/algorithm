import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
            if(i+t[i] <= n){
                dp[i] = p[i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
//                if (j + t[j] > n) {
//                    dp[i] = 0;
//                }

                if (j + t[j] <= i) {
                    if(i+t[i] > n){
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + p[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

}