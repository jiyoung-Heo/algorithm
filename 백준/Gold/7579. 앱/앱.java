import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mArr = new int[n];
        int[] cArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];

        for (int i = 0; i < n; i++) {
            for (int j = 10000; j >= cArr[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-cArr[i]] + mArr[i]);
            }
        }

        for (int i = 0; i < 10001; i++) {
            if(dp[i] >= m){
                System.out.println(i);
                return;
            }
        }
    }

}