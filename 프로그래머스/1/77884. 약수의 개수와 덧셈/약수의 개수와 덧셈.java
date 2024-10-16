class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count =0;
            for(int j = 1; j<= Math.floor(Math.sqrt(i)); j++){
                if(i % j == 0){
                    int a = i/j;
                    if(a ==j)
                    {
                        count+=1;
                    }else{
                        count+=2;
                    }                     
                }
            }
            if(count%2 == 0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
}