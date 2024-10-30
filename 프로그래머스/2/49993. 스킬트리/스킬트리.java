import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        String[] skills = skill.split("");
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<skills.length; i++){
            map.put(skills[i],i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listSort = new ArrayList<>();

        for(int i = 0; i<skill_trees.length; i++){
            list.clear();
            listSort.clear();
            String[] tempArr = skill_trees[i].split("");
            for(int j = 0; j<tempArr.length; j++){
                if(map.containsKey(tempArr[j])){
                    list.add(map.get(tempArr[j]));
                    listSort.add(map.get(tempArr[j]));
                }
            }
            Collections.sort(listSort);
            boolean is = false;
            for(int j = 0; j<list.size(); j++){
                if(!(list.get(j) ==listSort.get(j)) || list.get(j) != j){
                    is = true;
                    break;
                }
            }
            if(!is){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}