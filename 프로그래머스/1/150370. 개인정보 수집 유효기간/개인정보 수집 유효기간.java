import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //8:10
        
        Map<String, Integer> map = new HashMap<>();
    
        for(int i = 0 ;i<terms.length; i++){
            map.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }
        // System.out.println(today.split("\\.").length);
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<privacies.length; i++){
            String[] sp = privacies[i].split(" ");
            
            String date = sp[0];
            String term = sp[1];
            
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            
            month += map.get(term);
            while(month > 12){
                year+=1;
                month-=12;
            }
            
            if(todayYear > year){
                list.add(i+1);
            }else if(todayYear == year){
               if(todayMonth > month){
                   list.add(i+1);
               }else if(todayMonth == month){
                   if(todayDay >= day){
                       list.add(i+1);
                   }
               }
            }
        }
                
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ;i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}