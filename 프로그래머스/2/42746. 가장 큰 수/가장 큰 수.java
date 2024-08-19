import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 Integer 객체 배열로 변환
        Integer[] b = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        // Comparator를 사용하여 정렬
        Arrays.sort(b, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                // 두 숫자를 문자열로 변환
                String strA = a.toString();
                String strB = b.toString();
                
                // 두 숫자를 결합하여 비교
                String order1 = strA + strB;
                String order2 = strB + strA;
                
                // 문자열 비교를 통해 정렬 순서 결정
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });
        
        // 결과 문자열을 생성
        StringBuilder answer = new StringBuilder();
        for (Integer num : b) {
            answer.append(num);
        }
        
        // 결과가 "000...0"인 경우 "0"을 반환
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}
