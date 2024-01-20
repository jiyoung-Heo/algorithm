package 골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {
	static boolean[] visit;
	static List<Integer>[] friend;
	static int n, m, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		friend = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			friend[i] = new ArrayList<>();
		}
		visit = new boolean[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());

			friend[person1].add(person2);
			friend[person2].add(person1);
		}
		result = 0;

		for (int i = 0; i < n; i++) {
			if (result ==1) {
				break;
			}
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, 0);
				visit[i] = false;
			}

		}

		System.out.println(result);
	}

	public static void dfs(int x, int dist) {
		if (dist == 4) {
			result = 1;
			return;
		}

		for (int i = 0; i < friend[x].size(); i++) {
			if (!visit[friend[x].get(i)]) {
				visit[friend[x].get(i)] = true;
				dfs(friend[x].get(i), dist + 1);
				visit[friend[x].get(i)] = false;
			}
		}

	}
}