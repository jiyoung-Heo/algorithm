import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Point>[] arr = new ArrayList[10001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (start > d || last > d) continue;
            arr[start].add(new Point(start, last, length));
        }

        int[] cost = new int[10001];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = i;
        }

        for (int i = 0; i < d; i++) {
            if (!arr[i].isEmpty()) {
                for (Point p : arr[i]) {
                    if(cost[p.l] > cost[i] + p.cost){
                        cost[p.l] = cost[i] + p.cost;
                    }
                }
            }
            cost[i + 1] = Math.min(cost[i + 1], cost[i] + 1);
        }

        System.out.println(cost[d]);
    }

    static class Point {
        int s, l, cost;

        public Point(int s, int l, int cost) {
            this.s = s;
            this.l = l;
            this.cost = cost;
        }
    }
}





