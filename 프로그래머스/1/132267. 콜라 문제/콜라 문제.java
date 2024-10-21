class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int count = n;
        while(true){
            int sep = count/a*b;
            if(sep == 0){
                break;
            }
            int nam = count%a;
            count = sep + nam;
            answer+=sep;
        }
        
        return answer;
    }
}