package 실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거리가k이하인트리노드에서사과수확하기_25516 {
	static int[] appleArr;
	static int k, depth;
	static int sum;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// 부모
			int p = Integer.parseInt(st.nextToken());
			// 자식
			int c = Integer.parseInt(st.nextToken());
			list[p].add(c);
		}

		st = new StringTokenizer(br.readLine());
		appleArr = new int[n];
		for (int i = 0; i < n; i++) {
			appleArr[i] = Integer.parseInt(st.nextToken());
		}
		bfs(0);
		System.out.println(sum);
	}

	public static void bfs(int node) {
		Queue<Integer> que = new LinkedList<>();

		if (appleArr[node] == 1)
			sum++;
		que.add(node);

		while (!que.isEmpty()) {
			if (depth > k)
				return;
			depth++;
			int pollNode = que.poll();
			List<Integer> pollNodeList = list[pollNode];
			for (int i = 0; i < pollNodeList.size(); i++) {
				if (appleArr[pollNodeList.get(i)] == 1)
					sum++;
				que.add(pollNodeList.get(i));
			}
		}

	}
}
