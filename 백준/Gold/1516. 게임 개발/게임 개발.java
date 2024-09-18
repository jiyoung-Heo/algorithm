import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] result = new int[n];
        int[] sec = new int[n];
        int[] sum = new int[n];

        ArrayList<Integer>[] next = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            next[i] = new ArrayList<>();
        }

        ArrayDeque<Integer> que = new ArrayDeque<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int secNum =  Integer.parseInt(st.nextToken());
            result[i] = secNum;
            sec[i] = secNum;

            int cnt = 0;
            while(st.hasMoreTokens()){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == -1){
                    //끝
                    if(cnt == 0) que.add(i);
                    break;
                }else{
                    next[temp-1].add(i);
                    sum[i]++;
                    cnt++;
                }
            }
        }
        while(!que.isEmpty()){
            int idx = que.poll();
            for(int i : next[idx]){
                result[i] = Math.max(result[i], result[idx]+sec[i]);
                sum[i]--;
                if(sum[i] == 0){
                    que.add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

}