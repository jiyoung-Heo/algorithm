class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] arr = phone_number.split("");
        for(int i = 0; i<= arr.length-5; i++){
            answer += "*";
        }
        for(int i = arr.length-4; i <arr.length; i++){
            answer += arr[i];
        }
        
        return answer;
    }
}