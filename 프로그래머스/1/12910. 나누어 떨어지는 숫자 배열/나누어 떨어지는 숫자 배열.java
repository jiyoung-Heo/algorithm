import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int target: arr){
            if(target%divisor == 0){
                list.add(target);
            }
        }
        Collections.sort(list);
        
        if(list.size() ==0){
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = list.get(i);
        }
        
        
        return result;
    }
}