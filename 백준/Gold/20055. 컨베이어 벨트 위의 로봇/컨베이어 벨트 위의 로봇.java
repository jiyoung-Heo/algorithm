import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[2 * n];
		int[] robot = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <= 2 * n - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		while (true) {
			result++;
			// 1. 회전한다.
			int temp = arr[2 * n - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;

			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
				robot[i - 1] = 0;
			}
			// 끝에 도달하면 내리기
			robot[robot.length - 1] = 0;

			// 2. 로봇을 이동시킨다.
			for (int i = robot.length - 1; i > 0; i--) {
				if (robot[i - 1] != 0 && robot[i] == 0 && arr[i] >= 1) {
					robot[i] = robot[i - 1];
					robot[i - 1] = 0;
					arr[i]--;
				}
			}


			// 3. 올리는 위치의 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (arr[0] > 0 && robot[0] == 0) {
				robot[0]++;
				arr[0]--;
			}

			int count = 0;
			// 4. 0 개수 k 이상일 시 종료
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= 0) {
					count++;
				}
			}

			if (count >= k) {
				System.out.println(result);
				break;
			}

		}
	}
}
