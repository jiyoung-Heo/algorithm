import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        long gCount = 0;
        for (int i = 1; i <= n; i++) {
            long count = arr[i].size();
            if (count >= 3) {
                gCount += (count * (count - 1) * (count - 2)) / 6;
            }
        }
        boolean[] visited = new boolean[n + 1];

        long dCount = 0;
        for (int i = 1; i <= n; i++) {

            visited[i] = true;

            for (Integer j : arr[i]) {

                if (visited[j]) continue;
                if (arr[i].size() < 2 || arr[j].size() < 2) continue;

                int count = arr[i].size();
                int nextCount = arr[j].size();
                dCount += ((long) (count - 1) * (nextCount - 1));

            }
        }

        if (dCount > gCount * 3) {
            System.out.println("D");
        } else if (dCount < gCount * 3) {
            System.out.println("G");
        } else if (dCount == gCount * 3) {
            System.out.println("DUDUDUNGA");
        }


    }
}