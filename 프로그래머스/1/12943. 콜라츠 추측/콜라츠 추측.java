class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        long target = num;
        int answer = 0;
        
        for(int i =1 ; i<=500; i++){
            if(target % 2 == 0){
                target /= 2;
            }else{
                target = target*3+1;
            }
            
            if(target == 1) {
                answer = i;
                break;
            }
            if(i == 500){
                answer = -1;
            }
        }
        
        return answer;
    }
}