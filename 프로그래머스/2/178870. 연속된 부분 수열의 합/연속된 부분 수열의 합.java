import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int sum = 0;
        int size = sequence.length;
        for(int i = sequence.length-1; i>=0; i--){
            que.add(sequence[i]);
            sum += sequence[i];
            if(que.size() > size){
                sum-=que.poll();
            }
            if(sum > k){
                sum -= que.poll();
            }else if(sum == k){
                size = que.size();
                answer[0] = i;
                sum-=que.poll();
                answer[1] = i + que.size();
            }
        }
        
        return answer;
    }
}