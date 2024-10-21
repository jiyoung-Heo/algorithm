import java.io.*;
import java.util.*;

class Solution {
    class Car{
        String number;
        int time;
        int count; 

        public Car(String number, int time, int count){
            this.number = number;
            this.time = time;
            this.count = count;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        int min = fees[0];
        int minAmount = fees[1];
        int time = fees[2];
        int amount = fees[3];
        
        Map<String, String> map = new HashMap<>();
        List<Car> list = new ArrayList<>();
        
        for(int i =0; i<records.length; i++){
            String[] temp = records[i].split(" ");
            if(temp[2].equals("IN")){
                map.put(temp[1], temp[0]);
                Boolean flag = false;
                for(int k =0 ; k<list.size(); k++){
                    if(list.get(k).number.equals(temp[1])){
                        flag = true;
                        list.get(k).count = 1;
                    }
                }
                if(!flag){
                list.add(new Car(temp[1],0,1));
                }
            }else{
                //out일경우
                String inTime = map.get(temp[1]);
                String outTime = temp[0];
                String[] splitTemp = inTime.split(":");
                int inTimeHour = Integer.parseInt(splitTemp[0]);
                int inTimeMin = Integer.parseInt(splitTemp[1]);
                splitTemp = outTime.split(":");
                int outTimeHour = Integer.parseInt(splitTemp[0]);
                int outTimeMin = Integer.parseInt(splitTemp[1]);
                
                int calcTime = 0;
                
                if(outTimeMin < inTimeMin){
                    calcTime = outTimeMin+60 - inTimeMin;
                    calcTime += (outTimeHour-1 - inTimeHour)*60;
                }else{
                    calcTime = outTimeMin - inTimeMin;
                    calcTime += (outTimeHour - inTimeHour)*60;
                }
                
                for(int k =0 ; k<list.size(); k++){
                    if(list.get(k).number.equals(temp[1])){
                        list.get(k).time += calcTime;
                        list.get(k).count = 0;
                    }
                }
                map.remove(temp[1]);
            }
        }
        
        Collections.sort(list,new Comparator<Car>(){
            @Override
            public int compare(Car o1, Car o2){
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            };
        });
        
        int[] answer = new int[list.size()];
        
        for(int i =0 ; i<list.size(); i++){
            if(list.get(i).count %2 != 0){
                //출차 안한경우. 23:59분기준으로 계산하기
                int calcTime = 0;
                String[] splitTemp = map.get(list.get(i).number).split(":");
                int inTimeHour = Integer.parseInt(splitTemp[0]);
                int inTimeMin = Integer.parseInt(splitTemp[1]);
                
                int outTimeHour = 23;
                int outTimeMin = 59;
                
                if(outTimeMin < inTimeMin){
                    calcTime = outTimeMin+60 - inTimeMin;
                    calcTime += (outTimeHour-1 - inTimeHour)*60;
                }else{
                    calcTime = outTimeMin - inTimeMin;
                    calcTime += (outTimeHour - inTimeHour)*60;
                }
                
                list.get(i).time += calcTime;
                list.get(i).count++;
            }
            
            answer[i]= minAmount;
            
            System.out.println(list.get(i).time);
            if(list.get(i).time > min){
                int tempTime = list.get(i).time - min;
                answer[i] += tempTime/time * amount;
                if(tempTime%time != 0){
                    answer[i] += amount;
                }
            }
        }
    
        
        
        return answer;
    }
    
}
