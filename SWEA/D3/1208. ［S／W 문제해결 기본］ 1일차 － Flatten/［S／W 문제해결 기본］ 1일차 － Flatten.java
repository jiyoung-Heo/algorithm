import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for (int d = 1; d <= 10; d++) {
            int dumpCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
 
            int[] boxHeightArr = new int[100];
 
            for (int i = 0; i < 100; i++) {
                boxHeightArr[i] = Integer.parseInt(st.nextToken());
            }
 
            int[] copyArr = Arrays.copyOf(boxHeightArr, boxHeightArr.length);
            Arrays.sort(copyArr);
             
            for (int i = 0; i < dumpCount; i++) {
                int maxHeight = copyArr[copyArr.length - 1];
                int minHeight = copyArr[0];
 
                for (int j = 0; j < boxHeightArr.length; j++) {
                    if (boxHeightArr[j] == maxHeight) {
                        boxHeightArr[j]--;
                        break;
                    }
                }
                for (int j = 0; j < boxHeightArr.length; j++) {
                    if (boxHeightArr[j] == minHeight) {
                        boxHeightArr[j]++;
                        break;
                    }
                }
 
                copyArr = Arrays.copyOf(boxHeightArr, boxHeightArr.length);
                Arrays.sort(copyArr);
            }
             
 
            System.out.println("#" + d + " " + (copyArr[copyArr.length-1] - copyArr[0]));
        }
 
    }
}