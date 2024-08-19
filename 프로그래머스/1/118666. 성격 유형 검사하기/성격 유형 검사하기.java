import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R",0);
        map.put("T",1);
        map.put("C",2);
        map.put("F",3);
        map.put("J",4);
        map.put("M",5);
        map.put("A",6);
        map.put("N",7);
        
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(0,"R");
        map2.put(1,"T");
        map2.put(2,"C");
        map2.put(3,"F");
        map2.put(4,"J");
        map2.put(5,"M");
        map2.put(6,"A");
        map2.put(7,"N");
        
        int[] num = new int[8];
        
        for(int i = 0 ; i<survey.length; i++){
            String[] arr = survey[i].split("");
            int choice = choices[i];
            if(choice < 4){//왼쪽에 점수
                int index = map.get(arr[0]);
                num[index] += 4-choice;
            }else if(choice >4){//오른쪽에 점수
                int index = map.get(arr[1]);
                num[index] += (choice-4);
            }
        }
                     
        for(int i = 0; i < num.length; i+=2){
            if(num[i]>num[i+1]){
                answer += map2.get(i);
            }else if(num[i]<num[i+1]){
                answer += map2.get(i+1);
            }else if(num[i]==num[i+1]){
                if(map2.get(i).charAt(0) > map2.get(i+1).charAt(0)){
                    answer+= map2.get(i+1);
                }else{
                    answer+= map2.get(i);
                }
            }
        }
        return answer;
    }
}