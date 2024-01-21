package 실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트 {
	static int[] dirX = { 2, 2, 1, 1, -2, -2, -1, -1 };
	static int[] dirY = { 1, -1, 2, -1, 1, -1, 2, -2 };
	static int[][] arr;
	static int n, m;
	static int hitCount;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		arr = new int[m + 1][2];
		result = new int[m+1];

		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		bfs(x, y);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		int count = 0;
		
		que.add(new int[] { x, y });

		while (!que.isEmpty()) {
			int[] pollArr = que.poll();
			count++;
			for (int i = 0; i < dirX.length; i++) { // for문 도는 것 만큼 count가 증가될 것 같음.
				int nextX = pollArr[0] + dirX[i];
				int nextY = pollArr[1] + dirY[i];
				if (nextX < 0 || nextY < 0 || nextX > n || nextY > n)
					continue;
				
				for (int j = 1; j < m + 1; j++) {
					int endX = arr[j][0];
					int endY = arr[j][1];
					if (endX == nextX && nextY == endY) {
						hitCount++;
						result[j] = count;
						
						if(hitCount == m) {
							System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]);
							return;
						}
					}
				}
				que.add(new int[] { nextX, nextY });
			}
		}
	}
}
