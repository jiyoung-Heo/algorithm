import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int result = 0;
        for (int i = 0; i < (1 << (n * m)); i++) {
            int max = 0;
            String number = "";
            for (int j = 0; j < n * m; j++) {
                if (((1 << j) & i) != 0) {
                    //오른쪽 연결성 체크
                    number += String.valueOf(arr[j / m][j % m]);
                } else {
                    if (number.isEmpty()) continue;
                    max += Integer.parseInt(number);
                    number = "";
                }
                if (j % m == m - 1) {
                    if (number.isEmpty()) continue;
                    max += Integer.parseInt(number);
                    number = "";
                }
            }

            int index = 0;
            while (index < m) {
                for (int k = 0; k < n; k++) {
                    if (((1 << (k * m + index)) & i) == 0) {
                        number += String.valueOf(arr[k][index]);
                    } else {
                        if (number.isEmpty()) continue;
                        max += Integer.parseInt(number);
                        number = "";
                    }
                    if (k == n - 1) {
                        if (number.isEmpty()) continue;
                        max += Integer.parseInt(number);
                        number = "";
                    }
                }
                index++;
            }
            result = Math.max(max, result);
        }
        System.out.println(result);
    }
}