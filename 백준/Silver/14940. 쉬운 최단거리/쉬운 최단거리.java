import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] result;
    static int x, y, n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[n][m];
        x = 0;
        y = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    //시작점
                    x = i;
                    y = j;
                }
                if (arr[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }
        result[x][y] = 0;
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs() {
        ArrayDeque<Point> que = new ArrayDeque<>();
        que.add(new Point(x, y));

        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nextX = p.x + dirX[i];
                int nextY = p.y + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (arr[nextX][nextY] == 0) {
                    result[nextX][nextY] = 0;
                    continue;
                }
                if (result[nextX][nextY] == -1) {
                    result[nextX][nextY] = result[p.x][p.y] + 1;
                    que.add(new Point(nextX, nextY));
                    continue;
                }
                if (result[nextX][nextY] > result[p.x][p.y] + 1) {
                    result[nextX][nextY] = result[p.x][p.y] + 1;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
}
