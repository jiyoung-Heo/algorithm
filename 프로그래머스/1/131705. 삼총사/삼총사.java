class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        pick(0,0, number, 0);
        return answer;
    }
    public void pick(int count, int sum, int[] number, int index){

        if(count == 3){
            //삼총사 완성
            if(sum == 0) answer ++;
            return;
        }
        if(index >= number.length){
            return;
        }
        
        //뽑느경우
        pick(count+1, sum+number[index], number, index+1);
        //안뽑는경우
        pick(count, sum, number, index+1);
    }
}