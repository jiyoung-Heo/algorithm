import java.util.*;
import java.io.*;
class Solution {
    public int solution(String s) {
        Map<String,Integer> map = new HashMap<>();
        
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        char[] arr = s.toCharArray();
        String target = "";
        String result = "";
        
        for(int i =0 ; i < arr.length; i++){
            if(arr[i] >= '0' && arr[i] <='9'){
                result += arr[i];
                continue;
            }else{
                //문자일 경우
                target += arr[i];
                if(map.containsKey(target)){
                    result += map.get(target);
                    target = "";
                }
            }
            
        }
        
        return Integer.parseInt(result);
    }
}