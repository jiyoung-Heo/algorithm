//3:10
import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer,"");
        
        int[] result = new int[n];
        
        for(int i = 0; i<n; i++){
            result[i] = (arr1[i] | arr2[i]);
        }
        
        for(int i = 0; i< n; i++){
            for(int j = n-1; j >= 0; j--){
                if((result[i] & (1<<j)) != 0){
                    answer[i] += "#";
                    continue;
                } 
                answer[i] += " ";
            }
        }

        return answer;
    }
}