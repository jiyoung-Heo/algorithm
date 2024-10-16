class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() %2 != 0){
            answer = s.split("")[s.length()/2];
        }else{
            answer = s.split("")[s.length()/2-1]+s.split("")[s.length()/2];
        }
        return answer;
    }
}