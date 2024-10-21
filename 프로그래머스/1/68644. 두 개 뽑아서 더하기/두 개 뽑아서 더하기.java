import java.io.*;
import java.util.*;
class Solution {
    //2개 조합
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                int sum = numbers[i]+numbers[j];
                if(!set.contains(sum)){
                    set.add(sum);
                    list.add(sum);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i =0 ;i<list.size(); i++){
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}