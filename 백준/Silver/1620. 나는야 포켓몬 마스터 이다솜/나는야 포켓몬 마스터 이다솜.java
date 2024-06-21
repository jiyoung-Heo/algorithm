
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer,String> intMap = new HashMap<>();
        Map<String,Integer> stringMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String text = br.readLine();
            intMap.put(i,text);
            stringMap.put(text,i);
        }
        for (int i = 0; i < m; i++) {
            String result = br.readLine();
            boolean flag = true;
            for(char c : result.toCharArray()){
                if(!Character.isDigit(c)) {
                    flag = false;
                    break;
                }
            }
            //문자일경우
            if(!flag){
                System.out.println(stringMap.get(result));
            }else{
                System.out.println(intMap.get(Integer.parseInt(result)));
            }
        }
    }
}
