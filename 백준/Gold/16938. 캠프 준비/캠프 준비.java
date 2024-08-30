import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        //조건: 문제는 2문제 이상일 것
        for (int i = 2; i < (1<<n); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            // 00011 일때 0번째, 1번째 체킹해야함.
            for (int j = 0; j < n; j++) {
                if(((1<<j) & i) != 0){
                    //해당원소선택된거임
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                    sum += arr[j];
                }
            }
            if(sum >= l && sum <= r && max-min>=x){
                result++;
            }
        }
        System.out.println(result);
    }
}