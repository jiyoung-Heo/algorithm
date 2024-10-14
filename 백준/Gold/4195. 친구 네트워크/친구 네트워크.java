import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    static Map<Integer, Integer> mapCount;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int count = 1;
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<String, Integer>();
            mapCount = new HashMap<Integer, Integer>();
            arr = new int[200001];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = j;
            }
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a) && !map.containsKey(b)) {
                    map.put(a, count);
                    map.put(b, count);
                    mapCount.put(count, 2);
                    count++;

                } else if (map.containsKey(a)) {
                    if (!map.containsKey(b)) {
                        map.put(b, map.get(a));

                        mapCount.put(find(map.get(a)), mapCount.get(find(map.get(a))) + 1);
                    } else {
                        int head = find(map.get(b));
                        int headTemp = find(map.get(a));
                        if(head > headTemp) {
                            arr[head] = headTemp;
                            mapCount.put(headTemp, mapCount.get(headTemp) +mapCount.get(head));
                        }else if(head < headTemp){
                            arr[headTemp] = head;
                            mapCount.put(head, mapCount.get(head) +mapCount.get(headTemp));

                        }

                    }
                } else if (map.containsKey(b)) {
                    if (!map.containsKey(a)) {
                        map.put(a, map.get(b));
                        mapCount.put(find(map.get(b)), mapCount.get(find(map.get(b))) + 1);

                    }
                }

                System.out.println(mapCount.get(find(map.get(a))));
            }
        }
    }


    static int find(int index) {
        if (index != arr[index]) {
            return arr[index] = find(arr[index]);
        }
        return index;
    }

}