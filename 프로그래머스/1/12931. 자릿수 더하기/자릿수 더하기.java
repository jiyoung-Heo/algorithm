import java.util.*;

public class Solution {
    public int solution(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int answer = 0;
        
        for(int i = 0; i<arr.length; i++){
            answer += arr[i]-'0';
        }

        return answer;
    }
}