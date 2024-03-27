import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			sb = new StringBuilder();
			sb.append("#" + i + " ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n];
			for (int j = 0; j < n; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (num == 0) {
					parent[findSet(b)] = findSet(a);
				} else if (num == 1) {
					// a,b가 같은 집합인지를 확인하는 연산
					if (findSet(a) == findSet(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			System.out.println(sb.toString());
		}
	}

	static int findSet(int x) {
		if (parent[x] != x) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}
}
