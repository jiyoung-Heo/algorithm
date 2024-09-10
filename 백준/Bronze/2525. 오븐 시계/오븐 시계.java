import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 시(hour)와 분(minute)을 입력 받음
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        // 추가로 더할 분(minutes)를 입력 받음
        int cookTime = sc.nextInt();

        // 분에 조리 시간을 더함
        minute += cookTime;

        // 분이 60 이상일 경우 시간을 증가시키고, 분을 60으로 나눈 나머지를 사용
        while (minute >= 60) {
            minute -= 60;
            hour++;
        }

        // 시간이 24 이상일 경우 24시간제로 맞춤
        if (hour >= 24) {
            hour -= 24;
        }

        // 결과 출력
        System.out.println(hour + " " + minute);
    }
}
