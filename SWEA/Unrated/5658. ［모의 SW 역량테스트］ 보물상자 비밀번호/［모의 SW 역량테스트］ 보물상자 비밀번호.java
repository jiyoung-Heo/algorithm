import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			char[] arr = br.readLine().toCharArray();
			PriorityQueue<String> que = new PriorityQueue(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return Integer.parseInt(o1, 16) > Integer.parseInt(o2, 16) ? -1 : 1;
				}
			});
			for (int i = 0; i < arr.length; i++) {
				String numberString = "";
				for (int j = 0; j < arr.length / 4; j++) {
					if (i + j >= n) {
						numberString += String.valueOf(arr[i + j - n]);
						continue;
					}
					numberString += String.valueOf(arr[i + j]);
				}
				que.add(numberString);
			}
			String temp = "";
			for (int i = 0; i < k; i++) {
				while (temp.equals(que.peek())) {
					que.poll();
				}
				temp = que.poll();
			}
			System.out.println("#" + t + " " + Integer.parseInt(temp, 16));
		}
	}
}
