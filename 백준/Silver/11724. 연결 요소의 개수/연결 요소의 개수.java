import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visited[];
	static int n;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a].add(b);
			arr[b].add(a);
		}

		connectedCount();
		System.out.println(count);
	}

	private static void connectedCount() {
		Queue<Integer> que = new ArrayDeque<>();
		
		int endCheck = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) {
				que.add(i);
				break;
			} else {
				endCheck++;
			}
		}
		
		if (endCheck == n) {
			return;
		}

		while (!que.isEmpty()) {
			int pollInteger = que.poll();
			visited[pollInteger] = true;
			for (int i = 0; i < arr[pollInteger].size(); i++) {
				if (!visited[arr[pollInteger].get(i)]) {
					visited[arr[pollInteger].get(i)] = true;
					que.add(arr[pollInteger].get(i));
				}
			}
		}
		count++;
		connectedCount();
	}
}
