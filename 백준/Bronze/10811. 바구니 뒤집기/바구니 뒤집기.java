import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        

        int n = sc.nextInt(); // 바구니의 개수

        int m = sc.nextInt(); // 바꿔야 할 횟수

        

        int[] baskets = new int[n];

        

        // 바구니 초기화

        for (int i = 0; i < n; i++) {

            baskets[i] = i + 1;

        }

        

        // 바구니 교환

        for (int i = 0; i < m; i++) {

            int start = sc.nextInt() - 1; // 0-indexed

            int end = sc.nextInt() - 1; // 0-indexed

            

            while (start < end) {

                int temp = baskets[start];

                baskets[start] = baskets[end];

                baskets[end] = temp;

                start++;

                end--;

            }

        }

        

        // 결과 출력

        for (int i = 0; i < n; i++) {

            System.out.print(baskets[i] + " ");

        }

        

        sc.close();

    }

}

