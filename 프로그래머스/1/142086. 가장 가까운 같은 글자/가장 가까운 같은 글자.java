import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("");
        int[] answer = new int[arr.length];

        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                //처음들어오는경우 result -1
                answer[i] = -1;
                map.put(arr[i], i);
            }else{
                //두번째 들어오는경우 map.get 후 map update
                answer[i] = i-map.get(arr[i]);
                map.put(arr[i],i);
            }
        }
        
        
        return answer;
    }
}