import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n, m;
	static int resultMaxNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		findCard(0, 0, 0);
		System.out.println(resultMaxNum);
	}

	private static void findCard(int count, int index, int sum) {
		if (count >= 3) {
			if (sum <= m) {
				resultMaxNum = Math.max(resultMaxNum, sum);
			}
			return;
		}
		if (index >= n) {
			return;
		}

		// 카드 선택하는경우
		findCard(count + 1, index + 1, sum + arr[index]);
		// 카드 선택 안하는경우
		findCard(count, index + 1, sum);
	}
}
