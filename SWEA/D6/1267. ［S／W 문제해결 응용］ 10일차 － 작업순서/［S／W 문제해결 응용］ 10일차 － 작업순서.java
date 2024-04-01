import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; i++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int[][] edge = new int[v + 1][v + 1];
			int[] degree = new int[v + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < e; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edge[a][b] = 1;
				degree[b]++;
			}
			Queue<Integer> que = new ArrayDeque<Integer>();
			for (int j = 1; j < degree.length; j++) {
				if (degree[j] == 0) {
					que.add(j);
				}
			}
			sb.append("#" + i + " ");
			while (!que.isEmpty()) {
				int curr = que.poll();
				sb.append(curr + " ");
				for (int j = 0; j < v + 1; j++) {
					if (edge[curr][j] == 1) {
						degree[j]--;
						edge[curr][j] = 0;
						if (degree[j] == 0) {
							que.add(j);
						}
					}
				}
			}

			System.out.println(sb + "\n");
		}
	}
}
