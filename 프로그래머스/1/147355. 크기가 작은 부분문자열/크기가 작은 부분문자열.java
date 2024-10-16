class Solution {
    public int solution(String t, String p) {
        String[] tArr = t.split("");
        
        int answer = 0;
        for(int i = 0; i <= tArr.length-p.length(); i++ ){
            String a = "";
            for(int j = 0; j<p.length(); j++){
                a += tArr[i+j];
            }
            if(Long.parseLong(a) <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}