package 브론즈2;

import java.util.Scanner;

public class ox퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			String a = sc.next();
			String[] arr = a.split("");
			int cnt = 0;
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals("X")) {
					for (int j2 = 1; j2 <= cnt; j2++) {
						sum += j2;
					}
					cnt = 0;
					continue;
				}
				cnt++;
			}
			if (cnt > 0) {
				for (int j2 = 1; j2 <= cnt; j2++) {
					sum += j2;
				}
			}
			System.out.println(sum);
		}
	}
}
