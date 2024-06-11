
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (que.isEmpty()) {
                    System.out.println(0);
                } else {
                    int target = que.poll();
//                    while (!que.isEmpty() && que.peek() == target) {
//                        que.poll();
//                    }
                    System.out.println(target);
                }
            } else {
                que.add(num);
            }
        }
    }
}
