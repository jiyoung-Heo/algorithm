
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new boolean[m][n];
        visited = new boolean[m][n];
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            for (int j = leftX; j < rightX; j++) {
                for (int l = leftY; l < rightY; l++) {
                    map[l][j] = true;
                }
            }
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        //bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    visited[i][j] = true;
                    list.add(bfs(i, j));
                    count++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(int num : list){
            System.out.print(num+" ");
        }
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    static int bfs(int x, int y) {
        ArrayDeque<Point> que = new ArrayDeque();
        que.add(new Point(x, y));
        int count = 1;
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dirX[i];
                int nextY = p.y + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || visited[nextX][nextY] || map[nextX][nextY]) {
                    continue;
                }
                count++;
                visited[nextX][nextY] = true;
                que.add(new Point(nextX, nextY));
            }
        }
        return count;
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
