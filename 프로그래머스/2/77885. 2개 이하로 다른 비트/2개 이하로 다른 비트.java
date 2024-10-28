class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i =0; i<numbers.length; i++){
            long targetNumber = numbers[i];
            for(int j = 0; j<64; j++){
                answer[i] = 1;
                if((targetNumber & ((long)1<<j)) == 0){
                    for(int k = 1; k < j; k++){
                        answer[i] *= 2;
                    }
                    answer[i] += numbers[i];
                    break;
                }
            }
        }
        return answer;
    }
}