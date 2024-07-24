import jdk.nashorn.internal.objects.annotations.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[n];
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
            arr[i].add(Integer.parseInt(st.nextToken()));
            array[i] = arr[i].get(0);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
                Arrays.sort(dp);

        System.out.println(dp[n-1]);

    }
}
