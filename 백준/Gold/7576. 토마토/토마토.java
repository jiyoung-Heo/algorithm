
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int count;
    static Queue<Point> que = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    que.add(new Point(i, j, 0));
                }
            }
        }
        bfs();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    static void bfs() {
        while (!que.isEmpty()) {
            Point p = que.poll();
            count = Math.max(count, p.count);

            for (int i = 0; i < dirX.length; i++) {
                int nextX = dirX[i] + p.x;
                int nextY = dirY[i] + p.y;
                if (nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr[0].length || arr[nextX][nextY] != 0)
                    continue;
                arr[nextX][nextY] = 1;
                que.add(new Point(nextX, nextY, p.count + 1));
            }
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}
