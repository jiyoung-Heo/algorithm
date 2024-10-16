import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int target: numbers){
            set.add(target);
        }
        for(int i = 0; i<10; i++){
            if(!set.contains(i)){
                answer+= i;
            }
        }
        return answer;
    }
}