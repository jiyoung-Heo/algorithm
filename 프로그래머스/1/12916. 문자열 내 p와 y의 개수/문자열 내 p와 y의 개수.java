class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'p' || arr[i] == 'P'){
                pCount++;
            }
            if(arr[i] == 'y' || arr[i] == 'Y' ){
                yCount++;
            }
        }
        if(pCount == yCount) return true;
        
        return false;
    }
}