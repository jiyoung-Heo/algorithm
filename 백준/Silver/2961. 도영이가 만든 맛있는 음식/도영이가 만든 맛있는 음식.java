import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;

        int[] sArr = new int[n];
        int[] bArr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sArr[i] = s;
            bArr[i] = b;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < (1<<n) ; i++) {
            int sNum = 1;
            int bNum = 0;
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    sNum *= sArr[j];
                    bNum += bArr[j];
                }
            }
            result = Math.min(result, Math.abs(sNum-bNum));
        }
        System.out.println(result);

    }

}
