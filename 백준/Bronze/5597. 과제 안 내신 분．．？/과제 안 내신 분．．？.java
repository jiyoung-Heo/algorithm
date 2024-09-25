import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean[] students = new boolean[31]; // 1번부터 30번까지 학생 존재 (0번은 사용하지 않음)
        
        // 28명의 제출한 학생 번호 입력받기
        for (int i = 0; i < 28; i++) {
            int studentNum = sc.nextInt();
            students[studentNum] = true; // 제출한 학생은 true로 표시
        }
        
        // 제출하지 않은 학생 번호 출력
        for (int i = 1; i <= 30; i++) {
            if (!students[i]) { // 제출하지 않은 학생 찾기
                System.out.println(i);
            }
        }
        
        sc.close();
    }
}
