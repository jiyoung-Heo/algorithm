import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        
        int sx = Integer.MAX_VALUE;
        int sy = Integer.MAX_VALUE;
        int lx = Integer.MIN_VALUE;
        int ly = Integer.MIN_VALUE;
        String[][] arr = new String[wallpaper.length][wallpaper[0].length()];
        
        for(int i = 0; i<wallpaper.length; i++){
            arr[i] = wallpaper[i].split("");
        }
        
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                if(arr[i][j].equals("#")){
                    lx = Math.max(lx,i);
                    ly = Math.max(ly,j);
                    sx = Math.min(sx,i);
                    sy = Math.min(sy,j);
                    
                    lx = Math.max(lx,i+1);
                    ly = Math.max(ly,j+1);
                    sx = Math.min(sx,i+1);
                    sy = Math.min(sy,j+1);
                }
            }
        }
        int[] answer = {sx,sy, lx, ly};
        return answer;
    }
}