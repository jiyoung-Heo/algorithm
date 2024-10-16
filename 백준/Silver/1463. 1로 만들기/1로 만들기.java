import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[3000001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        for (int i = 1; i < n; i++) {
            arr[i*3] = Math.min(arr[i*3],arr[i]+1);
            arr[i*2] = Math.min(arr[i*2],arr[i]+1);
            arr[i+1] = Math.min(arr[i+1],arr[i]+1);
        }
        System.out.println(arr[n]);

    }

}