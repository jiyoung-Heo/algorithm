
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String text = br.readLine();
            if (set.contains(text)) {
                count++;
                list.add(text);
            }
        }
        System.out.println(count);
        if(!list.isEmpty()){
            Collections.sort(list);
            for (String result : list) {
                System.out.println(result);
            }
        }
    }
}
