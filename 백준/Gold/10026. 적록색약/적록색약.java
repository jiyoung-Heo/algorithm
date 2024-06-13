
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static boolean[][] yesVisit;
    static boolean[][] noVisit;
    static int yesCount;
    static int noCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        yesVisit = new boolean[n][n];
        noVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                Point p = new Point(i, j);
                if (!noVisit[i][j]) {
                    noCount++;
                    nobfs(p);
                }
                if (!yesVisit[i][j]) {
                    yesCount++;
                    yesBfs(p);
                }
            }
        }

        System.out.println(noCount + " " + yesCount);
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    static void yesBfs(Point point) {
        //빨강+초록
        Queue<Point> que = new ArrayDeque<>();

        que.add(point);
        yesVisit[point.x][point.y] = true;


        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nextX = p.x + dirX[i];
                int nextY = p.y + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length || yesVisit[nextX][nextY]) {
                    continue;
                }

                if (arr[nextX][nextY] == arr[p.x][p.y] || (arr[p.x][p.y] == 'R' && arr[nextX][nextY] == 'G') || (arr[p.x][p.y] == 'G' && arr[nextX][nextY] == 'R')) {
                    yesVisit[nextX][nextY] = true;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static void nobfs(Point point) {
        Queue<Point> que = new ArrayDeque<>();
        que.add(point);
        noVisit[point.x][point.y] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nextX = p.x + dirX[i];
                int nextY = p.y + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length || noVisit[nextX][nextY])
                    continue;
                if (!noVisit[nextX][nextY] && arr[nextX][nextY] == arr[p.x][p.y]) {
                    noVisit[nextX][nextY] = true;
                    que.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
