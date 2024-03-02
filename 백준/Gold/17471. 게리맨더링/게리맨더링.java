import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int result = Integer.MAX_VALUE;
	static ArrayList<Integer>[] linkList;
	static int[] arr;
	static boolean[] visited;
	// 지역구 2개
	static ArrayList<Integer> a;
	static ArrayList<Integer> b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 구역 개수 N
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		linkList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			linkList[i] = new ArrayList<Integer>();
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				linkList[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		// 조합 구하기
		for (int i = 1; i < n - 1; i++) {
			combination(0, 0, i);
		}
		if (n == 2) {
			System.out.println(Math.abs(arr[0] - arr[1]));
			System.exit(0);
		}

		// 연결성 조회하기
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void combination(int index, int count, int targetCount) {
		if (count >= targetCount) {
			return;
		}
		while (index < n) {
			visited[index] = true;
			combination(index + 1, count + 1, targetCount);
			if (count + 1 == targetCount) {
				// 지역구 2개 따로 저장하기
				setCombination();
				// 연결성 조회하기
				boolean isConA = isConnected(a);
				boolean isConB = isConnected(b);

				if (isConA && isConB) {
					// 연결되어있는것임
					result = Math.min(getDiff(), result);
				}
			}

			visited[index] = false;
			index++;
		}
	}

	/**
	 * 두 지역구간 차를 구해준다. 
	 * @return
	 */
	private static int getDiff() {
		int sumA = 0;
		for (int i = 0; i < a.size(); i++) {
			sumA += arr[a.get(i)];
		}
		int sumB = 0;
		for (int i = 0; i < b.size(); i++) {
			sumB += arr[b.get(i)];
		}

		return Math.abs(sumA - sumB);
	}

	/**
	 * 두개의 지역구로 나눠서 저장해준다. a,b리스트
	 */
	private static void setCombination() {
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				a.add(i);
			} else {
				b.add(i);
			}
		}
	}

	/**
	 * 하나의 지역구 내 노드가 서로 연결되어있는지 체크
	 * @param list
	 * @return
	 */
	private static boolean isConnected(ArrayList<Integer> list) {
		boolean[] isConnected = new boolean[n];
		Queue<Integer> que = new ArrayDeque<Integer>();
		int index = 0;

		if (list.size() >= 0) {
			que.add(list.get(0));
			isConnected[list.get(0)] = true;
			index++;
		}
		while (!que.isEmpty()) {
			int startIndex = que.poll();

			for (int i = 0; i < linkList[startIndex].size(); i++) {
				int temp = linkList[startIndex].get(i);
				if (list.contains(temp) && !isConnected[temp]) {
					que.add(temp);
					isConnected[temp] = true;
					index++;
				}
			}

		}
		return index == list.size();
	}
}
