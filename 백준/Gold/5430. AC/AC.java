
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean flag;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            flag = false;
            char[] arr = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            ArrayDeque<Integer> que = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                que.add(Integer.parseInt(st.nextToken()));
            }
            boolean isReverce = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'R') {
                    isReverce = !isReverce;
                } else {
                    if (que.isEmpty()) {
                        //만약 아무것도없는데 버리라하면 error리턴하고끝내기
//                        System.out.println("error");
                        sb.append("error\n");
                        flag = true;
                        break;
                    } else {
                        //버리기
                        if (isReverce) {
                            que.pollLast();
                        } else {
                            que.pollFirst();
                        }
                    }
                }
            }
            if (!flag) {
                sb.append("[");
                while(!que.isEmpty()){
                    if(isReverce){
                        sb.append(que.pollLast());
                    }else{
                        sb.append(que.pollFirst());
                    }
                    if(!que.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
