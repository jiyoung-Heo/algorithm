
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = Integer.MAX_VALUE;
		int start = n / 5;
		// 5에 나눠 떨어지는 수 라면 그대로 리턴
		if (n % 5 == 0) {
			System.out.println(n / 5);
			return;
		}
		// 5에 나눠 떨어지지 않으면 1씩 빼 가면서 /3의 나머지가 없는지 체크
		// 만약에 끝까지 없으면 -1 출력
		for (int i = start; i >= 0; i--) {
			if (n > 5 * i) {
				if ((n - (5 * i)) % 3 != 0) {
					continue;
				} else {
					result = Math.min(result, i + ((n - (5 * i)) / 3));
				}
			}
		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
