import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 숫자를 입력받음
        String num1 = sc.next();
        String num2 = sc.next();

        // 문자열을 뒤집어서 정수로 변환
        int reversedNum1 = Integer.parseInt(new StringBuilder(num1).reverse().toString());
        int reversedNum2 = Integer.parseInt(new StringBuilder(num2).reverse().toString());

        // 더 큰 숫자를 출력
        System.out.println(Math.max(reversedNum1, reversedNum2));

        sc.close();
    }
}
