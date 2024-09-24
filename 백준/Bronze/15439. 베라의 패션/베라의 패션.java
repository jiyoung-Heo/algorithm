import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 색상의 수 N 입력
        int N = scanner.nextInt();
        
        // 베라가 입을 수 있는 옷의 경우의 수는 상의 N가지, 하의는 N-1가지
        int result = N * (N - 1);
        
        // 결과 출력
        System.out.println(result);
        
        scanner.close();
    }
}
