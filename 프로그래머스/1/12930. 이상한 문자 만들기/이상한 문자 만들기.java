class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ", -1);
        
        for(int i = 0; i<arr.length; i++){
            String[] target = arr[i].split("");
            for(int j =0 ;j<target.length; j++){
                if(j%2 ==0){
                    answer += target[j].toUpperCase();
                }else{
                    answer += target[j].toLowerCase();
                }
            }
            if(i != arr.length-1){
                answer+= " ";
            }
        }
        return answer;
    }
}