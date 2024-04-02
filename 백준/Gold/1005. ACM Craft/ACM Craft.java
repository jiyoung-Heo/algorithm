
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			// 건물의개수
			int n = Integer.parseInt(st.nextToken());
			// 건물간의 건설순서 규칙
			int k = Integer.parseInt(st.nextToken());

			int[] count = new int[n + 1];
			ArrayList<Integer>[] arr = new ArrayList[n + 1];
			for (int j = 0; j < n + 1; j++) {
				arr[j] = new ArrayList<>();
			}
			int[] time = new int[n + 1];

			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x].add(y);
				count[y]++;
			}
			int w = Integer.parseInt(br.readLine());
			// 건물 W를 건설완료 하는데 드는 최소 시간을 출력한다

			Queue<Integer> que = new ArrayDeque<>();
			boolean flag = false;
			int startTime = 0;
			for (int j = 1; j <= n; j++) {
				if (count[j] == 0) {
					if (j == w) {
						flag = true;
						System.out.println(time[j]);
					}
					que.add(j);
					startTime = Math.max(startTime, time[j]);
				}
			}
			if (flag) {
				continue;
			}
			int[] result = new int[n + 1];
			Arrays.fill(result, Integer.MIN_VALUE);
			while (!que.isEmpty()) {
				int indexNum = que.poll();
				result[indexNum] = Math.max(result[indexNum], time[indexNum]);
				for (int j = 0; j < n + 1; j++) {
					if (arr[indexNum].contains((Object) j)) {
						result[j] = Math.max(time[j] + result[indexNum], result[j]);
						count[j]--;
						arr[indexNum].remove((Object) j);
						if (count[j] == 0) {
							que.add(j);
						}
					}
				}
			}
			if (result[w] != Integer.MIN_VALUE) {
				System.out.println(result[w]);
			}
		}
	}
}
