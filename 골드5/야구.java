package 골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3:-3
public class 야구 {
//	static int[] 타순 = new int[10];
	// 타순 리스트
	static int[] lineUp = new int[10];
	static int[][] player;
	static boolean[] visit = new boolean[10];
	static int n;
	static int deathSUm = 0;
	static int maxSum = 0;
	static int currSum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		player = new int[n][10];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[4] = true;
		lineUp[4] = 1;

		dfs(2);
		if (maxSum > currSum / 4) {
			maxSum = currSum / 4;
		}
		System.out.println(maxSum);
	}

	public static void dfs(int count) {
		if (count == 10) {
			currSum = 0;
			int currPlayer = 1;
			// 이닝 돌기
			for (int i = 0; i < n; i++) {
				int sum = 0;
				int deathCount = 0;
				while (deathCount < 3) {
					sum += player[i][lineUp[currPlayer]];
					if (player[i][lineUp[currPlayer]] == 0) {
						deathCount++;
					}
					if (currPlayer == 9) {
						currPlayer = 1;
					} else {
						currPlayer++;
					}
				}
				currSum += sum;
			}
			if (maxSum < currSum / 4) {
				maxSum = currSum / 4;
			}
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!visit[i]) {
					visit[i] = true;
					lineUp[i] = count;
					dfs(count + 1);
					visit[i] = false;
				}
			}
		}
	}
}
