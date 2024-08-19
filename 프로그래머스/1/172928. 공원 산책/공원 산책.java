class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        
        String[][] parkArr = new String[park.length][];
        
        for(int i = 0; i < park.length; i++){
            parkArr[i] = park[i].split("");
        }
        for(int i = 0; i < parkArr.length; i++){
            for(int j = 0; j<parkArr[0].length; j++){
                if(parkArr[i][j].equals("S")){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        for(int i= 0; i < routes.length; i++){
            boolean flag = true;
            String[] curr = routes[i].split(" ");
            
            String position = curr[0];
            int length = Integer.parseInt(curr[1]);
            if(position.equals("E")){
                int nextX = x;
                int nextY = y+length;
                if(nextY >= parkArr[0].length){
                    continue;
                }
                
                for(int j = y; j <= nextY; j++){
                    if(parkArr[nextX][j].equals("X")){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                y = nextY;   
                }
            }else if(position.equals("S")){
                int nextX = x+length;
                int nextY = y;
                
                if(nextX >= parkArr.length){
                    continue;
                }
                
                for(int j = x; j <= nextX; j++){
                    if(parkArr[j][nextY].equals("X")){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                x = nextX;   
                }
            }else if(position.equals("W")){
                int nextX = x;
                int nextY = y-length;
                if(nextY < 0){
                    continue;
                }
                
                for(int j = y; j >= nextY; j--){
                    if(parkArr[nextX][j].equals("X")){
                        flag = false;
                        break;
                    }
                    
                }
                
                if(flag){
                    y = nextY;   
                }
            }else if(position.equals("N")){
                int nextX = x-length;
                int nextY = y;
                if(nextX < 0){
                    continue;
                }
                for(int j = x; j >= nextX; j--){
                    if(parkArr[j][nextY].equals("X")){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    x = nextX;    
                }
                
            }
        }
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}