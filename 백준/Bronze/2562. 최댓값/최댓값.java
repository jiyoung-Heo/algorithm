import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = 0;
        int index = 0;
        
        // 배열에 값 입력
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 최댓값과 그 위치 찾기
        for (int i = 0; i < 9; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i + 1; // 위치는 1부터 시작하므로 +1
            }
        }
        
        // 최댓값과 위치 출력
        System.out.println(max);
        System.out.println(index);
        
        sc.close();
    }
}
