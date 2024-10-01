import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int min = 0;
            int max = n-1;
            int mid = (min+max) /2;
            while(min != max){
                mid = (min+max) /2;
                if(arr[mid] < target[i]){
                    min = mid+1;
                }else if(arr[mid]>target[i]){
                    max = mid;
                }else if(arr[mid] == target[i]){
                    sb.append(1).append("\n");
                    break;
                }
            }
            if(min == max){
                if(arr[max] == target[i]){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}