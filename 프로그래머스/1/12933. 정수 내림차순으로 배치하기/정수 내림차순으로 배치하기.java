import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = (n+"").split("");
        Arrays.sort(arr);
        String result = "";
        for(int i = 0; i<arr.length; i++){
            result += Long.parseLong(arr[arr.length-1-i]);
        }
        return Long.parseLong(result);
    }
}