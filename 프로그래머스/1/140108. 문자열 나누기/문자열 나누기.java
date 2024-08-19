class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split("");
        String first = arr[0];
        int firstCnt = 1;
        int nextCnt = 0;
        if(arr.length == 1){
            return 1;
        }
        for(int i = 1; i<arr.length; i++){
            if(first.equals(arr[i])){
                firstCnt++;
            }else{
                nextCnt ++;
            }
            if(i == arr.length-1){
                    answer++;
                    break;
                }
            if(firstCnt == nextCnt){
                answer++;
                first = arr[i+1];
                firstCnt = 0;
                nextCnt = 0;
                
            }

        }
        return answer;
    }
}