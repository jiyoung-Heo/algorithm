class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //마지막 초 이 공격 이후 종료
        int lastSec = attacks[attacks.length-1][0];
        int maxHealth = health;
        
        int count = 0;
        for(int i = 1; i <= lastSec; i++){
            // System.out.println(health);
            boolean flag = false;
            
            for(int j = 0; j< attacks.length; j++){
                if(attacks[j][0] == i){
                    health -= attacks[j][1];
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                count = 0;
            }else{
                count ++; 
                if(count >= bandage[0]){
                    health += bandage[1];
                    health += bandage[2];
                    count = 0;
                }else{
                    health += bandage[1];
                }
            }
            if(health <= 0){
                return -1;
            }
            if(health >= maxHealth){
                health = maxHealth;
            }
        }
        
        return health;
    }
}