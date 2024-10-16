import java.io.*;
import java.util.*;
class Solution {
    public long solution(long n) {
        double temp = Math.sqrt(n);
        if(temp%1 == 0){
            return (long)(Math.pow(temp+1,2));
        }
        return -1;
    }
}