import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[h][w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                arr[j][i] = true;
            }
        }
        int sum = 0;
        for (int i = 0; i < h; i++) {
            int count = 0;
            for (int j = 0; j < w; j++) {
                //첫줄 이고 벽 없을 때
                if (i == 0 && !arr[i][j]) {
                    if (j != 0 && arr[i][j - 1] && !arr[i][j]) {
                        if (j != w - 1) {
                            sum++;
                            arr[i][j] = true;
                        }

                    }
                }
                if (arr[i][j]) {
                    sum += count;
                    count = 0;
                }
                if (j != 0 && arr[i][j - 1] && !arr[i][j]) {
                    if (j != w - 1) {
                        count++;
                        arr[i][j] = true;
                    }else{
                        if (arr[i][j]) {
                            sum += count;
                            count = 0;
                        }
                    }
                }


            }
        }

        System.out.println(sum);
    }
}

