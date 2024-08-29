import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int bit = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();

            if (text.equals("all")) {
                bit = 1;
                for (int j = 0; j < 20; j++) {
                    bit *= 2;
                }
                bit -= 1;
//                bit = 1_048_575;
                continue;
            }
            if (text.equals("empty")) {
                bit = 0;
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if (text.equals("add")) {
                bit = (1 << (num-1)) | bit;
            } else if (text.equals("remove")) {
                bit = (~ (1 << (num - 1)) ) & bit;
            } else if (text.equals("check")) {
                if (((1 << (num- 1))  & bit) == 0) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
                sb.append("\n");
            } else if (text.equals("toggle")) {
                bit = (1 << (num - 1)) ^ bit;
            }
        }

        System.out.println(sb.toString());
    }
}
