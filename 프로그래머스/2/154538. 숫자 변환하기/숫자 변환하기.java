import java.io.*;
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) {
            return 0;
        }
        
        int answer = 0;
        int[] dp = new int[3000001];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[x] = 0;
        
        Queue<Integer> que = new ArrayDeque<>();
        que.add(x);
        
        while(!que.isEmpty()){
            int temp = que.poll();
            if(temp > y) continue;
            if(temp*3 <= y){
                if(dp[temp*3]>=dp[temp]+1){
                    dp[temp*3] = Math.min(dp[temp*3],dp[temp]+1);
                    que.add(temp*3);
                }
                if(temp*3 == y) break;
            }
            if(temp*2 <=y){
                if(dp[temp*2]>=dp[temp]+1){
                    dp[temp*2] = Math.min(dp[temp*2],dp[temp]+1);
                    que.add(temp*2);
                }
                if(temp*2 == y) break;
            }
            if(temp+n <=y){
                if(dp[temp+n]>=dp[temp]+1){
                    dp[temp+n] = Math.min(dp[temp+n],dp[temp]+1);
                    que.add(temp+n);
                }
                if(temp+n == y) break;
            }
        }
        
        if(dp[y] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[y];   
        }
    }
}