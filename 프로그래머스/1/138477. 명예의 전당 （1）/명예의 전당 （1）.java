import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        for(int i =0; i<score.length; i++){
                que.add(score[i]);
            if(i>=k){
                que.poll();
            }
            answer[i] = que.peek();
        }
        return answer;
    }
}