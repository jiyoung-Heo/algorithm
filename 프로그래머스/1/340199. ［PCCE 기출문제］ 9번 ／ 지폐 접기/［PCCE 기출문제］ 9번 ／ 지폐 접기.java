//10:45
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int minW = 0;
        int maxW = 0;
        int minB = 0;
        int maxB = 0;
        
        if(wallet[0] > wallet[1]){
            maxW = wallet[0];
            minW = wallet[1];
        } else{
            maxW = wallet[1];
            minW = wallet[0];
        }

        if(bill[0] > bill[1]){
            maxB = bill[0];
            minB = bill[1];
        } else{
            maxB = bill[1];
            minB = bill[0];
        }
        
        while(minB > minW || maxB > maxW){
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            answer++;
            
            if(wallet[0] > wallet[1]){
                maxW = wallet[0];
                minW = wallet[1];
            } else{
                maxW = wallet[1];
                minW = wallet[0];
            }
            
            if(bill[0] > bill[1]){
                maxB = bill[0];
                minB = bill[1];
            } else{
                maxB = bill[1];
                minB = bill[0];
            }
        }
        
        return answer;
    }
}