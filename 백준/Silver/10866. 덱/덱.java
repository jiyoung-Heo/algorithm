import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            if(text.equals("push_front")){
                que.addFirst(Integer.parseInt(st.nextToken()));
            }else if(text.equals("push_back")){
                que.addLast(Integer.parseInt(st.nextToken()));
            }else if(text.equals("pop_front")){
                if(que.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(que.pollFirst()+"\n");
            }else if(text.equals("pop_back")){
                if(que.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(que.pollLast()+"\n");
            }else if(text.equals("size")){
                sb.append(que.size()+"\n");
            }else if(text.equals("empty")){
                if(que.isEmpty()){
                    sb.append(1+"\n");
                }else{
                    sb.append(0+"\n");
                }
            }else if(text.equals("front")){
                if(que.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(que.peekFirst()+"\n");
            }else if(text.equals("back")){
                if(que.isEmpty()){
                    sb.append(-1+"\n");
                    continue;
                }
                sb.append(que.peekLast()+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}