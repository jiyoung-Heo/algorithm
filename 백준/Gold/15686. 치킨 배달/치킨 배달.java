
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static ArrayList<int[]> chickenList = new ArrayList<>();
	static int n, m;
	static int minNum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 최대 50
		n = Integer.parseInt(st.nextToken());
		// 최대 13
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 치킨집인 경우 해당 좌표를 list에 저장하기
				if (arr[i][j] == 2) {
					chickenList.add(new int[] { i, j });
				}
			}
		}

		dfs(chickenList.size(), 0);

		System.out.println(minNum);
	}

	private static void dfs(int chikenCount, int index) {
		if (chikenCount == m) {
			int sum = 0;
			// 거리 측정하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int oneMinNum = Integer.MAX_VALUE;
						for (int[] chicken : chickenList) {
							if(chicken != null) {
								oneMinNum = Math.min(Math.abs(i - chicken[0]) + Math.abs(j - chicken[1]), oneMinNum);
							}
						}
						sum += oneMinNum;
					}
				}
			}
			minNum = Math.min(sum, minNum);
		} else {
			for (int i = index; i < chickenList.size(); i++) {
				int[] removeChiken = chickenList.get(i);
				// m개만 남아야함. remove
				chickenList.set(i, null);
				dfs(chikenCount - 1, index + 1);
				// 다시 add
				chickenList.set(i, removeChiken);
				index ++;
			}
		}
	}
}
