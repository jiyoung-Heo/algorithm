import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[200002];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[a] = 0;

        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        que.add(a);
        while (true) {
            int temp = que.poll();
            if(temp > 100000) continue;

            if (temp - 1 >= 0) {
                if(arr[temp - 1] > arr[temp] + 1){
                    arr[temp - 1] = arr[temp] + 1;
                    que.add(temp - 1);
                }
                if (temp - 1 == b) {
                    System.out.println(arr[temp - 1]);
                    break;
                }
            }

            if(arr[temp + 1] > arr[temp] + 1){
                arr[temp + 1] = arr[temp] + 1;
                que.add(temp + 1);
            }
            if (temp + 1 == b) {
                System.out.println(arr[temp + 1]);
                break;
            }

            if(arr[temp * 2] > arr[temp] + 1){
                arr[temp * 2] = arr[temp] + 1;
                que.add(temp * 2);
            }
            if (temp * 2 == b) {
                System.out.println(arr[temp * 2]);
                break;
            }

        }

    }

}