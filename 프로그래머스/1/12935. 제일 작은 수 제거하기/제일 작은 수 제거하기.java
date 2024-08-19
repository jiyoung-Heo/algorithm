import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        if(arr.length == 1)
            return new int[]{-1};
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }
        boolean flag = false;
        for(int i = 0; i<arr.length; i++){
            if(i == minIndex) {
                flag = true;
                continue;
            }
            if(flag){
                answer[i-1] = arr[i];
            }else{
                answer[i] = arr[i];
            }
            
        }
        
        return answer;
    }
}