import java.io.*;
import java.util.*;
class Solution {
    static int[] answerArr;
    static Node[] node;
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        
        node = new Node[friends.length];
        for(int i = 0; i<friends.length; i++){
            node[i] = new Node(i,friends[i],0,0, new int[friends.length]);
            map.put(friends[i],i);
        }//초기화
        StringTokenizer st;
        for(int i = 0; i<gifts.length; i++){
            st = new StringTokenizer(gifts[i]);
            String to = st.nextToken();
            String from = st.nextToken();
            node[map.get(to)].toCount++;
            node[map.get(from)].fromCount++;
            node[map.get(to)].countArr[map.get(from)]++;
        }
        
        answerArr = new int[friends.length];
        
        //조합
        for(int i = 0; i<gifts.length-1; i++){
            combination(i,1,0,i);         
        }
        
        int answer = 0;
        
        for(int i = 0; i<node.length ; i ++){
            if(answerArr[i] > answer){
                answer = answerArr[i];
            }
        }        
        return answer;
    }
    public void combination(int index, int count, int fromIndex, int firstIndex){
        if(count == 2){
            if(node[firstIndex].countArr[fromIndex] > node[fromIndex].countArr[firstIndex]){
                answerArr[firstIndex]++;
            }else if(node[firstIndex].countArr[fromIndex] < node[fromIndex].countArr[firstIndex]){
                answerArr[fromIndex]++;
            }else{
                //같을경우 선물지수로 비교하기
                if(node[firstIndex].toCount - node[firstIndex].fromCount > node[fromIndex].toCount-node[fromIndex].fromCount){
                    answerArr[firstIndex]++;
                    //firstindex가 선물받음
                }else if(node[firstIndex].toCount-node[firstIndex].fromCount < node[fromIndex].toCount-node[fromIndex].fromCount){
              //fromIndex가 선물받음      
                    answerArr[fromIndex]++;
                }
            }
            return;
        }
        if(index >= node.length){
            return;
        }
        for(int i = index+1; i<node.length;i++){
            combination(index, count+1, i, firstIndex);
        }
    }
    class Node{
        int index;
        String name;
        int toCount;
        int fromCount;
        int[] countArr;
        Node(int a,String e,int b,int c, int[] d){
            index = a;
            toCount = b;
            fromCount = c;
            countArr = d;
            name = e;
        }
    }
}