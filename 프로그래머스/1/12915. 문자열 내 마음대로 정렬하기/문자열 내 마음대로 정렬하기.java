import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = Arrays.asList(strings);
        
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.toCharArray()[n]-o2.toCharArray()[n] == 0){
                    String[] temp = new String[2];
                    temp[0] = o1; temp[1] = o2;
                    Arrays.sort(temp);
                    if(o1.equals(temp[0])) return -1;
                    return 1;
                }
                return o1.toCharArray()[n]-o2.toCharArray()[n];
            }
        });
        
        String[] result = list.toArray(new String[list.size()]);
        return result;
    }
}