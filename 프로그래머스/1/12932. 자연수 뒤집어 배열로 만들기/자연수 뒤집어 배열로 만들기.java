class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(n+"").length()];
        String[] arr = (n+"").split("");
        
        for(int i = arr.length-1; i>=0; i--){
            answer[arr.length-1-i] = Integer.parseInt(arr[i]);
        }
        
        return answer;
    }
}