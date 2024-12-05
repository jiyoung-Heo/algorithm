//12:10
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //모두 초로 바꿔서 저장
        int sec_len = Integer.parseInt(video_len.split(":")[1]) + Integer.parseInt(video_len.split(":")[0])*60;
        int sec_pos = Integer.parseInt(pos.split(":")[1]) + Integer.parseInt(pos.split(":")[0])*60;
        int sec_op_st = Integer.parseInt(op_start.split(":")[1]) + Integer.parseInt(op_start.split(":")[0])*60;
        int sec_op_ed = Integer.parseInt(op_end.split(":")[1]) + Integer.parseInt(op_end.split(":")[0])*60;
        int now = sec_pos;
        for(int i = 0; i<commands.length; i++){
            if(sec_op_st <= now && sec_op_ed >= now ){
                    now = sec_op_ed;
            }
            if(commands[i].equals("next")){
                //next
                now += 10;
                if(now >= sec_len){
                    now = sec_len;
                }
            }else{
                //prev
                now -= 10;
                if(now < 0){
                    now = 0;
                }
            }
        }
        if(sec_op_st <= now && sec_op_ed >= now ){
            now = sec_op_ed;
        }
        String min = String.valueOf(now/60);
        String sec = String.valueOf(now%60);
        
        if(min.length() == 1){
            min = "0" + min;
        }
        if(sec.length() == 1){
            sec = "0" + sec;
        }
        String answer = min+":"+sec;
        return answer;
    }
}