
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		n = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int m = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점의 번호
		int v = Integer.parseInt(st.nextToken());

		arr = new boolean[n + 1][n + 1];
		// 5:10
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = true;
			arr[b][a] = true;
		}

		visited = new boolean[n + 1];
		dfs(v);

		System.out.println();

		visited = new boolean[n + 1];
		bfs(v);
	}

	public static void dfs(int number) {
		visited[number] = true;
		System.out.print(number + " ");

		if (number == n + 1)
			return;

		for (int i = 1; i <= n; i++) {
			if (arr[number][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int number) {
		Queue<Integer> que = new LinkedList<>();

		que.add(number);
		visited[number] = true;
		System.out.print(number + " ");

		while (!que.isEmpty()) {
			int temp = que.poll();
			for (int i = 1; i <= n; i++) {
				if (arr[temp][i] && !visited[i]) {
					que.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
