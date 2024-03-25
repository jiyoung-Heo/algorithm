
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int jj = 0; jj < n; jj++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();
			String result = "";
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < number; j++) {
					result += arr[i];
				}
			}
			System.out.println(result);
		}
	}
}
