import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    //    static boolean[][] visited;
    static int result = 0;
    static boolean[][] topVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        topVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfs(i, j);
            }
        }
        System.out.println(result);
    }

    static int[] dirX = {1, 1, -1, -1, 1, -1, 0, 0};
    static int[] dirY = {1, -1, 1, -1, 0, 0, 1, -1};

    static void bfs(int i, int j) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(i, j, arr[i][j]));
        int max = arr[i][j];
        boolean flag = true;
        List<Point> list = new ArrayList<>();

        while (!que.isEmpty() && flag) {
            Point p = que.poll();
            visited[p.x][p.y] = true;
            for (int k = 0; k < dirX.length; k++) {
                if (!flag) {
                    break;
                }
                int nextX = p.x + dirX[k];
                int nextY = p.y + dirY[k];
                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length || visited[nextX][nextY]) {
                    continue;
                }
                if (arr[nextX][nextY] > max || topVisited[nextX][nextY]) {
                    flag = false;
                }
                if (arr[nextX][nextY] == max) {
                    list.add(new Point(nextX, nextY, 0));
                    que.add(new Point(nextX, nextY, arr[nextX][nextY]));
                }
            }
        }
        if (flag) {
            topVisited[i][j] = true;
            result++;

            for (Point p : list) {
                topVisited[p.x][p.y] = true;
            }
        }
    }

    static class Point {
        int x, y, height;

        public Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
