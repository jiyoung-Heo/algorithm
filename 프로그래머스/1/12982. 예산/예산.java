import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        int last = budget;
        for(int i = 0; i<d.length; i++){
            if(last >= d[i]){
                answer++;
                last-=d[i];
            }else{
                break;
            }
        }
        
        return answer;
    }
}